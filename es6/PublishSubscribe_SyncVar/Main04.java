package es6.PublishSubscribe_SyncVar;
// Metodo di sincronizzazione su variabile
// vedi classe ContoInBancaSync (variabile sincronizzata: conto

public class Main04 {

    public static void main(String args[]) {
        ContoInBancaSync c = new ContoInBancaSync();
        int dim = 4;
        Publisher PubThreads[] = new Publisher[dim];
        Subscriber SubThread[] = new Subscriber[dim];
        for (int i = 0; i < dim; i++) {
            PubThreads[i] = new Publisher(c);
            SubThread[i] = new Subscriber(c);
        }
        for (int i = 0; i < dim; i++) {
            PubThreads[i].start();
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
    }
}
