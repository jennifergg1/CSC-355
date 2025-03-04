
import java.util.List;
import java.util.ArrayList;

public class LeaderBoard {
    // creates an array for the leaderboard that holds contents of Contestant class
    private List<Contestant> leaderboard;
    private int capacity;
    // int currSize;

    // constructor: creates a new Leaderboard of size m
    public LeaderBoard(int m) {
        // determines the max num of ppl you can have in the leaderboard
        this.capacity = m;
        // determines the size you are currently at and if you can add more ppl to the leaderboard or need to stop there
        //currSize = 0;
        this.leaderboard = new ArrayList<>();
    }

    public void addContestant(Contestant c) {
/*
- Add new contestant to the bottom of the board, say this.board.add(c)
- Then starting from the bottom of the board, compare the contestant to the one above. 
For example, if we're looking at ith Contestant on the board, we will compare it to i-1th.
- If the compareTo returns 1, then swap them. Otherwise just stop the loop.
- At the end, if our new board.size() > board.capacity (our m), then we can simply slice the board by doing
this.board = this.board.subList(0, this.board.size() - 1)
*/
        // add new contestant to the bottom of the board
        // c is newContestant
        leaderboard.add(c);

        // start at the bottom of the leaderboard (step 2)
        int i = leaderboard.size() - 1;
        
        // step 3
        // if new contestant (c) has a greater score, keep swapping until no longer bigger
        while (i > 0) {
            // Check if the new contestant has a higher score than the one above.
            if (c.compareTo(leaderboard.get(i - 1)) < 0) {
                // If yes, swap their positions.
                Contestant temp = leaderboard.get(i);
                leaderboard.set(i, leaderboard.get(i - 1));
                leaderboard.set(i - 1, temp);
    
                // Move up the leaderboard to continue comparing.
                i--;
            } else {
                // If no more swaps are needed, exit the loop.
                break;
            }
        }

        // slice the board to get desired size (step4)
        if (leaderboard.size() > this.capacity) {
            this.leaderboard = this.leaderboard.subList(0, this.leaderboard.size() - 1);
            }
        }

    public Contestant[] finalLeaderBoard() {
        return leaderboard.toArray(new Contestant[0]);
    }

}
