package es2.Operazioni.src;

public class Moltiplicazione extends Stampa implements operation {
    protected int n;

    public void risultato(int a, int b) {
        n = a * b;
        print(n);
    }
}
