public class OldPerson extends Person{

    int age=50;

    public OldPerson(String nome, String cognome, int eta){
        super(nome,cognome);
        if(eta < 50){
            throw new RuntimeException("The person is not old :D ");
        }
        this.age=age;
    }

    public void saluto(){
        System.out.println("Anziano: Cordiali Saluti");
    }

    public void beOld(){
        System.out.println("Sono Anziano");
    }


}
