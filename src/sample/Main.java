package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer {
    public static final int ROWS = 6;
    public static final int COLUMNS = 6;
    private InputState inputState;
    private Board board;
    private Score score;
    private Display display;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        board = new Board(ROWS, COLUMNS);
        score = new Score(); 
        System.out.println("calling constructor to add observer");
        inputState = new InputState(this);
        display = new Display(primaryStage, ROWS, COLUMNS, board, inputState );
        System.out.println("number of observers: " + inputState.countObservers());
    }

    @Override
    public void update(Observable o, Object arg){
        System.out.println("time to update");
        Element match = compareTiles(inputState.index, inputState.oldIndex);
        if (match != null){
            board.removeTileElement(inputState.index, match);
            board.removeTileElement(inputState.oldIndex, match);
            score.updateStreak();
            updateDisplay();
        }
    }

    public Element compareTiles(int index, int oldIndex){
        System.out.println("time to compare tiles");
        Tile selection1 = board.getTile(index);
        Tile selection2 = board.getTile(oldIndex);
        for(Element element1: selection1.elements){
            for(Element element2: selection2.elements){
                if(element1 == element2){
                    System.out.println("match for selection1: " + element1 + " selection2: "+ element2);
                    return element1;
                }
            }
        }
        return null;
    }

    private void updateDisplay(){
        display.grid = display.fillGrid(ROWS, COLUMNS, board);
    }

}
