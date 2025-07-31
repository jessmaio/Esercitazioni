package es2.Operazioni.src;

public class Main2b {
    public static void main(String[] args) {
        operation a = new Somma();
        Sottrazione s = new Sottrazione();
        Divisione d = new Divisione();
        Moltiplicazione m = new Moltiplicazione();
        a.risultato(5, 10);
        a = s; //Polimorfismo, a diventa un oggetto di tipo Sottrazione
        a.risultato(5, 10);
        a = d; //Polimorfismo, a diventa un oggetto di tipo Divisione
        a.risultato(5, 10);
        a = m; //Polimorfismo, a diventa un oggetto di tipo Moltiplicazione
        a.risultato(5, 10);
    }
}