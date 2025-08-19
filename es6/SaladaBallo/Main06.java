package es6.SaladaBallo;

import java.util.ArrayList;
import java.util.List;

public class Main06 {
    public static void main(String[] args) {
        int numDames = 9;
        int numKnights = 10;

        // Creiamo le dame
        List<Dame> dames = new ArrayList<>();
        for (int i = 0; i < numDames; i++) {
            dames.add(new Dame());
        }

        // Inizializziamo la sala
        Sala.initSala(dames);

        // Creiamo i cavalieri
        List<Thread> knights = new ArrayList<>();
        for (int i = 0; i < numKnights; i++) {
            Thread t = new Thread(() -> new Knight());
            knights.add(t);
        }

        // Avviamo tutti i cavalieri
        for (Thread t : knights) {
            t.start();
        }

        // Monitoriamo lo stato della sala ogni 200ms finché i cavalieri non finiscono
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (Sala.class) {
                int available = Sala.getAvailableDames().size();
                int sad = Sala.getSadDames().size();
                int taken = numDames - available - sad;
                System.out.println("Stato Sala -> Disponibili: " + available + ", Tristi: " + sad +
                        ", Coppie: " + taken);
            }
            running = knights.stream().anyMatch(Thread::isAlive);
        }

        System.out.println("Simulazione terminata.");
    }
}
