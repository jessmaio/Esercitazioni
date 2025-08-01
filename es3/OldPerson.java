import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

public class OldPerson extends Person{

    int age = 50;

    public OldPerson(String nome, String cognome, int eta){
        super(nome,cognome);
        if(eta < 50){
            throw new RuntimeException("The person is not old :D ");
        }
        if(eta > 200){
            throw new RuntimeException("The person is too old :D ");
        }
        this.age = eta;
    }

    public void saluto(){
        System.out.println("Anziano: Cordiali Saluti");
    }

    public void beOld(){
        System.out.println("Sono Anziano");
    }

    public void readFromFile(String filename) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while( (line = reader.readLine()) != null){
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    System.out.println("Riga non valida: " + line);
                }
                String nome = parts[0];
                String cognome = parts[1];
                LocalDate data = null; //Since the println is outside the try-catch, we need to initialize data
                try {
                    data = LocalDate.parse(parts[2]);
                } catch (Exception e) {
                    System.out.println("Data non valida per " + nome + " " + cognome + ": " + parts[2]);
                }
                System.out.println("Nome: " + nome + ", Cognome: " + cognome + ", Data di Nascita: " + data);


            }
            // Handles IOException ( FileNotFoundException doesn't include this exception,
            // but if "throws IOException" is used, it catches too many exceptions)
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }


    }


}
