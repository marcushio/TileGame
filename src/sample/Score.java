package sample;

public class Score {
    private int longestStreak = 0;
    private int currentStreak = 0;

    public void updateStreak(){
        currentStreak++;
        if (currentStreak >= longestStreak){
            longestStreak = currentStreak;
        }
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }
}
