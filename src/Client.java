import java.text.DecimalFormat;
import java.util.*;

public class Client {

    /**Client
     * private String nume;
     *     private Double sold;
     *     private boolean contActiv;
     *     private String numeBanca;
     *     private Map<Integer,Tranzactie> listaTranzactii;
     *     private static int[] salariiAnCurent;
     */

    private String nume;
    private Double sold;
    private boolean contActiv;
    private String numeBanca;

    private Map<Integer,Tranzactie> listaTranzactii = new HashMap<>();
    private static int[] salariiAnCurent =
            {3000,3000,3000,3000,4200,4200,4200,4200,4200,4200,4200,4200};//new int[12]; //de adaugat


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


    public String getNumeBanca() {
        return numeBanca;
    }

    public void setNumeBanca(String numeBanca) {
        this.numeBanca = numeBanca;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Client{" +
                "nume='" + nume + '\'' +
                ", salariiAnCurent=" + Arrays.toString(salariiAnCurent) +
                ", sold=" + df.format(sold) +
                ", contActiv=" + contActiv +
                ", listaTranzactii=" + listaTranzactii +
                ", numeBanca='" + numeBanca + '\'' +
                '}';
    }

    public String writeToFile(){
        DecimalFormat df = new DecimalFormat("#.##");
        return nume +" "+ sold +" "+ contActiv +" "+ numeBanca;
    }

}

