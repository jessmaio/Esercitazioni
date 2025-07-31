package es1.Esercizio0.src;

public class Main0 {
    public static void main(String[] args) {
        String s1= "abc";
        String s2= "abc"; //Esiste già una stringa con lo stesso contenuto (string pool), quindi gli da il riferimento alla stringa esistente senza crearne una nuova
        String s3= new String("abc"); //Forzo la creazione di una nuova stringa
        String s4= s3;
        System.out.println("Contenuto s1: " + s1 + "\nIdentityHashCode: " + System.identityHashCode(s1));
        System.out.println("Contenuto s2: " + s2 + "\nIdentityHashCode: " + System.identityHashCode(s2));
        System.out.println("Contenuto s3: " + s3 + "\nIdentityHashCode: " + System.identityHashCode(s3));
        System.out.println("Contenuto s4: " + s4 + "\nIdentityHashCode: " + System.identityHashCode(s4));
    }
}