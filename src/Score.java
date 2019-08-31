public class Score {
    private int longestStreak = 0;
    private int currentStreak = 0;

    public void incrementStreak(){
        currentStreak++;
        if (currentStreak >= longestStreak){
            longestStreak = currentStreak;
        }
    }

    public void resetStreak() { currentStreak = 0; }

    public int getCurrentStreak() { return currentStreak; }

    public int getLongestStreak() { return longestStreak; }
}
