package es6.SaladaBallo;

public class Knight {
    Dame myDame;

    public Knight(){
        setAlone();
    }

    private void setAlone() {
        try {
            myDame = null;
            lookForDame();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPaired(Dame dame) {
        this.myDame = dame;
        try { // Simulate Crisis after x milliseconds (fixed number to Display better in console)
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            throw new RuntimeException("Thread was interrupted", e);
        }
        setInCrisis();
    }

    public void setInCrisis() {
        try {
            abandonDame();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void lookForDame(){
            try{
                Dame dame = Sala.takeDame();
                setPaired(dame);
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException("Dame not found", e);
            }
    }

    private void abandonDame() {
        if (myDame != null) {
            try{
                Sala.releaseDame(myDame);
                setAlone();
            }catch (RuntimeException e) {
                throw new RuntimeException("Failed to abandon dame", e);
            }
        } else {
            throw new IllegalStateException("No dame to abandon.");
        }
    }

}
