package sample;
import java.util.ArrayList;
enum Element{
    SQUARE, CIRCLE, XCORNER, HLINE, VLINE;
}

public class Tile {
    /**** you can change the number of elements of on each tile here *****/
    public static final int numElements = 4;
    public ArrayList<Element> elements;

    public Tile(){
        elements = new ArrayList<Element>();
        elements.add(Element.CIRCLE);
        elements.add(Element.HLINE);
        elements.add(Element.VLINE);
        elements.add(Element.XCORNER);
    }
    public Tile(ArrayList<Element> newElements){
        elements = new ArrayList<Element>(newElements);
    }

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
    }
}
