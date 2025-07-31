package es1.Rubrica.src;

public class Main1c {
    public static void main(String[] args) {
        AgendaTelefonica myAgenda = new AgendaTelefonica(2);
        boolean check = myAgenda.inserisci("Lorenzo","Insigne", "333 9876543");
        if (!check)
            System.out.println("AgendaTelefonica piena");
        check = myAgenda.inserisci("Giovanni","Di Lorenzo", "333 8547642");
        if (!check)
            System.out.println("AgendaTelefonica piena");
        check = myAgenda.inserisci("Paolino","Paperino", "333 9998883");
        if (!check)
            System.out.println("AgendaTelefonica piena");
        myAgenda.listaUtenze();
        System.out.println(myAgenda.trova("Giovanni","Di Lorenzo"));
    }
}