import java.util.Observable;
import java.util.Observer;

/**
 *  @author Marcus Trujillo
 *  @version 8/30/19
 *  CS351
 *
 * InputState represents the current state of the game by tracking the tiles that have been selected from the display.
 * It is observable so that the game can update based on the current state.
 */
public class InputState extends Observable {
    //start at -1 so we don't highlight anything on the board to start
    private int index = -1;
    private int oldIndex = -1;

    /**
     * The constructor adds the observer (in this case Main) to it's list of observers using the built in
     * addObserver method.
     * @param observer
     */
    public InputState(Observer observer){
        addObserver(observer);
    }

    /**
     * When a new tile is selected from the display the state is updated by changing the indexes to reflect
     * which tiles are now selected.
     * @param index
     */
    public void updateState(int index){
        if(index != this.index) {
            oldIndex = this.index;
            this.index = index;
            setChanged();
            notifyObservers();
        }
    }

    /**
     * @return the index of the most recently selected tile
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the index of the previously selected tile.
     */
    public int getOldIndex() {
        return oldIndex;
    }
}
