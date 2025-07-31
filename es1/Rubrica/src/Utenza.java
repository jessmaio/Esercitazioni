package es1.Rubrica.src;

public class Utenza {
    private String nome;
    private String cognome;
    private String numTel;

    public Utenza(String n, String c, String t)
    {
        this.nome = n;
        this.cognome = c;
        this.numTel = t;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString()
    {
        return "nome utente: " + nome + "\n" + "cognome utente: "+ cognome + "\n numTel utente: " + numTel;
    }
}
