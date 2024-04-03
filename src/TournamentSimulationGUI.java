import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * * Shows score tables for each team */
public class TournamentSimulationGUI extends JFrame {
    private static final int NUM_TEAMS = 16;
    private static final int NUM_GAMES = 2 * 15;
    private static boolean isPaused = false;
    private static List<JLabel> teamLabels;
    private static List<Team> playoffTeams;
    private static Timer timer;
    

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    static JToggleButton pauseResumeButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TournamentSimulationGUI frame = new TournamentSimulationGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /** @param teams Is a list of teams
     * updates the jlabels*/

    private static void updateTeamLabels(List<Team> teams) {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < teams.size(); i++) {
                Team team = teams.get(i);
                JLabel label = teamLabels.get(i);
                label.setText(team.toString("sth"));
            }
            contentPane.repaint();
            contentPane.revalidate();
        });
        try {
            Thread.sleep(100); // Delay for specified milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Team> getPlayoffTeams() {
        return playoffTeams;
    }

    public void setPlayoffTeams(List<Team> playoffTeams) {
        this.playoffTeams = playoffTeams;
    }

    public TournamentSimulationGUI() {
        teamLabels = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.textHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("SCORE TABLE");
        lblNewLabel_1.setForeground(SystemColor.controlHighlight);
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(237, 6, 144, 39);
        contentPane.add(lblNewLabel_1);

        List<Team> teams = Drafting.getObTeams();
        for (int i = 0; i < teams.size(); i++) {
            JLabel label = new JLabel(teams.get(i).toString("sth"));
            label.setBounds(56, 78 + i * 28, 415, 16);
            contentPane.add(label);
            teamLabels.add(label);
        }

        JButton btnNewButton = new JButton("START");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGroupStage(teams);                
                timer.start();
            }
        });
        btnNewButton.setBounds(45, 14, 117, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("NEXT");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                //playPlayoff(playoffTeams);

                Top8 top = new Top8();
                top.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(464, 14, 117, 29);
        contentPane.add(btnNewButton_1);
        
        pauseResumeButton = new JToggleButton("PAUSE");
        pauseResumeButton.setBounds(433, 519, 161, 29);
        contentPane.add(pauseResumeButton);
        

        pauseResumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                synchronized (pauseResumeButton) {
                    isPaused = !isPaused;
                    pauseResumeButton.setText(isPaused ? "RESUME" : "PAUSE");
                    if (!isPaused) {
                        pauseResumeButton.notifyAll();
                    }
                }
            }
        });
        

        // Create a timer to update the score table every 0.1 seconds
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTeamLabels(Drafting.getObTeams());
            }
        });
        timer.setRepeats(true);
    }
    /** @param teams Is a list of teams
     * plays the season matches*/

     static void playGroupStage(List<Team> teams) {
        new Thread(() -> { // Run the game loop in a separate thread
            int numTeams = teams.size();
    
            for (int i = 0; i < numTeams; i++) {
                Team team = teams.get(i);
    
                // Play against all other teams
                for (int j = 0; j < numTeams; j++) {
                    if (i != j) {
                        Team opponent = teams.get(j);
                        Team winnerTeam = simulateGame(team, opponent);
    
                        SwingUtilities.invokeLater(() -> { // Update GUI on the EDT
                            updateTeamLabels(teams);
                        });
    
                        try {
                            Thread.sleep(100); // Wait for 0.1 seconds between matches
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt(); // Handle interrupted exception
                        }
    
                        logGroupMatches(team, opponent, winnerTeam);
    
                        synchronized (pauseResumeButton) {
                            while (isPaused) {
                                try {
                                    pauseResumeButton.wait();
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                }
            }
            logGroupResults(teams);
            Collections.sort(teams, (team1, team2) -> Integer.compare(team2.getWins(), team1.getWins()));
            // Update GUI with sorted teams
            SwingUtilities.invokeLater(() -> {
                updateTeamLabels(teams);
            });
            playoffTeams = selectPlayoffTeams(teams);
        }).start(); // Start the thread
    }
    
    /** @param team Is a list of team
     * @param opponent Is the opponent of the first parameter
     * @param winner Is who wins the match
     * logs info to a file*/
    
    static void logGroupMatches(Team team, Team opponent, Team winner) {
    	try {
            // Append the user information to the "users.txt" file
            File file = new File("seasonMatches.txt");
            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Format the user information as needed
            String teamInfo = team.getTeamName() + " vs " + opponent.getTeamName() + " Winner is: " + winner.getTeamName() + " " + team.getTeamName() + "'s Score: " + team.getScore() + " " + opponent.getTeamName() + "'s Score: " + opponent.getScore() +"\n";
            writer.write(teamInfo);
            writer.close();



        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    /** @param teams Is a list of teams
     * logs info to a file*/
    
    static void logGroupResults(List<Team> teams) {
    	try {
            // Append the user information to the "users.txt" file
            File file = new File("seasonResults.txt");
            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String teamInfo = "";
            
            for (int i = 0; i < teams.size(); i++) {
                Team team = teams.get(i);
                teamInfo += team.toString("sth") + "\n";
            }

            // Format the user information as needed
            writer.write(teamInfo);
            writer.close();



        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    /** @param team1 Is a team
     * @param team2 Is a team
     * plays a game between team1 and team2*/

    static Team simulateGame(Team team1, Team team2) {
        double homeMultiplier = 1.05;
        double team1Score = team1.getScore();
        double team2Score = team2.getScore();

        team1Score *= homeMultiplier;

        if (team1Score > team2Score) {
            team1.setWins(team1.getWins() + 1);
            team2.setLosses(team2.getLosses() + 1);
            System.out.println(team1 + " vs " + team2 + " scores are " + team1Score + "   " + team2Score);
            return team1;
        } else if (team1Score == team2Score) {
            team1.setTies(team1.getTies() + 1);
            team2.setTies(team2.getTies() + 1);
            return team1;
        } else {
            team1.setLosses(team1.getLosses() + 1);
            team2.setWins(team2.getWins() + 1);
            return team2;
        }
    }
    
    /** @param teams Is a list of teams
     * @return top 8 teams
     * */
    static List<Team> selectPlayoffTeams(List<Team> teams) {
        Collections.sort(teams, (team1, team2) -> Integer.compare(team2.getWins(), team1.getWins()));
        return teams.subList(0, 8);
    }

    static List<JLabel> lbls = new ArrayList<>();
    
    /** 
     * simulates the playoff tournament*/
    
    public static void playPlayoff() {
        Tree tree = new Tree();
        tree.setVisible(true);

        lbls = tree.getJlblArr();
        System.out.println("Playoff Bracket:");
        int counter = 1;
        while (playoffTeams.size() > 1) {
            List<Team> winners = new ArrayList<>();

            for (int i = 0; i < playoffTeams.size(); i += 2) {
                Team team1 = playoffTeams.get(i);
                Team team2 = playoffTeams.get(i + 1);

                lbls.get(i).setText(team1.getTeamName());
                lbls.get(i+1).setText(team2.getTeamName());
                tree.setJlblArr(lbls);

                Team winnerTeam = simulateGame(team1, team2);

                winners.add(winnerTeam);

                logPlayoffMatches(team1, team2, winnerTeam);

                waitForGame();
            }
            counter++;
            
            playoffTeams = winners;
            updateTreeLabels(counter, tree, winners);
        }
    }

    private static void updateTreeLabels(int counter, Tree tree, List<Team> winners) {
        switch (counter) {
            case 2:
                lbls = tree.getJlblArr2();
                break;
            case 3:
                lbls = tree.getJlblArr3();
                break;
            case 4:
                tree.getChampionLabel().setText(winners.get(0).getTeamName());
                logChampion(winners.get(0));
                break;
        }
    }

    private static void waitForGame() {
        // Wait for 0.1 seconds between matches
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (pauseResumeButton) {
            while (isPaused) {
                try {
                    pauseResumeButton.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /** @param team Is a list of team
     * @param opponent Is the opponent of the first parameter
     * @param winner Is who wins the match
     * logs info to a file*/
    static void logPlayoffMatches(Team team, Team opponent, Team winner) {
    	try {
            // Append the user information to the "users.txt" file
            File file = new File("playoffMatches.txt");
            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Format the user information as needed
            String teamInfo = team.getTeamName() + " vs " + opponent.getTeamName() + " Winner is: " + winner.getTeamName() + "\n";
            writer.write(teamInfo);
            writer.close();



        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    /** @param team Is a team
     * logs info to a file*/
    static void logChampion(Team team) {
    	try {
            // Append the user information to the "users.txt" file
            File file = new File("playoffMatches.txt");
            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Format the user information as needed
            String teamInfo = team.getTeamName() + " is the champion! " + "\n";
            writer.write(teamInfo);
            writer.close();



        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}