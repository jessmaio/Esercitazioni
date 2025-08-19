package es6.SaladaBallo;

public class Dame {
    private boolean available;
    private boolean sad;

    public Dame() {
        this.available = true;
        this.sad = false;
    }

    public void setAvailable(){
        available = true;
        sad = false;
    }

    public void setSad(){
        available = false;
        sad = true;
    }

    public void paired(){
        available = false;
        sad = false;
    }
}
