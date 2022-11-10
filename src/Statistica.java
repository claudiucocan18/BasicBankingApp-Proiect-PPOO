import java.time.LocalDate;
import java.util.Date;

public class Statistica {

    String banca;
    int nrTranzactiiPlata;
    int getNrTranzactiiIncasare;
    double sumaMedie;
    LocalDate data;

    public Statistica(String banca, int nrTranzactiiPlata, int getNrTranzactiiIncasare, double sumaMedie, LocalDate data) {
        this.banca = banca;
        this.nrTranzactiiPlata = nrTranzactiiPlata;
        this.getNrTranzactiiIncasare = getNrTranzactiiIncasare;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  "Banca: " + banca + "\n"+
                "Plati efectuate de client: " + nrTranzactiiPlata +"\n"+
                "Plati primite de client: " + getNrTranzactiiIncasare +"\n"+
                "Suma medie a tranzactiilor: " + sumaMedie +"\n"+
                "Data salvarii statisticii: " + data +"\n"
                ;

    }
}
