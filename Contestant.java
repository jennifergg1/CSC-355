
class Contestant implements Comparable<Contestant> {
    private String name;
    private int score;

    // constructor: creates a new contestant with the given name and score
    public Contestant(String name, int score) {
        this.name = name; // this is just the instance of the variable
        this.score = score;
    }

    // getter
    public String getName() {
        return name;
    }

    //getter
    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Contestant other){
        // returning neg = less than
        // returning 0 = equals
        // returning pos = greater than
        
        // Compare by scores first
        if (this.score < other.score) {
            return 1;  // This contestant has a lower score, so it should come after.
        } else if (this.score > other.score) {
            return -1; // This contestant has a higher score, so it should come before.
        } else {
            // Scores are equal, so compare by names alphabetically
            // compares this.name(person1) with the name of othername(person2)
            return this.name.compareTo(other.name);
        }

    }

    // toString : <name>: <score>
    @Override
    public String toString() {
        return name + ": " + score;
    }

}



