package sample;


import javafx.scene.canvas.Canvas;

public class DisplayTile extends Canvas {
    int index;

    public DisplayTile(int width, int height){
        super(width, height);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
