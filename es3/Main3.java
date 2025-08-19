package es3;/*
The present code presents the dynamic binding feature.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person p = new Person("Giovanni", "Esposito");
        OldPerson po= new OldPerson("Giuseppe", "Sorrentino", 65);
        p.saluto(); // Here, a Person is saying Hello
        po.saluto(); // Here, an OldPerson is saying Hello

        // STEP 1: Uncomment line 14, you will see the error when assigning a superclass to a subclass
        //po = p; // This is an error, I cannot assign a superclass to a subclass
        po.beOld();
        p = po; // This is correct, I am assigning a subclasso to a superClass.

        // STEP 2: Uncomment line 17, you will see that p is still a person
        // System.out.println(p.age); //Look at the error: p is a person, so there is no age

        // STEP 3: nevertheless, the "saluto" implementation refers to OldPerson thanks to Dynamic Binding
        p.saluto(); // Thanks to dynamic binding, this refers to the OldPerson implementation.
        //p.beOld(); // P is still a Person, not an OldPerson, therefore there is no visibility on beOld
        //System.out.println(po.age);

        // STEP 4: Look at the exception :D
        //YoungPerson yp = new YoungPerson("Giovanni", "Esposito", 55); // This throws an exception
        YoungPerson yp2 = new YoungPerson("Antonio", "Candreva", 25);

        // STEP 5: checks the two classes extending Person cannot be assigned each other
        //po = yp2; // Both OldPerson and YoungPerson extends Person, but I cannot assign each other

        // STEP 6: let's check Dynamic Binding with a different class
        p = yp2;
        p.saluto(); // Thanks to dynamic binding, the p "saluto" implementation changes again

        // STEP 7: Read from File.txt
        System.out.println("Let's read from a file:");
        try {
            po.readFromFile("es3/family.txt");
        } catch (Exception e) {
            throw new RuntimeException("Error reading from file: " + e);
        }
    }

}