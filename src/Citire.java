import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Citire {




    public void citireDate(String dateBanci, String dateClienti, String dateTranzactii) throws IOException {

        List<Banca> listaBanciCitite = new ArrayList<>();
        List<Client> listaClientiCititi = new ArrayList<>();
        List<Tranzactie> listaTranzactiiCitite = new ArrayList<>();

        File myObj;


        // read banci
        myObj = new File(dateBanci);
        Scanner inputBanci = new Scanner(myObj);

        while(inputBanci.hasNext()) {

            String numeBanca = inputBanci.nextLine();
            Banca b1 = new Banca(numeBanca);
            listaBanciCitite.add(b1);

        }
        inputBanci.close();

        // read clienti

        myObj = new File(dateClienti);
        Scanner inputClienti = new Scanner(myObj);

        while(inputClienti.hasNext()) {

            String numeClient = inputClienti.next();
            Double sold = inputClienti.nextDouble();
            Boolean activ = inputClienti.nextBoolean();
            String numeBancaClient = inputClienti.next();

            Client c1 = new Client(numeClient, sold,activ, numeBancaClient);
            listaClientiCititi.add(c1);

        }
        inputClienti.close();

        // read tranzactii

        myObj = new File(dateTranzactii);
        Scanner inputTranzactii = new Scanner(myObj);

        while(inputTranzactii.hasNext()) {

            int tipTranzactieIndex = inputTranzactii.nextInt();
            Double suma = inputTranzactii.nextDouble();
            String numeClientTranzactie = inputTranzactii.next();

            Tranzactie t1 = new Tranzactie(tipFromInteger(tipTranzactieIndex),suma, numeClientTranzactie);
            listaTranzactiiCitite.add(t1);

        }
        inputTranzactii.close();


        for(Tranzactie c: listaTranzactiiCitite){
            System.out.println(c.getSuma());
        }




    }
    public static Tip tipFromInteger(int x) {
        switch(x) {
            case 0:
                return Tip.INCASARE;
            case 1:
                return Tip.PLATA;

        }
        return Tip.RAMBURSARE;
    }



}
