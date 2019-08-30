package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int ROWS = 6;
    public static final int COLUMNS = 6;
    InputState input;
    Board board;
    Score score;
    Display display;

    public static void main(String[] args) {
        launch(args);
    }

    public void updateBoard(int index, int oldIndex){

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        display = new Display(primaryStage, ROWS, COLUMNS );
    }

}
