import java.text.DecimalFormat;

public class Credit {

    int id;
    int nrRate;
    String numeClient;
    Double suma;
    Double rataLunara;

    public Credit(){
        this.id = 0;
        this.nrRate = 0;
        this.numeClient="";
        this.suma = 0.0;
        this.rataLunara=0.0;
    }

    public Credit(int id, int nrRate, String numeClient, Double rataLunara, Double suma) {
        this.id = id;
        this.nrRate = nrRate;
        this.numeClient = numeClient;
        this.suma = suma;
        this.rataLunara=rataLunara;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrRate() {
        return nrRate;
    }

    public void setNrRate(int nrRate) {
        this.nrRate = nrRate;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public Double getRataLunara() {
        return rataLunara;
    }

    public void setRataLunara(Double rataLunara) {
        this.rataLunara = rataLunara;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return  "Id: " + id +
                ", Numar de rate " + nrRate +
                ", Suma imprumutata " + suma + " RON" +
                ", Rata lunara " + df.format(rataLunara) + " RON" ;
    }

    public String writeToFile() {
        DecimalFormat df = new DecimalFormat("#.##");
        return id +" "+ nrRate +" "+ numeClient +" "+ df.format(rataLunara) +" "+ df.format(suma);
    }
}

