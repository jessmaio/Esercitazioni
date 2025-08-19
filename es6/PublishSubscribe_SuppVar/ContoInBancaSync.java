package es6.PublishSubscribe_SuppVar;

public class ContoInBancaSync {

    int value;
    private Object conto = new Object();
    public void increment() {
        synchronized (conto) {
            while(value >= 10) {
                try {
                    conto.wait();
                } catch (InterruptedException e) {

                }
            }
            value++;
            if(value == 1)
                conto.notifyAll();
        }
    }



    public void  decrement() {
        synchronized (conto) {
            while(value <= 0) {
                try {
                    conto.wait();
                } catch (InterruptedException e) {

                }
            }
            value--;
            if(value == 9)
                conto.notifyAll();
        }
    }



    public int getCount() {
        return value;
    }

}
