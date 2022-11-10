import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Meniu {

PreluareDate preluareDate;
int indexBanca;
int indexClient;
boolean checkClose = false;
boolean checkBack = false;

    public void afisareListaBanci(PreluareDate pdt){
        int i = 0;

        System.out.println("Banci:");
        preluareDate=pdt;
        for (Banca banca : preluareDate.listaBanciCitite) {
            System.out.println(i+") "+banca.getDenumire());
            i++;
        }

    }

    public void afisareMeniuBanci(PreluareDate preluareDate) {
        this.afisareListaBanci(preluareDate);
        Scanner consoleIn = new Scanner(System.in);;

        System.out.println();
        System.out.println("Selectati banca dorita sau parasiti aplicatia folosind tasta c");

        try {

            indexBanca = consoleIn.nextInt();
            this.afisareListaClienti(indexBanca);
            afisareMeniuClienti(preluareDate);

        } catch (Exception e) {
            String primit = consoleIn.next();

            if(primit.equals("c")){

                System.out.println("Aplicatia se inchide...");
                System.exit(0);
                //return;
            }

//            else if(primit.equals("s")){
//                System.out.println("Selectati banca pentru care doriti sa extrageti o situatie a tranzactiilor");
//                afisareStatistica(consoleIn.next());
//            }

            else {
                System.out.println("Ati introdus o optiune invalida");

                afisareMeniuBanci(preluareDate);
            }
        }
            consoleIn.close();

    }


    public void afisareMeniuClienti(PreluareDate preluareDate) throws IOException {

        if(preluareDate.listaBanciCitite.get(indexBanca).getListaClienti().isEmpty())
        {
            System.out.println("Nu exista clienti pentru aceasta banca");

        }
        else {System.out.println("\nSelectati clientul dorit");}

    System.out.println("b - Inapoi, c- Parasiti aplicatia");
    Scanner consoleIn = new Scanner(System.in);
    String primit = consoleIn.next();
    try {

        indexClient = Integer.parseInt(primit);
        if(preluareDate.listaClientiCititi.get(indexClient).getNumeBanca().equals(preluareDate.listaBanciCitite.get(indexBanca).getDenumire())) {
            this.afisareDateClient(indexClient);
        }
        //else throw new Exception("34t334t");
    }

    catch (Exception e){
        NavigareGenerala(primit,2);

        if(checkClose==false && checkBack == false) {
            afisareListaClienti(indexClient);
            afisareMeniuClienti(preluareDate);
        }
    }
    consoleIn.close();
}

    public void afisareListaClienti(int indexBanca) throws IOException {
        int i = 0;
        Banca banca = preluareDate.listaBanciCitite.get(indexBanca);
        System.out.println("--------------------------------");
        System.out.println("Clienti:");
        for (Client client : banca.getListaClienti()) {
        //for (Client client : preluareDate.listaClientiCititi) {
            System.out.println(i+") "+client.getNume());
            i++;
        }
    }

    public void afisareDateClient(int indexClient) throws IOException {

        Client c = preluareDate.listaClientiCititi.get(indexClient);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        System.out.println("\nDetalii client:\n");
        System.out.println("Nume: "+ c.getNume());
        System.out.println("Sold: "+ c.getSold());
        String s;

        if(c.isContActiv())
            {
                s = "Activ";
            }
        else {
                s= "Inactiv";
             }

        System.out.println("Status: "+s);

        System.out.println("Banca: "+c.getNumeBanca());

        afisareTranzactii(indexClient);

        Scanner consoleIn=new Scanner(System.in);
        String primit = consoleIn.next();
        NavigareGenerala(primit,3);


    }


    public void afisareTranzactii(int indexClient) throws IOException {

        int i=0;
        System.out.println("--------------------------------");
        System.out.println("Tranzactii: ");
        System.out.println();
        Client c = preluareDate.listaClientiCititi.get(indexClient);

        boolean existaTranzactii = false;

            for (Map.Entry<Integer, Tranzactie> mt : preluareDate.mapTranzactiiCitite.entrySet()) {
                if (c.getNume().equals(mt.getValue().getExpeditor())) {
                    System.out.println(i + ") " + "Id: " + mt.getKey() + " " + mt.getValue());
                    i++;
                    existaTranzactii=true;
                }
            }

            if (existaTranzactii == false)
                System.out.println("Nu exista tranzactii");

        System.out.println();
        System.out.println("Credite:");
        System.out.println();
        int ic =0;
        for (Credit credit : preluareDate.listaCrediteCitite) {
            System.out.println(credit);
            ic++;

        }

        if(ic==0){
            System.out.println("Nu exista credite");
        }


        meniufinal();
    }

    public void meniufinal() throws IOException {

        System.out.println();
        System.out.println("+t Realizeaza o tranzactie, +c Aplica pentru un credit");
        System.out.println("b - Inapoi, c- Parasiti aplicatia");
        System.out.println("e - Modificati detaliile contului, s - Creati un raport");

        Scanner consoleIn = new Scanner(System.in);
        String input = consoleIn.next();


        switch (input){
            case "+t":
                adaugaTranzactie(indexClient);
                break;

            case "+c":
                adaugaCredit(indexBanca, indexClient);
                break;

            case "e":
                modificareDateClient(indexClient);

            case "s":
                afisareStatistica(indexClient);

            default:

                System.out.println("Ati introdus o optiune invalida");
                System.out.println("Introduceti orice tasta");
               // meniufinal();
                NavigareGenerala(input,3);
                //afisareDateClient(indexClient);
                //System.out.println("In pasul anterior s-a introdus o optiune invalida");
                break;
        }

    }

    private void afisareStatistica(int indexClient) throws IOException {

        try {

            Client client = preluareDate.listaClientiCititi.get(indexClient);

            if (((Object) indexClient).getClass().getSimpleName().equals("Integer")) {

                double sumaMedie = 0;
                int nrPlati = 0;
                int nrIncasari = 0;
                LocalDate data = LocalDate.now();



                for (Map.Entry<Integer, Tranzactie> mt : preluareDate.mapTranzactiiCitite.entrySet()) {
                    if (mt.getValue().getDestinatar().equals(client.getNume())) {
                        sumaMedie += mt.getValue().getSuma();
                        nrIncasari++;
                    } else if (mt.getValue().getExpeditor().equals(client.getNume())) {
                        sumaMedie += mt.getValue().getSuma();
                        nrPlati++;
                    }

                }

                Statistica statistica = new Statistica(client.getNumeBanca(),nrPlati,nrIncasari,sumaMedie,data);
                preluareDate.listaStatisticiCitite.add(statistica);
                System.out.println(statistica);
                Scanner consoleIn = new Scanner(System.in);
                NavigareGenerala(consoleIn.next(),3);



            }
            else throw new ExceptieTipInput("Statistica nu a putut fi afisata");
        }
        catch (ExceptieTipInput | IOException e){
            System.out.println(e);
            Scanner consoleIn = new Scanner(System.in);
            NavigareGenerala(consoleIn.next(),3);
        }
    }

    private void modificareDateClient(int indexClient) throws IOException {

        System.out.println("1) Modifica nume");
        System.out.println("2) Inactiveaza contul");
        System.out.println("\nb - Inapoi, c- Parasiti aplicatia");

        Client client = preluareDate.listaClientiCititi.get(indexClient);

        Scanner consoleIn = new Scanner(System.in);
        String primit = consoleIn.next();

        switch (primit){
            case "1":
                System.out.println("Introdu noul nume:");
                String numeNouClient= consoleIn.next();

                for(Map.Entry<Integer, Tranzactie> mt : preluareDate.mapTranzactiiCitite.entrySet())
                {
                    if( mt.getValue().getExpeditor().equals(preluareDate.listaClientiCititi.get(indexClient).getNume()))
                              mt.getValue().setExpeditor(numeNouClient);
                    if(mt.getValue().getDestinatar().equals(preluareDate.listaClientiCititi.get(indexClient).getNume()))
                        mt.getValue().setDestinatar(numeNouClient);

                }

                preluareDate.listaClientiCititi.get(indexClient).setNume(numeNouClient);
                System.out.println("Numele a fost modificat");
                afisareDateClient(indexClient);
                meniufinal();
                break;

            case "2":
                preluareDate.listaClientiCititi.get(indexClient).setContActiv(false);
                System.out.println("Contul a fost inactivat");

                System.out.println("Doriti sa stergeti contul definitiv? Aceasta actiune este ireversibila (y/n)");
                String raspuns = consoleIn.next();
                switch (raspuns){
                    case "y":


                        preluareDate.listaClientiCititi.remove(indexClient);
                        preluareDate.listaBanciCitite.get(indexBanca).getListaClienti().remove(indexClient);
                        System.out.println("Contul a fost sters");
                        afisareListaClienti(indexBanca);
                        //afisareDateClient(indexClient);
                        afisareMeniuClienti(preluareDate);


                    default:
                        System.out.println("Contul de client a fost doar inactivat");
                        afisareDateClient(indexClient);
                        meniufinal();
                }
                afisareDateClient(indexClient);
                meniufinal();
                break;

            default:
                System.out.println("Optiune invalida. Introduceti orice tasta pentru a va intoarce.");
                NavigareGenerala(primit,3);
                break;


        }



    }


    private void adaugaCredit(int indexBanca, int indexClient) throws IOException {

      try {

          Banca banca = preluareDate.listaBanciCitite.get(indexBanca);
          Credit credit = new Credit();
          Client client= preluareDate.listaClientiCititi.get(indexClient);
          Scanner consoleIn = new Scanner(System.in);
          credit.setId((int) (1000 + Math.random() * 1000));
          System.out.println("Ce suma de bani doriti sa obtineti?");
          credit.setSuma(consoleIn.nextDouble());

          System.out.println("In cat timp doriti sa restituiti imprumutul? (luni)");
          credit.setNrRate(consoleIn.nextInt());
          credit.setNumeClient(client.getNume());

          int lunaCurenta;
          lunaCurenta = LocalDate.now().getMonthValue();
          double rataLunara = credit.suma / credit.nrRate *(1 + banca.getValoareLunaraDobanda()[lunaCurenta]/100);

          if (rataLunara <= Arrays.stream(client.getSalariiAnCurent()).sum() / 24) {
              System.out.println("Credit aprobat");
              credit.setRataLunara(rataLunara);
              preluareDate.listaCrediteCitite.add(credit);
              System.out.println();
              System.out.println("b - Inapoi, c- Parasiti aplicatia");

          }

          else{
              System.out.println("Nu sunteti eligibil pentru acordarea creditului solicitat");
              System.out.println();System.out.println();
              System.out.println("Reincercare...");
              System.out.println();
              adaugaCredit(indexBanca,indexClient);

          }
      }
      catch (Exception e){

              System.out.println("Datele introduse sunt incorecte. Reincercati...");
              //adaugaCredit(indexBanca,indexClient);
              afisareDateClient(indexClient);
              afisareMeniuClienti(preluareDate);

          }

      }


    private void adaugaTranzactie( int indexClient) throws IOException {

        System.out.println("Date tranzactie noua:");
        Scanner consoleIn = new Scanner(System.in);

        String numeClient = preluareDate.listaClientiCititi.get(indexClient).getNume();
        Client client = preluareDate.listaClientiCititi.get(indexClient);

        try {
            System.out.print("Suma: ");
            Double suma = consoleIn.nextDouble();
            System.out.println();

            System.out.print("Destinatar: ");
            String numeDestinatar = consoleIn.next();
            System.out.println();

            if (!numeDestinatar.equals(client.getNume())) {

                Client destinatar = null;
                for (Client c : preluareDate.listaClientiCititi) {
                    if (c.getNume().equals(numeDestinatar))
                        destinatar = new Client(c.getNume(), c.getSold(), c.isContActiv(), c.getNumeBanca());
                }

                if (destinatar != null) {

                    destinatar.setSold(client.getSold() + suma);

                }


                if( client.getSold() >= suma ) {
                    client.setSold(client.getSold() - suma);

                    Tranzactie tranzactie = new Tranzactie(Tip.PLATA, suma, numeClient, numeDestinatar);
                    Tranzactie tranzactieInversa = new Tranzactie(Tip.INCASARE, suma, numeDestinatar, numeClient);

                    //int idTranzactie = (int) (1000+Math.random() * 1000);
                    preluareDate.mapTranzactiiCitite.put((int) (1000 + Math.random() * 1000), tranzactie);
                    preluareDate.mapTranzactiiCitite.put((int) (1000 + Math.random() * 1000), tranzactieInversa);
                }
                else{
                    System.out.println("Fonduri insuficiente. Reincercati...");
                    adaugaTranzactie(indexClient);
                }

            } else {
                System.out.println("Destinatarul nu poate fi acelasi cu expeditorul");
                System.out.println("Introduceti datele corecte");
                adaugaTranzactie(indexClient);
            }
        }
        catch (Exception e){

            System.out.println("Datele introduse sunt incorecte. Reincercati...");
            //adaugaTranzactie(indexClient);
            afisareDateClient(indexClient);
            afisareMeniuClienti(preluareDate);

        }

        System.out.println("Tranzactie realizata cu succes!");
        System.out.println();
        afisareDateClient(indexClient);
        //System.out.println("b - Inapoi, c- Parasiti aplicatia");
        //NavigareGenerala(consoleIn.next(),4);

    }


    public void adaugaBanca() {
        System.out.println("--------------------------------");
        System.out.println("Adaugare Banca");
        System.out.println();
        System.out.println("Adauga denumire");
    }

    public void NavigareBanci(PreluareDate preluareDate){
        System.out.println("--------------------------------");
        System.out.println("c - Parasiti aplicatia");
        Scanner consoleIn = new Scanner(System.in);

        switch (consoleIn.next()){
            case "c": {
                System.out.println("Aplicatia se inchide...");
                System.exit(0);
                // return;
            }

            default:
                System.out.println("--------------------------------");
                System.out.println("Optiune inexistenta");
                afisareListaBanci(preluareDate);
                afisareMeniuBanci(preluareDate);

        }
    }


    public void NavigareGenerala(String primit, int nivel) throws IOException {
       // System.out.println("--------------------------------");
        //System.out.println("b - Inapoi, c- Parasiti aplicatia");
        checkClose = false;
        checkBack = false;
        switch (primit) {
            case "c": {
                System.out.println("Aplicatia se inchide...");
                checkClose = true;
                autoSaveFisiere();
                System.exit(0);

            }
            case "b": {
                switch (nivel) {
                    case 2:
                        afisareMeniuBanci(preluareDate);
                        checkBack = true;
                        break;
                    case 3:
                        afisareListaClienti(indexBanca);
                        afisareMeniuClienti(preluareDate);
                        checkBack = true;
                        break;

//                    case 4:
//                        afisareTranzactii(indexClient);
//                        meniufinal();
                    default:
                        System.out.println("Nivelul este necunoscut");
                        break;
                }
                break;
            }

            default: {
                Scanner consoleIn = new Scanner(System.in);
                String s = consoleIn.next();
                System.out.println("--------------------------------");
                System.out.println("Optiune inexistenta");
               // System.out.println("b - Inapoi, c - Parasiti aplicatia");
               // System.out.println("--------------------------------");

                switch (nivel){
                    case 2:
                    {
                        afisareListaClienti(indexBanca);
                        afisareMeniuClienti(preluareDate);
                        break;
                    }
                    case 3:
                    {
                        afisareDateClient(indexClient);
                        meniufinal();
                        break;
                    }

                    default: NavigareGenerala(s,nivel);
                }
                //NavigareGenerala(s,nivel);
                break;
            }

        }

    }

public void autoSaveFisiere(){
    try {
        FileWriter writerBanci = new FileWriter("filename1.txt");
        FileWriter writerClienti = new FileWriter("filename2.txt");
        FileWriter writerTranzactii = new FileWriter("filename3.txt");
        FileWriter writerCredite = new FileWriter("filename4.txt");

        for(Banca banca : preluareDate.listaBanciCitite){
            writerBanci.write(banca.writeToFile()+"\n");
        }


        for(Client client : preluareDate.listaClientiCititi) {
            writerClienti.write(client.writeToFile()+"\n");
        }

        for(Map.Entry<Integer, Tranzactie> mt : preluareDate.mapTranzactiiCitite.entrySet())
        {
            writerTranzactii.write(mt.getKey()+" "+mt.getValue().writeToFile()+"\n");
        }


        for(Credit credit : preluareDate.listaCrediteCitite) {
            writerCredite.write(credit.writeToFile()+"\n");
        }

        writerBanci.close();
        writerClienti.close();
        writerTranzactii.close();
        writerCredite.close();
        //System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("A aparut o eroare la salvare.");
        e.printStackTrace();
    }

}

}
