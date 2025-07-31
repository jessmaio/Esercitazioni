package es1.Esercizio1.src;

public class MySet {
    private int[] elements;
    private int MaxSize;
    private int currentSize;
    private static int counter=0 ;

    MySet(int size) {
        MaxSize = size;
        elements = new int[MaxSize];
        currentSize = 0;
        counter++;
    }

    public boolean checkElement(int element) {
        for (int i = 0; i < MaxSize; i++) {
            if (elements[i] == element)
                return true;
        }
        return false;
    }

    private boolean isFull() {
        return currentSize == MaxSize;
    }

    public void addElement(int element) {
        if (!checkElement(element) && !isFull()) {
            elements[currentSize] = element;
            currentSize++;
        }
    }

    public void removeElement(int element) {
        int index = 0;
        if(checkElement(element)) {
            for (int i = 0; i < currentSize; i++) {
                if(elements[i] != element){
                    elements[index] = elements[i];
                    index++;
                }
            }
            currentSize--; //Set non ha duplicati
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < currentSize; i++) {
            sb.append(elements[i]);
            sb.append(", ");
        }
        sb.append("]");
        sb.append("Current Static Counter : ");
        sb.append(counter);
        return sb.toString();
    }
}
