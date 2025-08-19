package es6.PublishSubscribe_SyncRun;

// Non il metodo più corretto per sincronizzare, ma funziona

public class Main03 {
    public static void main(String[] args) {
        ContoInBanca c = new ContoInBanca();

        int dim = 4;
        Publisher PubThreads[] = new Publisher[dim];
        Subscriber SubThread[] = new Subscriber[dim];
        for (int i = 0; i < dim; i++) {
            PubThreads[i] = new Publisher(c);
            SubThread[i] = new Subscriber(c);
        }
        for (int i = 0; i < dim; i++) {
            PubThreads[i].start(); // posso eseguire un thread più volte
            SubThread[i].start();
        }
        for (int i = 0; i < dim; i++) {
            try {
                PubThreads[i].join();
                SubThread[i].join();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // in questo caso devo:
        // 1. trovare la variabile su cui sincronizzare
        // 2. gestire i meccanismi in cui mettere in wait i thread. In questo caso ad esempio, un thread che
        // sottrae va in wait se, quando sta per sottrarre, il counter è 0. Allo stesso modo, un thread che aggiunge
        // deve andare in wait se, quando sta per aggiungere, il counter già vale 10
        // 3. Inserire i meccanismi per risvegliare i thread

        // Posso tuttavia sincronizzare anche metodi fuori dal run

    }
}