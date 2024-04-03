
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import positions.Center;
import positions.Player;
import positions.PointGuard;
import positions.PowerForward;
import positions.ShootingGuard;
import positions.SmallForward;
/*
 * * Generates playerlists for every position.  */
public class BasketballPlayerManager {

    static List<Player> centerPlayerList = new ArrayList<>();
    static List<Player> pointGuardPlayerList = new ArrayList<>();
    static List<Player> powerForwardPlayerList = new ArrayList<>();
    static List<Player> shootingGuardPlayerList = new ArrayList<>();
    static List<Player> smallForwardPlayerList = new ArrayList<>();
    static Map<String, Player> playerMap = new HashMap<>();
    static List<Player> playerList = new ArrayList<>();
	
/** removes duplicate players and averages points for duplicate players into only one player
 * @param players All of the players that are read from csv
 * */
    static void removeDuplicatePlayers(List<Player> players) {
        Map<String, List<Player>> playerMap = new HashMap<>();

        // Group players by name
        for (Player player : players) {
            playerMap.computeIfAbsent(player.getName(), k -> new ArrayList<>()).add(player);
        }

        // Calculate average and update duplicates
        for (List<Player> duplicates : playerMap.values()) {
            if (duplicates.size() > 1) {
                double avgPts = duplicates.stream().mapToDouble(Player::getPts).average().orElse(0.0);

                // Update all duplicates with the average value
                for (Player duplicate : duplicates) {
                    duplicate.setPts(avgPts);
                }
            }
        }
    }



	public static List<Player> getCenterPlayerList() {
		return centerPlayerList;
	}




	public static List<Player> getPointGuardPlayerList() {
		return pointGuardPlayerList;
	}




	public static List<Player> getPowerForwardPlayerList() {
		return powerForwardPlayerList;
	}




	public static List<Player> getShootingGuardPlayerList() {
		return shootingGuardPlayerList;
	}



	public static List<Player> getSmallForwardPlayerList() {
		return smallForwardPlayerList;
	}



	public static Map<String, Player> getPlayerMap() {
		return playerMap;
	}




	public static List<Player> getPlayerList() {
		return playerList;
	}



/** Checks a player's position by reading csv and add it to the related list*/
	public static void generateLists() {
	    String filePath = "player.csv";

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        String[] header = br.readLine().split(";");

	        Map<String, Integer> headerMap = new HashMap<>();
	        for (int i = 0; i < header.length; i++) {
	            headerMap.put(header[i], i);
	        }

	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(";");
	            String name = data[headerMap.get("Player")];
	            String position = data[headerMap.get("Pos")];
	            double pts = Double.parseDouble(data[headerMap.get("PTS")]);
	            double trb = Double.parseDouble(data[headerMap.get("TRB")]);
	            double ast = Double.parseDouble(data[headerMap.get("AST")]);
	            double blk = Double.parseDouble(data[headerMap.get("BLK")]);
	            double stl = Double.parseDouble(data[headerMap.get("STL")]);

	            Player player;
	            String[] positions = position.split("-");

	            for (String pos : positions) {
	                String playerKey = name + "-" + pos;

	                if (playerMap.containsKey(playerKey)) {
	                    // If a player with the same name and position exists, remove it from the lists and map
	                    Player existingPlayer = playerMap.remove(playerKey);
	                    playerList.remove(existingPlayer);

	                    // Also remove it from the specific position list
	                    switch (pos) {
	                        case "PG":
	                            pointGuardPlayerList.remove(existingPlayer);
	                            break;
	                        case "SG":
	                            shootingGuardPlayerList.remove(existingPlayer);
	                            break;
	                        case "SF":
	                            smallForwardPlayerList.remove(existingPlayer);
	                            break;
	                        case "PF":
	                            powerForwardPlayerList.remove(existingPlayer);
	                            break;
	                        case "C":
	                            centerPlayerList.remove(existingPlayer);
	                            break;
	                        // Add additional cases for handling other positions if needed
	                        default:
	                            throw new IllegalArgumentException("Invalid player position: " + pos);
	                    }
	                }

	                // Create a new player
	                switch (pos) {
	                    case "PG":
	                        player = new PointGuard(name, pts, trb, ast, blk, stl);
	                        pointGuardPlayerList.add(player);
	                        break;
	                    case "SG":
	                        player = new ShootingGuard(name, pts, trb, ast, blk, stl);
	                        shootingGuardPlayerList.add(player);
	                        break;
	                    case "SF":
	                        player = new SmallForward(name, pts, trb, ast, blk, stl);
	                        smallForwardPlayerList.add(player);
	                        break;
	                    case "PF":
	                        player = new PowerForward(name, pts, trb, ast, blk, stl);
	                        powerForwardPlayerList.add(player);
	                        break;
	                    case "C":
	                        player = new Center(name, pts, trb, ast, blk, stl);
	                        centerPlayerList.add(player);
	                        break;
	                    // Add additional cases for handling other positions if needed
	                    default:
	                        throw new IllegalArgumentException("Invalid player position: " + pos);
	                }

	                // Add the player to the list and map
	                playerList.add(player);
	                playerMap.put(playerKey, player);

	                // Print player details (if needed)
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

    
    
}