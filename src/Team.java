import java.util.ArrayList;
import java.util.List;
import positions.Player;
/*
 * You can create team objects thathave name, logo, players, score, wins,ties and losses  */
public class Team {
    private String teamName;
    private String teamLogo;
    private List<Player> players;
    private double score;
    private int wins;
    private int losses;
    private int ties;

    // Constructor
    public Team(String teamName, String teamLogo) {
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.players = new ArrayList<>(); // Initialize the players list for each instance
    }

    // Setter method for players
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // Method to calculate the team score based on player positions
    public void calculatescore() {
        for (Player player : players) {
            if ("PG".equals(player.getPosition())) {
                score += player.calculatePointGuardScore();
            } else if ("C".equals(player.getPosition())) {
                score += player.calculateCenterScore();
            } else if ("PF".equals(player.getPosition())) {
                score += player.calculatePowerForwardScore();
            } else if ("SG".equals(player.getPosition())) {
                score += player.calculateShootingGuardScore();
            } else if ("SF".equals(player.getPosition())) {
                score += player.calculateSmallForwardScore();
            }
        }
    }

    // Getter method for losses, ties, and wins
    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public List<Player> getPlayers() {
        return players;
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }


    public String toString() {
        return teamName + ": " + players + "\n";
    }


    public String toString(String name) {
        return teamName + ": " + wins + " wins, " + ties + " ties, " + losses + " losses";
    }
    
    public String toString(int a) {
        return teamName.toUpperCase();
    }
    



    public double getScore() {
        return score;
    }


    public void setScore(double score) {
        this.score = score;
    }
}
