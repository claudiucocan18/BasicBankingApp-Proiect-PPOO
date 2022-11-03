import java.util.*;


public class Banca {

    private String denumire;

    private double[] valoareLunaraDobanda = new double[12]; // de adaugat
    private List<Client> listaClienti = new ArrayList<>();




    public Banca(String denumire) {
        this.denumire = denumire;
        this.listaClienti = listaClienti;
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

    public List<Client> getListaClienti() {
        return listaClienti;
    }

    public void setListaClienti(List<Client> listaClienti) {
        this.listaClienti = listaClienti;
    }

    @Override
    public String toString() {
        return "Banca{" +
                "denumire='" + denumire + '\'' +
                ", valoareLunaraDobanda=" + Arrays.toString(valoareLunaraDobanda) +
                ", clienti=" + listaClienti +
                '}';
    }
}
