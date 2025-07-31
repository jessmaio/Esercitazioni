package es1.Esercizio1a.src;

public class Main1a {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!\n");

        IntegerSet s1 = new IntegerSet(20); //n elementi possibili
        System.out.println(s1);
        s1.insert(1);
        s1.insert(2);
        s1.insert(3);
        s1.insert(4);
        s1.insert(5);
        System.out.println(s1);
        s1.insert(6);
        s1.insert(7);
        s1.insert(8);
        s1.insert(9);
        s1.insert(10);
        System.out.println(s1);
        s1.remove(1);
        System.out.println(s1);
        System.out.println("Istanze create: " + IntegerSet.getCounter());
        IntegerSet s2 = new IntegerSet(20);
        IntegerSet s3 = new IntegerSet(20);
        IntegerSet s4 = new IntegerSet(20);
        IntegerSet s5 = new IntegerSet(20);
        System.out.println("Istanze create: " + IntegerSet.getCounter());


    }
}