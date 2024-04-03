	
	
	
import java.awt.EventQueue;


import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.SystemColor;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	import positions.Player;
	
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JList;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JToggleButton;
	import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

/** GUI page for drafting that has drafting methods.*/
	public class Drafting extends JFrame {
	    private static final long serialVersionUID = 1L;
		JList<Player> team1List = new JList<>();
	    JList<Player> team2List = new JList<>();
	    JList<Player> team3List = new JList<>();
	    JList<Player> team4List = new JList<>();
	    JList<Player> team5List = new JList<>();
	    JList<Player> team6List = new JList<>();
	    JList<Player> team7List = new JList<>();
	    JList<Player> team8List = new JList<>();
	    JList<Player> team9List = new JList<>();
	    JList<Player> team10List = new JList<>();
	    JList<Player> team11List = new JList<>();
	    JList<Player> team12List = new JList<>();
	    JList<Player> team13List = new JList<>();
	    JList<Player> team14List = new JList<>();
	    JList<Player> team15List = new JList<>();
	    JList<Player> team16List = new JList<>();
	    int counter = 5;
		private JPanel contentPane;
		

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Drafting frame = new Drafting();
						frame.setVisible(true);
	
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}


        JComboBox playerComboBox = new JComboBox();
		List<Player> team1 = new ArrayList<>();
		List<Player> team2 = new ArrayList<>();
		List<Player> team3 = new ArrayList<>();
		List<Player> team4 = new ArrayList<>();
		List<Player> team5 = new ArrayList<>();
		List<Player> team6 = new ArrayList<>();
		List<Player> team7 = new ArrayList<>();
		List<Player> team8 = new ArrayList<>();
		List<Player> team9 = new ArrayList<>();
		List<Player> team10 = new ArrayList<>();
		JButton btnNewButton_1 = new JButton("SUBMIT");
	
		List<Player> team11 = new ArrayList<>();
		List<Player> team12 = new ArrayList<>();
		List<Player> team13 = new ArrayList<>();
		List<Player> team14 = new ArrayList<>();
		List<Player> team15 = new ArrayList<>();
		List<Player> team16 = new ArrayList<>();
		static List<Team> obTeams = new ArrayList<>();
	
		static ArrayList<List<Player>> teams = new ArrayList<>();
		static Random random1= new Random();
		private static final int userQueue = selectUserTeam();
		

	
	
		public static ArrayList<List<Player>> getTeams() {
			return teams;
		}
		public void setTeams(ArrayList<List<Player>> teams) {
			this.teams = teams;
		}
		public static int getUserqueue() {
			return userQueue;
		}
		/** Creating teams list by adding teams into it*/
		private void adjustTeams(){
			teams.add(0, null);
			teams.add(1, team1);
			teams.add(2, team2);
			teams.add(3, team3);
			teams.add(4, team4);
			teams.add(5, team5);
			teams.add(6, team6);
			teams.add(7, team7);
			teams.add(8, team8);
			teams.add(9, team9);
			teams.add(10,team10);
			teams.add(11,team11);
			teams.add(12,team12);
			teams.add(13,team13);
			teams.add(14,team14);
			teams.add(15,team15);
			teams.add(16,team16);
			

		}
		/** Getter for every JList
		 * @param teamIndex Is team's number*/
	    private JList<Player> getTeamList(int teamIndex) {
	        switch (teamIndex) {
	            case 1: return team1List;
	            case 2: return team2List;
	            case 3: return team3List;
	            case 4: return team4List;
	            case 5: return team5List;
	            case 6: return team6List;
	            case 7: return team7List;
	            case 8: return team8List;
	            case 9: return team9List;
	            case 10: return team10List;
	            case 11: return team11List;
	            case 12: return team12List;
	            case 13: return team13List;
	            case 14: return team14List;
	            case 15: return team15List;
	            case 16: return team16List;

	            default: return null;
	        }
	    }
	    /** Determines user's team number by giving random number between 1 and 16 */
	    private static int selectUserTeam() {
	        int userTeam = random1.nextInt(16) + 1;
	        return userTeam;
	    	
	    }
	    
	    /** 
	     * @param a user's queue
	     * @param centerPlayerList list of center players
	     * Drafts the center players*/
		private void CenterRandomize(int a, List centerPlayerList) {
		    if (centerPlayerList.isEmpty()) {
		        return;
		    }
		    if (counter ==5) {
	
	        for (int i=1; i<a; i++) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(centerPlayerList.size()-1)+1;
	            Player picked_player = (Player) centerPlayerList.get(indexNumber);
	            teams.get(i).add(picked_player);
	            centerPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(i), teams.get(i));


	        	
	        	
	        	
	        }
	        // input al hangi oyuncuyu istediğine göre

	        playerComboBox.removeAllItems();
	        for (Object player : centerPlayerList) {
	            playerComboBox.addItem(player);
	        }
	        playerComboBox.setBounds(440, 122, 52, 27);
	        contentPane.add(playerComboBox);
	        contentPane.revalidate();
	        contentPane.repaint();
		    }

	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
	                if (selectedPlayer != null && counter ==5) {
	                    teams.get(a).add(selectedPlayer);
	                    centerPlayerList.remove(selectedPlayer);
	                    counter--;
	                    updateTeamList(getTeamList(a), teams.get(a));
	                    System.out.println(selectedPlayer);
	        	        contentPane.revalidate();
	        	        contentPane.repaint();

	                    System.out.println(counter);
	                }
	            }
	        });
	        if (counter==4) {
	        for (int j = a+1; j<17; j++) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(centerPlayerList.size()-1)+1;
	            Player picked_player = (Player) centerPlayerList.get(indexNumber);
	            teams.get(j).add(picked_player);
	            updateTeamList(getTeamList(j), teams.get(j));
	            centerPlayerList.remove(picked_player);
	        	
	        }
	        }
	        
	        
	        
		}
	
	    /** 
	     * @param a user's queue
	     * @param powerForwardPlayerList list of pf players
	     * Drafts the pf players*/
		private void PFRandomize(int a, List powerForwardPlayerList) {
			if (counter==3) {
	
	        for (int i=1; i<a; i++) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(powerForwardPlayerList.size()-1)+1;
	            Player picked_player = (Player) powerForwardPlayerList.get(indexNumber);
	            teams.get(i).add(picked_player);
	            powerForwardPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(i), teams.get(i));
	        	
	        	
	        	
	        
	        }

	        playerComboBox.removeAllItems();
	        for (Object player : powerForwardPlayerList) {
	            playerComboBox.addItem(player);
	        }
	        playerComboBox.setBounds(440, 122, 52, 27);
	        contentPane.add(playerComboBox);
	        contentPane.revalidate();
	        contentPane.repaint();
	        

	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
	                if (selectedPlayer != null && counter ==3) {
	                    teams.get(a).add(selectedPlayer);
	                    powerForwardPlayerList.remove(selectedPlayer);
	                    updateTeamList(getTeamList(a), teams.get(a));
	                    counter--;
	                }
	            }
	        });
			}

	        	
	        if (counter ==2) {
	        	System.out.println("will you print sth");
	        for (int j = a+1; j<17; j++) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(powerForwardPlayerList.size()-1)+1;
	            Player picked_player = (Player) powerForwardPlayerList.get(indexNumber);
	            teams.get(j).add(picked_player);
	            powerForwardPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(j), teams.get(j));
	            
	        	
	        }
	        }
	        
	        
	        
	        
		}
		
	    /** 
	     * @param a user's queue
	     * @param shootingGuardPlayerList list of sg players
	     * Drafts the sg players*/
		private void SGRandomize(int a, List shootingGuardPlayerList) {
			if (counter==1) {
			System.out.println("heresg");
			
	
	        for (int i=1; i<a; i++) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(shootingGuardPlayerList.size()-1)+1;
	            Player picked_player = (Player) shootingGuardPlayerList.get(indexNumber);
	            teams.get(i).add(picked_player);
	            shootingGuardPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(i), teams.get(i));
	        	
	        	
	        	
	        }

	        playerComboBox.removeAllItems();
	        for (Object player : shootingGuardPlayerList) {
	            playerComboBox.addItem(player);
	        }
	        playerComboBox.setBounds(440, 122, 52, 27);
	        contentPane.revalidate();
	        contentPane.repaint();
	        contentPane.add(playerComboBox);
	        contentPane.revalidate();
	        contentPane.repaint();
	        

	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("counter11"+counter);
	                Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
	                if (selectedPlayer != null && counter ==1) {
	                    teams.get(a).add(selectedPlayer);
	                    shootingGuardPlayerList.remove(selectedPlayer);
	                    updateTeamList(getTeamList(a), teams.get(a));
	                    counter--;
	                    System.out.println("counter"+counter);
	                    System.out.println("sg");
	                    
	                }
	            }
	        });
			}
	        if (counter == 0) {
	            System.out.println("counter11" + counter);

	            for (int j = a + 1; j < 17; j++) {
	                System.out.println(j + "jjjj");
	                Random random = new Random();
	                int indexNumber = random.nextInt(shootingGuardPlayerList.size() - 1) + 1;
	                Player picked_player = (Player) shootingGuardPlayerList.get(indexNumber);
	                teams.get(j).add(picked_player);
	                shootingGuardPlayerList.remove(picked_player);
	                updateTeamList(getTeamList(j), teams.get(j));
	                

	            }
	            counter--;
	        }
	        
	        
	        
	        
		}
		
		public static List<Team> getObTeams() {
			return obTeams;
		}
		public void setObTeams(List<Team> obTeams) {
			this.obTeams = obTeams;
		}
		/** 
	     * @param a user's queue
	     * @param smallForwardPlayerList list of sf players
	     * Drafts the sf players*/
		private void SFRandomize(int a, List smallForwardPlayerList) {
		    if (smallForwardPlayerList.isEmpty()) {
		        // Handle the case when the player list is empty
		        return;
		    }
		    if (counter==4) {
	
	        for (int i=16; i>a; i--) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(smallForwardPlayerList.size());
	            Player picked_player = (Player) smallForwardPlayerList.get(indexNumber);
	            teams.get(i).add(picked_player);
	            smallForwardPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(i), teams.get(i));
	        	
	        	
	        	
	        }

	        playerComboBox.removeAllItems();
	        for (Object player : smallForwardPlayerList) {
	            playerComboBox.addItem(player);
	        }
	        playerComboBox.setBounds(440, 122, 52, 27);
	        contentPane.add(playerComboBox);
	        contentPane.revalidate();
	        contentPane.repaint();
	        
		    }
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
	                if (selectedPlayer != null && counter ==4) {
	                    teams.get(a).add(selectedPlayer);
	                    smallForwardPlayerList.remove(selectedPlayer);
	                    counter--;
	                    updateTeamList(getTeamList(a), teams.get(a));
	                    System.out.println(selectedPlayer);
	                }
	            }
	        });
	        if(counter==3) {
	        for (int j = a-1; j>0; j--) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(smallForwardPlayerList.size());
	            Player picked_player = (Player) smallForwardPlayerList.get(indexNumber);
	            teams.get(j).add(picked_player);
	            smallForwardPlayerList.remove(picked_player);
	            updateTeamList(getTeamList(j), teams.get(j));
	        	
	        }}
	        
	        
	        
	        
		}
		/** 
	     * @param a user's queue
	     * @param pointGuardPLayerList list of pg players
	     * Drafts the pg players*/
		
		private void PGRandomize(int a, List pointGuardPLayerList) {
		    if (pointGuardPLayerList.isEmpty()) {
		        // Handle the case when the player list is empty
		        return;
		    }
		    if (counter==2) {
		    	System.out.println("printing sth");
	
	        for (int i=16; i>a; i--) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(pointGuardPLayerList.size());
	            Player picked_player = (Player) pointGuardPLayerList.get(indexNumber);
	            teams.get(i).add(picked_player);
	            pointGuardPLayerList.remove(picked_player);
	            updateTeamList(getTeamList(i), teams.get(i));
	        	
	        	
	        	
	        }
		    }

	        playerComboBox.removeAllItems();
	        for (Object player : pointGuardPLayerList) {
	            playerComboBox.addItem(player);
	        }
	        playerComboBox.setBounds(440, 122, 52, 27);
	        contentPane.add(playerComboBox);
	        contentPane.revalidate();
	        contentPane.repaint();
	        

	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
	                if (selectedPlayer != null && counter ==2) {
	                    teams.get(a).add(selectedPlayer);
	                    pointGuardPLayerList.remove(selectedPlayer);
	                    updateTeamList(getTeamList(a), teams.get(a));
	                    counter--;
	                }
	            }
	        });
	        if (counter ==1) {
	        for (int j = a-1; j>0; j--) {
	    		Random random = new Random();
	            int indexNumber = random.nextInt(pointGuardPLayerList.size());
	            Player picked_player = (Player) pointGuardPLayerList.get(indexNumber);
	            teams.get(j).add(picked_player);
	            pointGuardPLayerList.remove(picked_player);
	            updateTeamList(getTeamList(j), teams.get(j));
	            
	        	
	        }
	        }
	        
	        
	        
		}

		
		
		public Drafting() {

		    contentPane = new JPanel();
		    contentPane.setBackground(SystemColor.textHighlight);
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
	        contentPane.add(team1List);
	        contentPane.add(team2List);
	        contentPane.add(team3List);
	        contentPane.add(team4List);
	        contentPane.add(team5List);
	        contentPane.add(team6List);
	        contentPane.add(team7List);
	        contentPane.add(team8List);
	        contentPane.add(team9List);
	        contentPane.add(team10List);
	        contentPane.add(team11List);
	        contentPane.add(team12List);
	        contentPane.add(team13List);
	        contentPane.add(team14List);
	        contentPane.add(team15List);

	        // ... (existing code)

	        // Populate JLists with initial data
	        updateTeamList(team1List, team1);
	        updateTeamList(team2List, team2);
	        updateTeamList(team3List, team3);
	        updateTeamList(team4List, team4);
	        updateTeamList(team5List, team5);
	        updateTeamList(team6List, team6);
	        updateTeamList(team7List, team7);
	        updateTeamList(team8List, team8);
	        updateTeamList(team9List, team9);
	        updateTeamList(team10List, team10);
	        updateTeamList(team11List, team11);
	        updateTeamList(team12List, team12);
	        updateTeamList(team13List, team13);
	        updateTeamList(team14List, team14);
	        updateTeamList(team15List, team15);
	        
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 600);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.textHighlight);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("DRAFTING");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblNewLabel.setBounds(398, 6, 138, 74);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel1 = new JLabel("You are TEAM " + userQueue);
			lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lblNewLabel1.setBounds(398, 30, 138, 74);
			contentPane.add(lblNewLabel1);
			
			JLabel lblNewLabel2 = new JLabel("Do not press any button twice in a row.");
			lblNewLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			lblNewLabel2.setBounds(398, 45, 200, 74);
			contentPane.add(lblNewLabel2);
			
			
			JLabel lblNewLabel_1 = new JLabel("TEAM 1");
			lblNewLabel_1.setBounds(6, 7, 61, 16);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("TEAM 2");
			lblNewLabel_2.setBounds(79, 7, 61, 16);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("TEAM 3");
			lblNewLabel_3.setBounds(152, 7, 61, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("TEAM 4");
			lblNewLabel_4.setBounds(225, 7, 61, 16);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("TEAM 5");
			lblNewLabel_5.setBounds(298, 7, 61, 16);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("TEAM 6");
			lblNewLabel_6.setBounds(6, 176, 61, 16);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("TEAM 7");
			lblNewLabel_7.setBounds(79, 176, 61, 16);
			contentPane.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("TEAM 8");
			lblNewLabel_8.setBounds(150, 176, 61, 16);
			contentPane.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("TEAM 9");
			lblNewLabel_9.setBounds(225, 176, 61, 16);
			contentPane.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("TEAM 10");
			lblNewLabel_10.setBounds(298, 176, 61, 16);
			contentPane.add(lblNewLabel_10);
			
			JLabel lblNewLabel_11 = new JLabel("TEAM 11");
			lblNewLabel_11.setBounds(6, 345, 61, 16);
			contentPane.add(lblNewLabel_11);
			
			JLabel lblNewLabel_12 = new JLabel("TEAM 12");
			lblNewLabel_12.setBounds(79, 345, 61, 16);
			contentPane.add(lblNewLabel_12);
			
			JLabel lblNewLabel_13 = new JLabel("TEAM 13");
			lblNewLabel_13.setBounds(152, 345, 61, 16);
			contentPane.add(lblNewLabel_13);
			
			JLabel lblNewLabel_14 = new JLabel("TEAM 14");
			lblNewLabel_14.setBounds(225, 345, 61, 16);
			contentPane.add(lblNewLabel_14);
			
			JLabel lblNewLabel_15 = new JLabel("TEAM 15");
			lblNewLabel_15.setBounds(298, 345, 61, 16);
			contentPane.add(lblNewLabel_15);
			
			JLabel lblNewLabel_16 = new JLabel("TEAM 16");
			lblNewLabel_16.setBounds(431, 229, 91, 16);
			contentPane.add(lblNewLabel_16);
			

	        // ... Repeat for other teams
	
	        // Set bounds for each JList
	        team1List.setBounds(6, 40, 51, 126);
	        team2List.setBounds(79, 40, 51, 126);
	        
	        // ... Repeat for other teams
	
	        // Add JLists to the content pane
	        contentPane.add(team1List);
	        contentPane.add(team2List);
	        // ... Repeat for other teams

	        
	        

	        team3List.setBounds(152, 40, 51, 126);
	        contentPane.add(team3List);
	        

	        team4List.setBounds(225, 40, 51, 126);
	        contentPane.add(team4List);
	        

	        team5List.setBounds(298, 40, 51, 126);
	        contentPane.add(team5List);
	        

	        team6List.setBounds(6, 207, 51, 126);
	        contentPane.add(team6List);
	        

	        team7List.setBounds(79, 207, 51, 126);
	        contentPane.add(team7List);
	        

	        team8List.setBounds(152, 207, 51, 126);
	        contentPane.add(team8List);
	        

	        team9List.setBounds(225, 207, 51, 126);
	        contentPane.add(team9List);
	        

	        team10List.setBounds(298, 207, 51, 126);
	        contentPane.add(team10List);
	        

	        team11List.setBounds(6, 372, 51, 126);
	        contentPane.add(team11List);
	        

	        team12List.setBounds(79, 373, 51, 126);
	        contentPane.add(team12List);
	        

	        team13List.setBounds(152, 373, 51, 126);
	        contentPane.add(team13List);
	        

	        team14List.setBounds(225, 373, 51, 126);
	        contentPane.add(team14List);
	        

	        team15List.setBounds(298, 372, 51, 126);
	        contentPane.add(team15List);

	        team16List.setBounds(419, 270, 110, 181);
	        contentPane.add(team16List);
	        
	
	        
	        
	        btnNewButton_1.setBounds(419, 176, 117, 29);
	        contentPane.add(btnNewButton_1);
	        
	        JButton btnNewButton = new JButton("START");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnNewButton.setText("CONTINUE");
	        		BasketballPlayerManager.generateLists();
	        		BasketballPlayerManager.removeDuplicatePlayers(BasketballPlayerManager.getPlayerList());
	        		adjustTeams();
	    			System.out.println(userQueue);
					if(counter==5) {CenterRandomize(userQueue, BasketballPlayerManager.getCenterPlayerList());}
					System.out.println(userQueue);
					if(counter==4) {CenterRandomize(userQueue, BasketballPlayerManager.getCenterPlayerList());}
					if (counter==4) {SFRandomize(userQueue, BasketballPlayerManager.getSmallForwardPlayerList());}
					if (counter==3) {SFRandomize(userQueue, BasketballPlayerManager.getSmallForwardPlayerList());}
					if (counter==3) {PFRandomize(userQueue, BasketballPlayerManager.getPowerForwardPlayerList());}
					if (counter==2) {PFRandomize(userQueue, BasketballPlayerManager.getPowerForwardPlayerList());}
					if (counter==2) {PGRandomize(userQueue, BasketballPlayerManager.getPointGuardPlayerList());}
					if (counter==1) {PGRandomize(userQueue, BasketballPlayerManager.getPointGuardPlayerList());}
					if (counter==1) {SGRandomize(userQueue, BasketballPlayerManager.getShootingGuardPlayerList());}
					if (counter==0) {SGRandomize(userQueue, BasketballPlayerManager.getShootingGuardPlayerList());}
					//team1.Team.setPlayers(teams.get(1)); //SOR DİĞERLERİ İÇİN DE YAPMAM GEREKİYOR MUHTEMELEN


			        
					if (counter ==-1) {
				        Team team1o = new Team("team1", "team1.png");
				        Team team2o = new Team("team2", "team2.png");
				        Team team3o = new Team("team3", "team3.png");
				        Team team4o = new Team("team4", "team4.png");
				        Team team5o = new Team("team5", "team5.png");
				        Team team6o = new Team("team6", "team6.png");
				        Team team7o = new Team("team7", "team7.png");
				        Team team8o = new Team("team8", "team8.png");
				        Team team9o = new Team("team9", "team9.png");
				        Team team10o = new Team("team10", "team10.png");
				        Team team11o= new Team("team11", "team11.png");
				        Team team12o = new Team("team12", "team12.png");
				        Team team13o = new Team("team13", "team13.png");
				        Team team14o = new Team("team14", "team14.png");
				        Team team15o = new Team("team15", "team15.png");
				        Team team16o = new Team("team16", "team16.png");
				        team1o.setPlayers(team1);
				        team2o.setPlayers(team2);
				        team3o.setPlayers(team3);
				        team4o.setPlayers(team4);
				        team5o.setPlayers(team5);
				        System.out.println(team1 + "    " + team2);
				        team6o.setPlayers(team6);
				        team7o.setPlayers(team7);
				        team8o.setPlayers(team8);
				        team9o.setPlayers(team9);
				        team10o.setPlayers(team10);
				        team11o.setPlayers(team11);
				        team12o.setPlayers(team12);
				        team13o.setPlayers(team13);
				        team14o.setPlayers(team14);
				        team15o.setPlayers(team15);
				        team16o.setPlayers(team16);
				        team1o.calculatescore();
				        System.out.println("skor yazdırcam: "+ team1o.getScore());
				        team2o.calculatescore();
				        System.out.println(team2o.getScore());
				        team3o.calculatescore();
				        System.out.println(team3o.getScore());
				        team4o.calculatescore();
				        team5o.calculatescore();
				        team6o.calculatescore();
				        team7o.calculatescore();
				        team8o.calculatescore();
				        team9o.calculatescore();
				        team10o.calculatescore();
				        team11o.calculatescore();
				        team12o.calculatescore();
				        team13o.calculatescore();
				        team14o.calculatescore();
				        team15o.calculatescore();
				        team16o.calculatescore();
				     
				        obTeams.add(team1o);
				        obTeams.add(team2o);
				        obTeams.add(team3o);
				        obTeams.add(team4o);
				        obTeams.add(team5o);
				        obTeams.add(team6o);
				        obTeams.add(team7o);
				        obTeams.add(team8o);
				        obTeams.add(team9o);
				        obTeams.add(team10o);
				        obTeams.add(team11o);
				        obTeams.add(team12o);
				        obTeams.add(team13o);
				        obTeams.add(team14o);
				        obTeams.add(team15o);
				        obTeams.add(team16o);
				        System.out.println(obTeams.get(1));
				        System.out.println(obTeams.get(2));
				        System.out.println(obTeams);


				        

				        try {
				            // Append the user information to the "users.txt" file
				            File file = new File("teams.txt");
				            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
				            BufferedWriter writer = new BufferedWriter(fileWriter);

				            // Format the user information as needed
				            String teamInfo = team1o.toString();
				            String teamInfo2 = team2o.toString();
				            String teamInfo3 = team3o.toString();
				            String teamInfo4 = team4o.toString();
				            String teamInfo5 = team5o.toString();
				            String teamInfo6 = team6o.toString();
				            String teamInfo7 = team7o.toString();
				            String teamInfo8 = team8o.toString();
				            String teamInfo9 = team9o.toString();
				            String teamInfo10 = team10o.toString();
				            String teamInfo11 = team11o.toString();
				            String teamInfo12 = team12o.toString();
				            String teamInfo13= team13o.toString();
				            String teamInfo14 = team14o.toString();
				            String teamInfo15 = team15o.toString();
				            String teamInfo16 = team16o.toString();

				            // Write the user information to the file
				            writer.write(teamInfo);
				            writer.write(teamInfo2);
				            writer.write(teamInfo3);
				            writer.write(teamInfo4);
				            writer.write(teamInfo5);
				            writer.write(teamInfo6);
				            writer.write(teamInfo7);
				            writer.write(teamInfo8);
				            writer.write(teamInfo9);
				            writer.write(teamInfo10);
				            writer.write(teamInfo11);
				            writer.write(teamInfo12);
				            writer.write(teamInfo13);
				            writer.write(teamInfo14);
				            
				            writer.write(teamInfo15);
				            writer.write(teamInfo16);

				            writer.close();



				        } catch (IOException e1) {
				            e1.printStackTrace();
				        }
				        
				        SimulationHome home = new SimulationHome();
				        home.setVisible(true);
						}
					



	    			
	    			
	    			
	    			
	        	}
	        });
	        btnNewButton.setBounds(431, 496, 117, 29);
	        contentPane.add(btnNewButton);
	        
	       /* JToggleButton tglbtnNewToggleButton = new JToggleButton("START");
	        tglbtnNewToggleButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if (tglbtnNewToggleButton.isSelected()) {
	        			int userQueue = RandomizePlayerTeam();
						CenterRandomize(userQueue, centerPlayerList);
	        			SFRandomize(userQueue, smallForwardPlayerList);
	        			PFRandomize(userQueue, powerForwardPlayerList);
	        			PGRandomize(userQueue, pointGuardPlayerList);
	        			SGRandomize(userQueue, shootingGuardPlayerList);
	        			tglbtnNewToggleButton.setText("PAUSE");
	        			
	        		}
	        		else {
	        			tglbtnNewToggleButton.setText("RESUME");
	        			
	        		}
	        	}
	        });
	        tglbtnNewToggleButton.setBounds(398, 469, 161, 29);
	        contentPane.add(tglbtnNewToggleButton); */
	        // ... Repeat for other teams
	
	        // ... (existing code)
	    }
		/** Updates the Jlists after a new player is added*/
	
	    private void updateTeamList(JList<Player> teamList, List<Player> players) {
	        DefaultListModel<Player> model = new DefaultListModel<>();
	        for (Player player : players) {
	            model.addElement(player);
	        }
	        teamList.setModel(model);
	    }

	

	}

	
