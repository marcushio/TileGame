import java.util.ArrayList;

/**
 *  @author Marcus Trujillo
 *  @version 8/30/19
 *  CS351
 *  Tile represents the patterned tiles you are trying to match in the game.
 */

/**
 * The enumeration Element is used for the different pattern elements on the tiles.
 */
enum Element{
    //XCORNER is an x in the corner, VLINE is a vertical line, and HLINE is a horizontal line
    SQUARE, CIRCLE, XCORNER, HLINE, VLINE;
}

public class Tile {
    /**
     * the number of elements present on each tile.
     */
    public static final int numElements = 4;
    private ArrayList<Element> elements;
    private int index;
    private boolean isEmpty;

    /**
     * creates a new tile filled with elements.
     * @param index
     */
    public Tile(int index){
        this.index = index;
        elements = new ArrayList<Element>();
        elements.add(Element.CIRCLE);
        elements.add(Element.HLINE);
        elements.add(Element.VLINE);
        elements.add(Element.XCORNER);
        isEmpty = false;
    }

    /**
     * @return the list of elements on this tile.
     */
    public ArrayList<Element> getElements() {return elements;}

    /**
     * @return whether this tile is empty or not
     */
    public boolean isEmpty(){return isEmpty;}

    /**
     * @return the index of this tile
     */
    public int getIndex(){return index;}

    /**
     * Invoked when you need to remove elements that were just matched.
     * @param oldElement the old element that is going to be removed from the list of elements on the tile.
     */
    public void removeElement(Element oldElement){
        int index = 0, count = 0;
        for(Element element : elements){
            if(oldElement == element) index = count;
            count++;
        }
        elements.remove(index);
        if(elements.isEmpty()) isEmpty = true;
    }
}
