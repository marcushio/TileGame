import javafx.scene.canvas.Canvas;

/**
 *  @author Marcus Trujillo
 *  @version 8/26/19
 *  CS351
 *
 *  Display Tile is basically just a canvas. It just has the extra index field so that it can be located in
 *  the display. It is the graphic of a tile in the Display of the game.
 */

public class DisplayTile extends Canvas {
    private int index;

    /**
     * Constructor establishes the width and height of the new Canvas.
     * @param width
     * @param height
     */
    public DisplayTile(int width, int height){
        super(width, height);
    }

    /**
     * Set the index location of this DisplayTile
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the index of the tile
     */
    public int getIndex(){
        return index;
    }
}
