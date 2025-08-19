package es3;

public class YoungPerson extends Person {
    int age=10;

    public YoungPerson(String nome, String cognome, int eta){
        super(nome,cognome);
        if(eta > 50){
            throw new RuntimeException("The person is not so young :D ");
        }
        this.age=age;
    }

    public void saluto(){
        System.out.println("Giovane: Yo capo, buongiorno! ");
    }
}
