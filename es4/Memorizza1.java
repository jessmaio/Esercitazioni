package es4;

/**
 * Generics
 * @param <MyTipe> Any possible type
 */

public class Memorizza1 <MyTipe, MyTipe2> {
    MyTipe var;
    MyTipe2 var2;

    Memorizza1(MyTipe var, MyTipe2 var2) {
        this.var = var;
        this.var2 = var2;
    }
    // Caso base stampa nomeClasse@hashcode ("indirizzo")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(var.toString());
        sb.append(var2.toString());
        return sb.toString();
    }

    public static void main(String[] args){
        // Devo usare Integer per memorizzare un intero al posto di int
        // Devo usare tipi con maiuscola e non con minuscola (no int, float ma Integer, Float,...)

        // Con un solo tipo generico ( devo avere public class Memorizza1 <MyTipe> {...} ) :
        //Memorizza1<String> m2 = new Memorizza1<>("Hello");
        //Memorizza1<Double> m3 = new Memorizza1<>(3.14);
        //Memorizza1<Boolean> m4 = new Memorizza1<>(true);

        // Con due tipi generici (come in questo caso):
        Memorizza1<Integer, String> m1 = new Memorizza1<>(10, "Hello");

        // Secondo tipo generico può essere qualsiasi ( ? Wildcard)
        Memorizza1<Integer, ?> m5 = new Memorizza1<>(10, 3.14);

        System.out.println(m1);
        //System.out.println(m2);
        //System.out.println(m3);
        //System.out.println(m4);
    }
}
