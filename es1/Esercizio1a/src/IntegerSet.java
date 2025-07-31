package es1.Esercizio1a.src;

public class IntegerSet {
    //Set di Interi, collection non-ordered, senza ripetizioni
    //Attributi: elements, size
    private int[] elements;
    private int size;
    //Var statica x contare istanze create
    private static int counter = 0;
    //Metodi: costruttore, check, Insert/remove
    //Costruttore
    public IntegerSet(int dim) {
        elements = new int[dim];
        size = 0;
        counter++;
    }

    //Metodo che controlla se è già presente l'elemento che si vuole inserire nell'array
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) return true; //C'è già
        }
        return false; //Non è presente, posso inserire
    }
    //Metodo insert (sse non è pieno)
    public boolean insert(int element) {
        if (contains(element)) return false; //Già presente
        if (size == elements.length) {
            System.out.println("Set pieno");
            return false;
        }
        elements[size] = element;
        size++;
        return true;
    }
    //Metodo remove
    public boolean remove(int element) {
        if (!contains(element)) return false; //L'elem non è presente
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                for (int j = i; j < size; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public static int getCounter() {
        return counter;
    }

    //Senza Override stampo solo hashcode ("indirizzo" IntSet)
    //che è il metodo di default
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntegerSet: { ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

}
