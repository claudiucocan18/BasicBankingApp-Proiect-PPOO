import java.text.DecimalFormat;

enum Tip {INCASARE,PLATA,RAMBURSARE}

public class Tranzactie {


    private Tip tipTranzactie;
    private Double suma;
    private String expeditor;
    private String deLa;


    public Tranzactie(Tip tipTranzactie, Double suma, String expeditor) {
        this.tipTranzactie = tipTranzactie;
        this.suma = suma;
        this.expeditor = expeditor;
        //this.destinatar = destinatar;
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

    public String getExpeditor() {
        return expeditor;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public String getDeLa() {
        return deLa;
    }

    public void setDeLa(String deLa) {
        this.deLa = deLa;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

//        if(tipTranzactie.equals(Tip.PLATA) || tipTranzactie.equals(Tip.RAMBURSARE))
//            return "Tranzactie de " +
//                    "tip " + tipTranzactie +
//                    ", Suma: " + df.format(suma)+", Catre: "+ deLa;
//
//        else {
            return "Tranzactie de " +
                    "tip " + tipTranzactie +
                    ", Suma: " + df.format(suma);
//                    +", Sursa: " + expeditor;
        }
   // }

    public String writeToFile() {
        DecimalFormat df = new DecimalFormat("#.##");
        return tipTranzactie.ordinal() +" "+ df.format(suma) +" "+ expeditor;// +" "+ destinatar;
    }
}
