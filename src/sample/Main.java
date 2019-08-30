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

    @Override
    public void start(Stage primaryStage) throws Exception{
        display = new Display(primaryStage, ROWS, COLUMNS );
    }

    public void compareTiles(int index, int oldIndex){
        Tile selection1 = board.getTile(index);
        Tile selection2 = board.getTile(oldIndex);
        for(Element element1: selection1.elements){
            for(Element element2: selection2.elements){
                if(element1 == element2){
                    board.removeTileElement(index, element1);
                    board.removeTileElement(oldIndex, element2);
                }
            }
        }
    }

}
