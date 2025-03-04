import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeaderBoardTest {
    public static void main(String[] args) {
        // Leaderboard 1 of size 5
        LeaderBoard lb = new LeaderBoard(25);

        // Read the file and populate the leaderboard
        try (BufferedReader reader = new BufferedReader(new FileReader("names.txt"))) {
            String currentLine;

            // check if its null
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");

                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    lb.addContestant(new Contestant(name, score));
                } else {
                    System.err.println("Invalid format in names.txt: " + currentLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading names.txt: " + e.getMessage());
        }

        Contestant[] finalLeaderBoard = lb.finalLeaderBoard();

        System.out.println("Final Leaderboard (M=5):");
        for (Contestant c : finalLeaderBoard) {
            System.out.println(c);
        }

        // Leaderboard 2 of size 3
        LeaderBoard lb2 = new LeaderBoard(3);

        // Create a new file reader for lb2
        try (BufferedReader reader = new BufferedReader(new FileReader("names.txt"))) {
            String currentLine;

            //check null
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");

                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    lb2.addContestant(new Contestant(name, score));
                } else {
                    System.err.println("Invalid format in names.txt: " + currentLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading names.txt: " + e.getMessage());
        }

        Contestant[] finalLeaderBoard2 = lb2.finalLeaderBoard();
        System.out.println();
        System.out.println("Final LeaderBoard (M=3):");
        for (Contestant c : finalLeaderBoard2) {
            System.out.println(c);
        }

        // Check if the first contestant has a higher score than the second contestant
        System.out.println(finalLeaderBoard2[0].getScore() > finalLeaderBoard2[1].getScore());

        // Check if the first contestant's name matches the third contestant's name
        System.out.println(finalLeaderBoard2[0].getName().equals(finalLeaderBoard2[2].getName()));
    }
}
