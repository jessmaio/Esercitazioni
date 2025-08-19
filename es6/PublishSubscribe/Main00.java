package es6.PublishSubscribe;

public class Main00 {
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
            PubThreads[i].start();
            SubThread[i].start();
        }

        // In questo caso, non stiamo sincronizzando nulla.
        // il counter viene incrementato e decrementato senza controllo. Se supera 10 o scende sotto lo 0
        // lancerà un'eccezione che bloccherà il thread

        //NONOSTANTE L'ORDINE DEI MESSAGGI, L'AVER GENERATO LE ECCEZIONI E' INDICE DI UN COMPORTAMENTO SCORRETTO
    }
}