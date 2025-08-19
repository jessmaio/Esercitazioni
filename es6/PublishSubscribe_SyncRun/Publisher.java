package es6.PublishSubscribe_SyncRun;

public class Publisher extends Thread{

    ContoInBanca contoPaga;
    private int myId;
    static int publishCounter;


    public Publisher(ContoInBanca c){
        this.contoPaga=c;
        myId = publishCounter++;
    }

    public void run(){
        System.out.println("Started Publisher counter thread " + myId);

        // per prima cosa devo evidenziare su COSA devo sincronizzare. In questo caso: contoPaga:ContoInBanca
        while(true) {
            synchronized (contoPaga) {
                while(contoPaga.valore >=10)
                    try {
                        contoPaga.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

        incrementa();
        System.out.println(" sono il thread " + myId +" ho appena AGGIUNTO, il valore del counter è " + Integer.toString(contoPaga.valore));
        if (contoPaga.valore > 10)
            throw new RuntimeException("Valore troppo alto");
        if (contoPaga.valore >= 5) {
            contoPaga.notifyAll();
        }
            }
        }
    }

    public void incrementa(){
        contoPaga.valore++;
    }
}
