import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        double[] dobanzi = {1,2,3,4,5,6,7,8,9,1,2,3};
//        Map<Tip, Double> comisioane = new HashMap<>();
//        comisioane.put(Tip.INCASARE,1.2);
//        comisioane.put(Tip.PLATA,2.5);
//        comisioane.put(Tip.RAMBURSARE,0.0);
//
//        Banca Ing = new Banca("Ing",dobanzi);
//        Client c1 = new Client(2900,true);

        Citire m1 = new Citire();

        m1.citireDate("banci.txt","clienti.txt","tranzactii.txt");
    }



}




//dobanda banca
//comision
//tranzactii
//clienti