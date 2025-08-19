package es6.PublishSubscribe_SuppVar;

public class Publisher extends Thread{
ContoInBancaSync myC;
static int publishCounter;
private int myId;

public Publisher(ContoInBancaSync c){
    this.myC=c;

    myId = publishCounter++;
}
    @Override
    public void run() {
        System.out.println("Started Publisher counter thread " + myId);

        while(true) {
        myC.increment();
        System.out.println("Ho appena AGGIUNTO, il valore del counter è " + Integer.toString(myC.getCount()));
        if(myC.getCount()>10)
            throw new RuntimeException("Valore troppo alto");
    }
    }
}
