import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
import java.util.ArrayList;

public class Display{
    public static final int tileHeight = 76, tileWidth = 76;
    private InputState inputState;
    public FlowPane root;
    public TilePane grid;
    private VBox scoreboard;

    public Display(Stage primaryStage, int rows, int columns, Board board, InputState inputState, Score score){
        this.inputState = inputState;
        int tiles = rows*columns;
        root = new FlowPane();
        grid = fillGrid(rows, columns, board);//new TilePane();
        scoreboard = getUpdatedScoreboard(score.getCurrentStreak(), score.getLongestStreak(), board);

        root.getChildren().add(grid);
        root.getChildren().add(scoreboard);
        primaryStage.setTitle("Super Pattern Matching Tile Game Wowza!");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }

    public TilePane fillGrid(int rows, int columns, Board board){
        TilePane grid = new TilePane();
        grid.setPrefColumns(columns);
        grid.setPrefRows(rows);
        grid.setHgap(2);
        grid.setVgap(2);
        int tiles = rows*columns;

        for(int i = 0; i < tiles; i++){
            DisplayTile tempCanvas = paintTile(board.getTile(i));
            tempCanvas.setIndex(i);
            tempCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    DisplayTile selected = (DisplayTile) event.getSource();
                    inputState.updateState(selected.getIndex()); //this sets off a cascade of method calls...
                }
            });
            grid.getChildren().add(tempCanvas);
        }
        return grid;
    }

    private DisplayTile paintTile(Tile tile){
        ArrayList<Element> elements = tile.getElements();
        DisplayTile newTile = new DisplayTile(tileWidth, tileHeight);
        GraphicsContext gc = newTile.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,tileWidth,tileHeight);
        //paint elements of Tile onto DisplayTile that represents this Tile
        for(Element element: elements){
            if(element == Element.SQUARE){
                gc.setFill(Color.RED);
                gc.fillRect(20,20,50,50);
            } else if (element == Element.CIRCLE){
                gc.setFill(Color.BURLYWOOD);
                gc.fillOval(20,20,40,40);
            } else if (element == Element.HLINE){
                gc.setStroke(Color.GREEN);
                gc.strokeLine(5,38,71,38);
            } else if (element == Element.VLINE){
                gc.setStroke((Color.RED));
                gc.strokeLine(38,5,38,71);
            } else if (element == Element.XCORNER){
                gc.setStroke(Color.CYAN);
                gc.strokeLine(2, 5, 12, 15);
                gc.strokeLine(12, 5, 2, 15);
            }
        }
        if(tile.getIndex() == inputState.getIndex()){
            gc.setFill(Color.WHITE);
            gc.setLineWidth(10);
            gc.strokeRect(0,0, tileHeight, tileWidth);
        }

        return newTile;
    }

    private VBox getUpdatedScoreboard(int currentStreak, int longestStreak, Board board){
        VBox scoreBoard = new VBox();
        Text longestStreakText = new Text("Longest Streak: " + longestStreak);
        scoreBoard.getChildren().add(longestStreakText);
        Text currentStreakText = new Text("Current Streak: " + currentStreak);
        scoreBoard.getChildren().add(currentStreakText);
        Text winText = new Text("");
        scoreBoard.getChildren().add(winText);
        if(board.isEmpty()){
            winText.setText("A WINNER IS YOU!!!");
        }
        return scoreBoard;
    }

}
