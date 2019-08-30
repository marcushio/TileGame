package sample;
import java.util.ArrayList;
enum Element{
    SQUARE, CIRCLE, XCORNER, HLINE, VLINE;
}

public class Tile {
    /**** you can change the number of elements of on each tile here *****/
    public static final int numElements = 3;
    public ArrayList<Element> elements;

    public Tile(ArrayList<Element> newElements){
        elements = new ArrayList<Element>(newElements);
    }


    /**
     * Invoked when you need to remove elements that were just matched.
     * @param oldElement the old element that is going to be removed from the list of elements on the tile.
     */
    public void removeElement(Element oldElement){
        for(Element element : elements){
            if(oldElement == element) elements.remove(element);
        }
    }
}
