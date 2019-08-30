package sample;
import java.util.ArrayList;

public class Board {
    private Tile selection1;
    private Tile selection2;
    private ArrayList<Tile> tiles;
    private int rows, columns;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        int numTiles = rows*columns;
        tiles = new ArrayList<Tile>();

        //fill the board with tiles
        for(int i = 0; i < numTiles; i++){
                /** I'll have to generate the elements randomly later **/
                tiles.add(new Tile());
        }
    }

    public int getColumns() { return columns; }

    public int getRows() { return rows; }

    /**
     * Invoked when all elements of a tile have been matched and that tile can be removed from the board.
     * I get the feeling we won't need this. Because we're just going to be removing patterns
     */
    public void removeTile(){

    }

}