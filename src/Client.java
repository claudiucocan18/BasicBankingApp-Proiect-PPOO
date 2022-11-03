import java.util.*;

public class Client {

    private int[] salariiAnCurent = new int[12];
    private float sold;
    private boolean contActiv;
    private Map<Tip,Double> comisioaneClient = new HashMap<>();

    public Client(float sold, boolean contActiv, Map<Tip, Double> comisioaneClient) {
        //this.salariiAnCurent = salariiAnCurent;
        this.sold = sold;
        this.contActiv = contActiv;
        this.comisioaneClient = comisioaneClient;
    }

    public int[] getSalariiAnCurent() {
        return salariiAnCurent;
    }

    public void setSalariiAnCurent(int[] salariiAnCurent) {
        this.salariiAnCurent = salariiAnCurent;
    }

    public float getSold() {
        return sold;
    }

    public void setSold(float sold) {
        this.sold = sold;
    }

    public boolean isContActiv() {
        return contActiv;
    }

    public void setContActiv(boolean contActiv) {
        this.contActiv = contActiv;
    }

    public Map<Tip, Double> getComisioaneClient() {
        return comisioaneClient;
    }

    public void setComisioaneClient(Map<Tip, Double> comisioaneClient) {
        this.comisioaneClient = comisioaneClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "salariiAnCurent=" + Arrays.toString(salariiAnCurent) +
                ", sold=" + sold +
                ", contActiv=" + contActiv +
                ", comisioaneClient=" + comisioaneClient +
                '}';
    }
}
