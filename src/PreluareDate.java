import java.io.*;
import java.util.*;

public class PreluareDate {

    List<Banca> listaBanciCitite = new ArrayList<>();
    List<Client> listaClientiCititi = new ArrayList<>();
    //List<Tranzactie> listaTranzactiiCitite = new ArrayList<>();
    Map<Integer, Tranzactie> mapTranzactiiCitite = new HashMap<>();
    List<Credit> listaCrediteCitite = new ArrayList<>();


    public void citireDate(String dateBanci, String dateClienti, String dateTranzactii, String dateCredite) throws IOException {

        File myObj;

        // read banci

            myObj = new File(dateBanci);
            Scanner inputBanci = new Scanner(myObj);

            while (inputBanci.hasNext()) {

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

            int id = inputTranzactii.nextInt();
            int tipTranzactieIndex = inputTranzactii.nextInt();
            Double suma = inputTranzactii.nextDouble();
            String numeClientTranzactie = inputTranzactii.next();
            String destinatarTranzactie = inputTranzactii.next();

            Tranzactie t1 = new Tranzactie(tipFromInteger(tipTranzactieIndex),suma, numeClientTranzactie, destinatarTranzactie);
            //listaTranzactiiCitite.add(t1);
            mapTranzactiiCitite.put(id,t1);

        }
        inputTranzactii.close();


//credite
        myObj = new File(dateCredite);
        Scanner inputCredite = new Scanner(myObj);

        while(inputCredite.hasNext()) {

            int idCredit = inputCredite.nextInt();
            int nrRate = inputCredite.nextInt();
            String numeClientCredit = inputCredite.next();
            Double sumaCredit = inputCredite.nextDouble();


            Credit credit = new Credit(idCredit, nrRate, numeClientCredit, sumaCredit);
            listaCrediteCitite.add(credit);

        }
        inputCredite.close();


//        for(Tranzactie c: listaTranzactiiCitite){
//            System.out.println(c.getSuma());
//        }

    }

    // convert from int to Tip
    public static Tip tipFromInteger(int x) {
        switch(x) {
            case 0:
                return Tip.INCASARE;
            case 1:
                return Tip.PLATA;

        }
        return Tip.RAMBURSARE;
    }

    public void ClearListe(){

        listaClientiCititi.clear();
        listaBanciCitite.clear();
        mapTranzactiiCitite.clear();
    }

    public void SincronizareDate(){

        try {

            if(!listaBanciCitite.isEmpty()) {
                for (Banca b : listaBanciCitite) {
                    for (Client c : listaClientiCititi) {
                        if (c.getNumeBanca().equals(b.getDenumire())) {
                            b.getListaClienti().add(c);
                        }
                    }
                }

                for (Client c : listaClientiCititi) {
                    for (Map.Entry<Integer, Tranzactie> mt : mapTranzactiiCitite.entrySet()) {

                        if (mt.getValue().equals(c.getNume()))
                            c.getListaTranzactii().put(mt.getKey(), mt.getValue());
                    }
                }
            }
            else throw new ExceptieSalvareFisiere("Nu exista banci in fisiere");
        }
        catch (ExceptieSalvareFisiere e){
            System.out.println(e);
            System.out.println("Adaugati cel putin o banca in sursa de date");
            System.out.println("Aplicatia se inchide...");
            //fara autosave
            System.exit(0);
            //fara autosave
        }


    }



}
