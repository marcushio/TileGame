package sample;

public class InputState {
    int index;
    int oldIndex;
    Main observer;

    public void updateState(int index){
        oldIndex = index;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void notifyObserver(){
        observer.compareTiles(index, oldIndex);
    }
}
