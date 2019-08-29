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
    public Display(Stage primaryStage, int rows, int columns){
        FlowPane root = new FlowPane();
        TilePane board = fillGrid(rows, columns);
        VBox scoreBoard = new VBox();
        Text longestStreak = new Text("Longest Streak: 0");
        scoreBoard.getChildren().add(longestStreak);
        Text currentStreak = new Text("Current Streak: 0");
        scoreBoard.getChildren().add(currentStreak);

        //add tile board and scoreboard to canvas
        root.getChildren().add(board);
        root.getChildren().add(scoreBoard);

        primaryStage.setTitle("Pattern Match");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private TilePane fillGrid(int rows, int columns){
        TilePane grid = new TilePane();
        int tiles = rows*columns;
        for(int i = 0; i <= tiles; i++){
            grid.getChildren().add(new Canvas());
        }
        return grid;
    }
}
