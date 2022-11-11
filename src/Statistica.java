import java.text.DecimalFormat;

public class Statistica {

    String banca;
    int nrTranzactiiPlata;
    int nrTranzactiiIncasare;
    double sumaMedie;
    String data;

    public Statistica(String banca, int nrTranzactiiPlata, int nrTranzactiiIncasare, double sumaMedie, String data) {
        this.banca = banca;
        this.nrTranzactiiPlata = nrTranzactiiPlata;
        this.nrTranzactiiIncasare = nrTranzactiiIncasare;
        this.sumaMedie = sumaMedie;
        this.data = data;
    }


    public String getBanca() {
        return banca;
    }

    public void setBanca(String banca) {
        this.banca = banca;
    }

    public int getNrTranzactiiPlata() {
        return nrTranzactiiPlata;
    }

    public void setNrTranzactiiPlata(int nrTranzactiiPlata) {
        this.nrTranzactiiPlata = nrTranzactiiPlata;
    }

    public int getNrTranzactiiIncasare() {
        return nrTranzactiiIncasare;
    }

    public void setNrTranzactiiIncasare(int nrTranzactiiIncasare) {
        this.nrTranzactiiIncasare = nrTranzactiiIncasare;
    }

    public double getSumaMedie() {
        return sumaMedie;
    }

    public void setSumaMedie(double sumaMedie) {
        this.sumaMedie = sumaMedie;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return  "Banca: " + banca + "\n"+
                "Plati efectuate de client: " + nrTranzactiiPlata +"\n"+
                "Plati primite de client: " + nrTranzactiiIncasare +"\n"+
                "Suma medie a tranzactiilor: " + df.format(sumaMedie) +"\n"+
                "Data salvarii statisticii: " + data +"\n";

    }

    public String writeToFile() {
        DecimalFormat df = new DecimalFormat("#.##");
        return banca +" "+  nrTranzactiiPlata +" "+ nrTranzactiiIncasare +" "+  df.format(sumaMedie) +" "+ data;
    }
}
//
