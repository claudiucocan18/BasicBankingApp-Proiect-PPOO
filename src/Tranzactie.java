enum Tip {INCASARE,PLATA,RAMBURSARE}

public class Tranzactie {



    private Tip tipTranzactie;
    private Double suma;
    private String expeditor;
    private String destinatar;


    public Tranzactie(Tip tipTranzactie, Double suma, String expeditor, String destinatar) {
        this.tipTranzactie = tipTranzactie;
        this.suma = suma;
        this.expeditor = expeditor;
        this.destinatar = destinatar;
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

    public String getDestinatar() {
        return destinatar;
    }

    public void setDestinatar(String destinatar) {
        this.destinatar = destinatar;
    }

//    public int returnTip(Tip tip){
////        switch (tip){
////            case Tip.PLATA:
////                return 1;
////        }
//
//        tip.ordinal();

   // }

    @Override
    public String toString() {

        if(this.tipTranzactie.equals(Tip.PLATA))
            return "Tranzactie de " +
                    "tip " + tipTranzactie +
                    ", Suma: " + suma+
                    ", Catre " + destinatar;
        else {
            return "Tranzactie de " +
                    "tip " + tipTranzactie +
                    ", Suma: " + suma+
                    ", De la " + destinatar;
        }
    }

    public String writeToFile() {
        return tipTranzactie.ordinal() +" "+ suma +" "+ expeditor +" "+ destinatar;
    }
}
