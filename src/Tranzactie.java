import java.util.ArrayList;
import java.util.List;

enum Tip {INCASARE,PLATA,RAMBURSARE}

public class Tranzactie {


    private Tip tipTranzactie;
    private Float suma;


    public Tranzactie(Tip tipTranzactie, Float suma) {
        this.tipTranzactie = tipTranzactie;
        this.suma = suma;
    }

    public Tip getTipTranzactie() {
        return tipTranzactie;
    }

    public void setTipTranzactie(Tip tipTranzactie) {
        this.tipTranzactie = tipTranzactie;
    }

    public Float getSuma() {
        return suma;
    }

    public void setSuma(Float suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "tipTranzactie=" + tipTranzactie +
                ", suma=" + suma +
                '}';
    }
}
