package es1.Rubrica.src;

public class AgendaTelefonica {
    // Voglio memorizzare gli utenti all'interno di una AgendaTelefonica telefonica. Ogni utente è definito da Nome, Cognome, Età e Numero di Telefono
    private Utenza[] utenti;
    private int dim;
    private int myCounter;
    public AgendaTelefonica(int dim){
        this.dim = dim;
        this.utenti = new Utenza[dim]; // dichiaro un array di dim elementi
    }

    public boolean isFull(){
        return myCounter == dim;
    }


    /* se l’AgendaTelefonica non è piena, inserisce in AgendaTelefonica una nuova utenza con nome n, cognome c
     e numero di telefono t; poi restituisce true. Se l’AgendaTelefonica è piena restituisce false
    */
    public boolean inserisci(String n, String c, String t){
        if(!isFull())
        {
            Utenza u = new Utenza(n,c,t);
            utenti[myCounter] = u;
            myCounter = myCounter +1;
            return true;
        }
        return false;
    }
    /* restituisce il numero di telefono di un’utenza con nome n e cognome c, se una tale utenza è
     presente in AgendaTelefonica; altrimenti restituisce null
    */
    public String trova (String n, String c){
        for (Utenza u : utenti){
            if(u.getNome().equalsIgnoreCase(n) && u.getCognome().equalsIgnoreCase(c))
                return u.getNumTel();
        }
        return null;
    }

    /* Visualizza sullo standard output la lista completa delle utenze in AgendaTelefonica
     */
    public void listaUtenze(){
        int index = 0;
        for(index = 0; index < myCounter ; index ++)
        {
            System.out.println(utenti[index].toString());
        }
    }
}
