package sample;


import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.util.xml.impl.Input;

public class Display{
    public static final int tileHeight = 76, tileWidth = 76;
    private InputState inputState = new InputState();
    public Display(Stage primaryStage, int rows, int columns){
        int tiles = rows*columns;
        FlowPane root = new FlowPane();
        TilePane grid = fillGrid(rows, columns);//new TilePane();
        
        VBox scoreBoard = new VBox();
        Text longestStreak = new Text("Longest Streak: 0");
        scoreBoard.getChildren().add(longestStreak);
        Text currentStreak = new Text("Current Streak: 0");
        scoreBoard.getChildren().add(currentStreak);

        //add tile board and scoreboard to canvas
        root.getChildren().add(grid);
        root.getChildren().add(scoreBoard);

        primaryStage.setTitle("Pattern Match");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private TilePane fillGrid(int rows, int columns){
        TilePane grid = new TilePane();
        grid.setPrefColumns(columns);
        grid.setPrefRows(rows);
        grid.setHgap(2);
        grid.setVgap(2);
        int tiles = rows*columns;

        for(int i = 0; i < tiles; i++){
            DisplayTile tempCanvas = new DisplayTile(tileWidth, tileHeight);
            tempCanvas.setIndex(i);
            tempCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    DisplayTile selected = (DisplayTile) event.getSource();
                    GraphicsContext gc = selected.getGraphicsContext2D();
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(10);
                    gc.strokeRect(0,0, tileHeight, tileWidth);
                    inputState.updateState(selected.getIndex());
                }
            });
            GraphicsContext gc = tempCanvas.getGraphicsContext2D();
            gc.setFill(Color.BLUE);
            gc.fillRect(0, 0, tempCanvas.getWidth(), tempCanvas.getHeight());
            gc.setFill(Color.RED);
            gc.fillRect(20,20,40,40);
            grid.getChildren().add(tempCanvas);
        }
        return grid;
    }
}
