package es4;

import java.util.EmptyStackException;

public class Main4 {
    public static void main(String[] args) {
        Stack <Integer> s1 = new Stack<>(10);
        Stack <Integer> s2 = new Stack<>(10);
        try {
            s1.push(27);
            s1.push(28);
            s1.push(29);
            s1.push(30);
            //Stampa in ordine di inserimento poiché il metodo toString()
            System.out.println(s1);
            int check = s1.pop();
            System.out.println(check);
            s2.push(1);
            s2.push(2);
            s2.push(3);
            s1.pushAll(s2);
            // Stampa in ordine LIFO (Last In First Out)
            // funzione pushAll() usa StackIterator
            System.out.println(s1);

        } catch (FullException e) {
            System.err.println(e.getMessage());
        } catch (EmptyStackException e) {
            System.err.println("Stack is empty");
        }
    }
}
