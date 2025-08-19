package es6.SaladaBallo;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private static List<Dame> sadDames = new ArrayList<>();
    private static List<Dame> availableDames = new ArrayList<>();
    private static final Object lock = new Object();

    public static void initSala(List<Dame> dames){
        sadDames.clear();
        availableDames.clear();

        if(dames != null){
            if(dames.size() == 1){
                Dame lone = dames.get(0);
                lone.setSad();
                sadDames.add(lone);
            } else {
                for (Dame d : dames) {
                    availableDames.add(d);
                }
            }
        }
    }

    public static List<Dame> getAvailableDames() {
        return new ArrayList<>(availableDames);
    }

    public static List<Dame> getSadDames() {
        return new ArrayList<>(sadDames);
    }

    public static Dame takeDame() throws InterruptedException {
        synchronized (lock) {
            while (availableDames.isEmpty()) {
                lock.wait(); // il cavaliere aspetta qui
            }
            Dame dame = availableDames.remove(0);
            dame.paired();
            if (availableDames.size() == 1) {
                Dame last = availableDames.get(0);
                last.setSad();
                sadDames.add(last);
                availableDames.clear();
            }
            return dame;
        }
    }

    public static void releaseDame(Dame dame) {
        synchronized (lock) {
            dame.setSad();
            sadDames.add(dame);
            if (sadDames.size() >= 2) {
                for (Dame d : sadDames) {
                    d.setAvailable();
                    availableDames.add(d);
                }
                sadDames.clear();
                lock.notifyAll(); // sveglia i cavalieri in attesa
            }
        }
    }

}
