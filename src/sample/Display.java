package sample;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display{
    public static final int tileHeight = 100, tileWidth = 100;
    public Display(Stage primaryStage, int rows, int columns){
        FlowPane root = new FlowPane();
        TilePane grid = new TilePane(); //fillGrid(rows, columns);
        grid.setHgap(2);
        grid.setVgap(2);
        int tiles = rows*columns;
        for(int i = 0; i <= tiles; i++){
            Canvas tempCanvas = new Canvas(tileWidth, tileHeight);
            GraphicsContext gc = tempCanvas.getGraphicsContext2D();
            gc. setFill ( Color . BLUE );
            gc. fillRect (0 ,0 ,tempCanvas.getWidth() ,tempCanvas.getHeight());
            grid.getChildren().add(tempCanvas);
        }
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
        grid.setHgap(10);
        grid.setVgap(10);
        int tiles = rows*columns;
        for(int i = 0; i <= tiles; i++){
            Canvas tempCanvas = new Canvas();
            GraphicsContext gc = tempCanvas.getGraphicsContext2D();
            gc. setFill ( Color . BLUE );
            gc. fillRect (75 ,50 ,150 ,100);
            gc. setFill ( Color . OLIVEDRAB );
            gc. setStroke ( Color . ORANGE );
            gc. setLineWidth (5);
            gc. strokeOval (100 , 60, 30, 50);
            gc. fillOval (150 , 60, 30, 50);
            gc. strokeLine (115 , 130 , 160 , 140);
            grid.getChildren().add(tempCanvas);
        }
        return grid;
    }
}
