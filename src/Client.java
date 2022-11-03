import java.util.*;

public class Client {

    private String nume;
    private Double sold;
    private boolean contActiv;
    private String numeBanca;

    private Map<Integer,Tranzactie> listaTranzactii = new HashMap<>();
    private int[] salariiAnCurent = new int[12]; //de adaugat




    public Client() {
    }

    public Client(String nume, Double sold, boolean contActiv, String numeBanca) {
        //this.salariiAnCurent = salariiAnCurent;
        this.nume = nume;
        this.sold = sold;
        this.contActiv = contActiv;
        this.numeBanca=numeBanca;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Map<Integer, Tranzactie> getListaTranzactii() {
        return listaTranzactii;
    }

    public void setListaTranzactii(Map<Integer, Tranzactie> listaTranzactii) {
        this.listaTranzactii = listaTranzactii;
    }

    public int[] getSalariiAnCurent() {
        return salariiAnCurent;
    }

    public void setSalariiAnCurent(int[] salariiAnCurent) {
        this.salariiAnCurent = salariiAnCurent;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public boolean isContActiv() {
        return contActiv;
    }

    public void setContActiv(boolean contActiv) {
        this.contActiv = contActiv;
    }

    public Map<Integer, Tranzactie> getComisioaneClient() {
        return listaTranzactii;
    }

    public void setComisioaneClient(Map<Integer, Tranzactie> comisioaneClient) {
        this.listaTranzactii = comisioaneClient;
    }

    public String getNumeBanca() {
        return numeBanca;
    }

    public void setNumeBanca(String numeBanca) {
        this.numeBanca = numeBanca;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", salariiAnCurent=" + Arrays.toString(salariiAnCurent) +
                ", sold=" + sold +
                ", contActiv=" + contActiv +
                ", listaTranzactii=" + listaTranzactii +
                ", numeBanca='" + numeBanca + '\'' +
                '}';
    }

}
