public class Credit {

    int id;
    int nrRate;
    String numeClient;
    Double suma;

    public Credit(){
        this.id = 0;
        this.nrRate = 0;
        this.numeClient="";
        this.suma = 0.0;

    }

    public Credit(int id, int nrRate, String numeClient, Double suma) {
        this.id = id;
        this.nrRate = nrRate;
        this.numeClient = numeClient;
        this.suma = suma;
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

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", nrRate=" + nrRate +
                ", numeClient='" + numeClient + '\'' +
                ", suma=" + suma +
                '}';
    }
}
