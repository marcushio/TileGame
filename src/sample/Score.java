package sample;

public class Score {
    private int longestStreak;
    private int currentStreak;

    public void updateStreak(){
        currentStreak++;
        if (currentStreak >= longestStreak){
            longestStreak = currentStreak;
        }
    }
}
