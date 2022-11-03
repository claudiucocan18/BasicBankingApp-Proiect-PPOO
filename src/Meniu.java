import java.io.*;
import java.util.Scanner;

public class Meniu {


    public void afisareClienti() throws IOException, ClassNotFoundException {


          double[] dobanzi = {1,2,3,4,5,6,7,8,9,1,2,3};
//        Map<Tip, Double> comisioane = new HashMap<>();
//        comisioane.put(Tip.INCASARE,1.2);
//        comisioane.put(Tip.PLATA,2.5);
//        comisioane.put(Tip.RAMBURSARE,0.0);
//
          Banca ing = new Banca("Ing",dobanzi);
//        Client c1 = new Client(2900,true);


        File myObj = new File("clienti.txt");
        Scanner input = new Scanner(myObj);


       // myReader.useDelimiter("\n");
        while(input.hasNext()) {

            String nume = input.next();
            Double sold = input.nextDouble();
            Boolean activ = input.nextBoolean();

            Client c1 = new Client(nume, sold,activ);
            ing.getListaClienti().add(c1);

        }

        for(Client c: ing.getListaClienti()){
            System.out.println(c);
        }




    }

}
