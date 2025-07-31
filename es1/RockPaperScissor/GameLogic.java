package es1.RockPaperScissor;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private final Scanner scanner; // per prendere in input le mosse dell'utente

    public GameLogic(InputStream input) {
        scanner = new Scanner(input);
    }

    public void close() { scanner.close(); } // chiudo lo scanner se la partita è finita

    private Outcome choiceSubmitted(Choice userChoice) {
        Choice computerChoice = Choice.getRandomChoice(new Random()); // passo un oggetto Random di cui non mi interessa avere un riferimento
        System.out.println("I chose " + computerChoice + "!");
        return  userChoice.resultAgainst(computerChoice);
    }

    public boolean round() {
        System.out.println("What is your choice?");
        String input = scanner.next();
        try {
            Choice choice = Choice.parseInput(input);
            System.out.println("You chose " + choice + "!");
            System.out.println(choiceSubmitted(choice)); //Nota: nel codice della lezione, questa è la System.out che mancava
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice!");
            return false;
        }
        return true;
    }


    public static void main(String args[]) {
        GameLogic gameLogic = new GameLogic(System.in);
        boolean cont;
        do {
            cont = gameLogic.round();
        } while(cont);
        gameLogic.close();
    }
}
