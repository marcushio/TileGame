package sample;
import java.util.ArrayList;

public class Board {
    /*** rows and columns can be changed to fit size requirements just be sure there is an even number of tiles ***/
    int rows = 6, columns = 6;
    private Tile selection1;
    private Tile selection2;
    private Tile tiles[][];

    public Board(){
        tiles = new Tile[rows][columns];
        //fill the board with tiles
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                //create list of elements that will be contained in the new tile
                ArrayList<Element> elements = new ArrayList<Element>();
                /** I'll have to generate the elements randomly later **/
                elements.add(Element.CIRCLE);
                elements.add(Element.SQUARE);
                elements.add(Element.TRIANGLE);
                tiles[rows][columns] = new Tile(elements);
            }
        }
    }

    public int getColumns() { return columns; }

    public int getRows() { return rows; }

    /**
     * Invoked when all elements of a tile have been matched and that tile can be removed from the board.
     */
    public void removeTile(){

    }

}