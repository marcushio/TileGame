package sample;
import java.util.ArrayList;
enum Element{
    SQUARE, CIRCLE, TRIANGLE, HLINE, VLINE;
}

public class Tile {
    /**** you can change the number of elements of on each tile here *****/
    public static final int numElements = 3;
    ArrayList<Element> elements;

    public Tile(ArrayList<Element> newElements){
        elements = new ArrayList<Element>(newElements);
    }
    public Tile(){
        /**later I'll make random element ***/
        elements.add(Element.HLINE);
        elements.add(Element.VLINE);
        elements.add(Element.CIRCLE);
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
