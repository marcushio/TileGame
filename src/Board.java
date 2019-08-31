import java.util.ArrayList;

/**
 *  @author Marcus Trujillo
 *  @version 8/30/19
 *  CS351
 *
 *  Board is the actual internal representation of the board holding all the tiles.
 *
 */
public class Board {
    private ArrayList<Tile> tiles;
    private int rows, columns;

    /**
     * Constructor fills the board with tiles based on the rows and columns, storing them all in an arraylist.
     * @param rows
     * @param columns
     */
    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        tiles = new ArrayList<Tile>();
        fillBoard();
    }

    /**
     * Fills the board with tiles by adding them to the arraylist.
     */
    private void fillBoard(){
        int numTiles = rows*columns;
        for(int i = 0; i < numTiles; i++){
            /** I'll have to generate the elements randomly later **/
            tiles.add(new Tile(i));
        }
    }

    /**
     * @param index
     * @return the tile located at a particular index in the collection of tiles.
     */
    public Tile getTile(int index){
        return tiles.get(index);
    }

    /**
     * After a match has been found this is used to get rid of the element we matched on the tiles.
     * @param index
     * @param element
     */
    public void removeTileElement(int index, Element element){
        tiles.get(index).removeElement(element);
    }

    /**
     * check if the tile still has any remaining elements on it, or if it is a blank tile.
     * @return true if no elements are on the tile else false.
     */
    public boolean isEmpty(){
        for(Tile tile : tiles){
            if(!tile.isEmpty()) return false;
        }
        return true;
    }

}