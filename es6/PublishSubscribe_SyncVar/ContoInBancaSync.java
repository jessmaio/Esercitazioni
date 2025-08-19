package es6.PublishSubscribe_SyncVar;

public class ContoInBancaSync {

    private Conto conto = new Conto();


    public void increment() {
        synchronized (conto) {
            while(conto.value >= 10) {
                try {
                    conto.wait();
                } catch (InterruptedException e) {

                }
            }
            conto.value++;
            if(conto.value == 1)
                conto.notifyAll();
        }
    }



    public void  decrement() {
        synchronized (conto) {
            while(conto.value <= 0) {
                try {
                    conto.wait();
                } catch (InterruptedException e) {

                }
            }
            conto.value--;
            if(conto.value == 9)
                conto.notifyAll();
        }

    }



    public int getCount() {
        return conto.value;
    }

}
