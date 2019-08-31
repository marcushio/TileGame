package sample;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class InputState extends Observable {
   // private ArrayList<java.util.Observer> observers = new ArrayList<Observer>();
    int index;
    int oldIndex;
    public InputState(Observer observer){
        System.out.println("adding observer in constructor");
        addObserver(observer);
    }
    public void updateState(int index){
        System.out.println("updating state in input state");
        oldIndex = this.index;
        this.index = index;
        System.out.println("index: " + index + " oldIndex: " + oldIndex + "calling notifyObservers()");
        setChanged();
        notifyObservers();
        System.out.println("Observers were supposed to be notified");
    }

    public int getIndex() {
        return index;
    }

    public int getOldIndex() {
        return oldIndex;
    }
}
