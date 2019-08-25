public class Score {
    private int longestStreak;
    private int currentStreak;

    private void updateStreak(){
        currentStreak++;
        if (currentStreak == longestStreak || currentStreak > longestStreak){
            longestStreak = currentStreak;
        }
    }


}
