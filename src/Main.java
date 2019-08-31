import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Observable;
import java.util.Observer;

/**
 *  @author Marcus Trujillo
 *  @version 8/30/19
 *  CS351
 *
 *  Main class that uses launch. It contains most of the program logic, does the initial setup of the
 *  objects used.
 *  Main observes the inputState.
 *
 */

public class Main extends Application implements Observer {
    /**
     * The number of rows that will be on the board
     */
    public static final int ROWS = 6;
    /**
     * number of columns that will be on the board
     */
    public static final int COLUMNS = 6;
    private InputState inputState;
    private Board board;
    private Score score;
    private Display display;
    private Stage primaryStage;

    /**
     * Launches the program
     * @param args
     */
    public static void main(String[] args) { launch(args); }

    /**
     * Instantiates the objects needed for the program to run.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        board = new Board(ROWS, COLUMNS);
        score = new Score();
        inputState = new InputState(this);
        display = new Display(primaryStage, ROWS, COLUMNS, board, inputState, score );
    }

    /**
     * Used to update everything when the inputState has changed. We compare tiles and call all necessary
     * methods to take the proper actions if there is a match, or reset score if no match is found.
     * @param o isn't used. It's an artifact from the library defined Observer interface.
     * @param arg isn't used. It's an artifact from the library defined Observer interface.
     */
    @Override
    public void update(Observable o, Object arg){
        Element match = compareTiles(inputState.getIndex(), inputState.getOldIndex());
        if (match != null){
            board.removeTileElement(inputState.getIndex(), match);
            board.removeTileElement(inputState.getOldIndex(), match);
            score.incrementStreak();
        } else {score.resetStreak();}
        updateDisplay();
    }

    /**
     * Compares two tiles to see if there are any matching elements.
     * @param index
     * @param oldIndex
     * @return the element that is common to the two tiles else Null if no match was found.
     */
    private Element compareTiles(int index, int oldIndex){
        if(index >= 0 && oldIndex >=0) {
            Tile selection1 = board.getTile(index);
            Tile selection2 = board.getTile(oldIndex);
            for (Element element1 : selection1.getElements()) {
                for (Element element2 : selection2.getElements()) {
                    if (element1 == element2) {
                        return element1;
                    }
                }
            }
        }
        return null;
    }

    /**
     *  updates the display to reflect the current state of the game.
     */
    private void updateDisplay(){
        display = new Display(primaryStage, ROWS, COLUMNS, board, inputState, score);
    }

}
