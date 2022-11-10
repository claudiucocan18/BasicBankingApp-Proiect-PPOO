import java.util.Date;

public class Statistica {

    Banca banca;
    int nrTranzactiiPlata;
    int getNrTranzactiiIncasare;
    double sumaMedie;
    Date data;

    public Statistica(Banca banca, int nrTranzactiiPlata, int getNrTranzactiiIncasare, double sumaMedie, Date data) {
        this.banca = banca;
        this.nrTranzactiiPlata = nrTranzactiiPlata;
        this.getNrTranzactiiIncasare = getNrTranzactiiIncasare;
        this.sumaMedie = sumaMedie;
        this.data = data;
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public int getNrTranzactiiPlata() {
        return nrTranzactiiPlata;
    }

    public void setNrTranzactiiPlata(int nrTranzactiiPlata) {
        this.nrTranzactiiPlata = nrTranzactiiPlata;
    }

    public int getGetNrTranzactiiIncasare() {
        return getNrTranzactiiIncasare;
    }

    public void setGetNrTranzactiiIncasare(int getNrTranzactiiIncasare) {
        this.getNrTranzactiiIncasare = getNrTranzactiiIncasare;
    }

    public double getSumaMedie() {
        return sumaMedie;
    }

    public void setSumaMedie(double sumaMedie) {
        this.sumaMedie = sumaMedie;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  "Banca: " + banca + "\n"+
                "Plati efectuate de clienti: " + nrTranzactiiPlata +"\n"+
                "Plati primite de clienti: " + getNrTranzactiiIncasare +"\n"+
                "Suma medie a tranzactiilor: " + sumaMedie +"\n"+
                "Data salvarii statisticii: " + data +"\n"
                ;

    }
}
