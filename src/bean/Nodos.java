package bean;

public class Nodos {
    private char dato;
    private Nodos Li;
    private Nodos Ld;
    
    public Nodos(char dato) {
        this.dato = dato;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodos getLi() {
        return Li;
    }

    public void setLi(Nodos li) {
        Li = li;
    }

    public Nodos getLd() {
        return Ld;
    }

    public void setLd(Nodos ld) {
        Ld = ld;
    }

    
}
