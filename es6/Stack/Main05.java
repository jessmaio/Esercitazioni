package es6.Stack;

public class Main05 {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // stack con capacità massima 5

        // Creiamo 2 produttori
        Runnable producerTask = () -> {
            for (int i = 0; i < 10; i++) {
                stack.push(i);
                System.out.println(Thread.currentThread().getName() + " prodotto: " + i);
                try {
                    Thread.sleep(300); // simula tempo di produzione
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Creiamo 3 consumatori
        Runnable consumerTask = () -> {
            for (int i = 0; i < 7; i++) { // ognuno consuma 7 elementi
                int value = stack.pop();
                System.out.println(Thread.currentThread().getName() + " consumato: " + value);
                try {
                    Thread.sleep(700); // simula tempo di consumo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Avviamo i produttori
        Thread p1 = new Thread(producerTask, "Produttore-1");
        Thread p2 = new Thread(producerTask, "Produttore-2");

        // Avviamo i consumatori
        Thread c1 = new Thread(consumerTask, "Consumatore-1");
        Thread c2 = new Thread(consumerTask, "Consumatore-2");
        Thread c3 = new Thread(consumerTask, "Consumatore-3");

        // Start
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();

        // Join (aspettiamo che finiscano)
        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Esecuzione terminata!");
    }
}
