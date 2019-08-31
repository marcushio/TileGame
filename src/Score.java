/**
 *  @author Marcus Trujillo
 *  @version 8/30/19
 *  CS351
 *
 * Represents the score of the game. Keeps track of your current and longest streaks.
 *
 */
public class Score {
    private int longestStreak = 0;
    private int currentStreak = 0;

    /**
     * Adds to your streak and if your current streak is your longest then it increases your longest as well.
     */
    public void incrementStreak(){
        currentStreak++;
        if (currentStreak >= longestStreak){
            longestStreak = currentStreak;
        }
    }

    /**
     * Resets your streak if you chose two tiles with no matching elements.
     */
    public void resetStreak() { currentStreak = 0; }

    /**
     * @return your current streak
     */
    public int getCurrentStreak() { return currentStreak; }

    /**
     * @return your longest streak
     */
    public int getLongestStreak() { return longestStreak; }
}
