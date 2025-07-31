package es1.RockPaperScissor;

/**
 *  Class representing the outcome of a match
 */
public enum Outcome {
    WINNER("You won!"), LOSER("You lost!"), DRAW("Draw!");

    /**
     * Each instance of the enum has an associated message
     */
    private final String message;

    /**
     * @param message string used to initialize instances for this enum
     */
    Outcome(String message) { this.message = message; }

    /**
     * @return the message assiciated with this enum value
     */
    @Override
    public String toString() { return message; }

    /**
     * @param condition boolean value, true selects a WINNER message, LOST selects a LOSER message
     * @return either a Outcome.WINNER or Outcome.LOSER
     */
    public static Outcome winsIfTrue(boolean condition) {
        return (condition) ? Outcome.WINNER : Outcome.LOSER;
    }
}
