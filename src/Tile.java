import java.util.ArrayList;
enum Element{
    //XCORNER is an x in the corner, VLINE is a vertical line, and HLine is a horizontal line
    SQUARE, CIRCLE, XCORNER, HLINE, VLINE;
}

public class Tile {
    /**** you can change the number of elements of on each tile here *****/
    public static final int numElements = 4;
    public ArrayList<Element> elements;
    int index;
    boolean isEmpty;

    public Tile(int index){
        this.index = index;
        elements = new ArrayList<Element>();
        elements.add(Element.CIRCLE);
        elements.add(Element.HLINE);
        elements.add(Element.VLINE);
        elements.add(Element.XCORNER);
        isEmpty = false;
    }

    public boolean isEmpty(){return isEmpty;}

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
