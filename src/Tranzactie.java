import java.util.ArrayList;
import java.util.List;

enum Tip {INCASARE,PLATA,RAMBURSARE}

public class Tranzactie {



    private Tip tipTranzactie;
    private Double suma;
    private String numeClient;


    public Tranzactie(Tip tipTranzactie, Double suma, String numeClient) {

        this.tipTranzactie = tipTranzactie;
        this.suma = suma;
        this.numeClient = numeClient;
    }

    public Tip getTipTranzactie() {
        return tipTranzactie;
    }

    public void setTipTranzactie(Tip tipTranzactie) {
        this.tipTranzactie = tipTranzactie;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    @Override
    public String toString() {
        return "Tranzactie de " +
                "tip " + tipTranzactie +
                ", Suma: " + suma  +
                '}';
    }
}
