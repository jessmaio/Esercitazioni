package es1.RockPaperScissor;

import java.util.Random;

/**
 * Represents a choice (rock/paper/scissor) from either the user or the computer
 */
public enum Choice {
    ROCK, PAPER, SCISSOR;

    /**
     *
     * @param other the adversary's choice
     * @return true if this choice wins against the adversary's choice
     */
    public Outcome resultAgainst(Choice other) {
        if(this == other) {
            return Outcome.DRAW;
        }

        /*
        * ATTENZIONE:
        * In questo caso, in ognuno dei Case va messo il return, in quanto ci interessa l'outcome.
        * Una alternativa al return è il break, che consente di interrompere lo switch-case
        * Infatti, non avere nessuno dei due nei "case" porta al cosiddetto "fall-through", ovvero ognuno di quei
        * case viene valutato, e quindi anche il DEFAULT (che lancerà un'eccezione chiudendo il programma dopo il
        * primo round).
        * */
        return switch (this) {
            case PAPER -> Outcome.winsIfTrue(other == Choice.ROCK); // è importante il return,
            case SCISSOR -> Outcome.winsIfTrue(other == Choice.PAPER);
            case ROCK -> Outcome.winsIfTrue(other == Choice.SCISSOR);
            default -> throw new RuntimeException("Unexpected case!");
        };
    }

    /**
     * @param input a string indicating a choice of play
     * @return a Choice object, associated with the input string
     */
    public static Choice parseInput(String input) {
        return Enum.valueOf(Choice.class, input.toUpperCase());
    }

    /**
     * @param random a Random object used to generate a pseudo-random integer
     * @return a random Choice object
     */
    public static Choice getRandomChoice(Random random) {
        Choice[] values = Choice.values(); // Notare l'uso di values per ottenere l'arrau con tutte le istanze dell'enum.
        return values[random.nextInt(values.length)];
    }

    /**
     * @return this choice, in lowercase
     */
    @Override
    public String toString() { return super.toString().toLowerCase(); }

}

