import java.util.*;


public class Banca {

    private String denumire;
    private double[] valoareLunaraDobanda = new double[12];

    private List<Client> clienti= new ArrayList<>();;

    public Banca(String denumire, double[] valoareLunaraDobanda) {
        this.denumire = denumire;
        this.valoareLunaraDobanda = valoareLunaraDobanda;
        this.clienti = clienti;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double[] getValoareLunaraDobanda() {
        return valoareLunaraDobanda;
    }

    public void setValoareLunaraDobanda(double[] valoareLunaraDobanda) {
        this.valoareLunaraDobanda = valoareLunaraDobanda;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }

    @Override
    public String toString() {
        return "Banca{" +
                "denumire='" + denumire + '\'' +
                ", valoareLunaraDobanda=" + Arrays.toString(valoareLunaraDobanda) +
                ", clienti=" + clienti +
                '}';
    }
}
