import java.io.IOException;
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
            if(consoleIn.next().equals("c")){

                System.out.println("Aplicatia se inchide...");
                return;
            }

            else {
                System.out.println("Ati introdus o optiune invalida");

                afisareMeniuBanci(preluareDate);
            }
        }
            consoleIn.close();

    }



public void afisareMeniuClienti(PreluareDate preluareDate) throws IOException {

    System.out.println("Selectati clientul dorit");
    System.out.println("b - Inapoi, c- Parasiti aplicatia");
    Scanner consoleIn = new Scanner(System.in);
    String primit = consoleIn.next();
    try {

        indexClient = Integer.parseInt(primit);
        this.afisareDateClient(indexClient);
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
        Banca banca= preluareDate.listaBanciCitite.get(indexBanca);
        System.out.println("--------------------------------");
        System.out.println("Clienti:");
        for (Client client : banca.getListaClienti()) {

            System.out.println(i+") "+client.getNume());
            i++;
        }
    }

    public void afisareDateClient(int indexClient) throws IOException {

        Client c = preluareDate.listaClientiCititi.get(indexClient);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

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


        meniufinal();
    }

    public void meniufinal() throws IOException {

        System.out.println();
        System.out.println("+t Realizeaza o tranzactie, +c Aplica pentru un credit");
        System.out.println("b - Inapoi, c- Parasiti aplicatia");

        Scanner consoleIn = new Scanner(System.in);
        String input = consoleIn.next();


        switch (input){
            case "+t":
                adaugaTranzactie(indexClient);
                break;

            case "+c":
                adaugaCredit(indexBanca, indexClient);
                break;

            default:
                NavigareGenerala(input,3);
                break;
        }

    }

    private void adaugaCredit(int indexBanca, int indexClient) {
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

                client.setSold(client.getSold() - suma);

                Tranzactie tranzactie = new Tranzactie(Tip.PLATA, suma, numeClient, numeDestinatar);
                Tranzactie tranzactieInversa = new Tranzactie(Tip.INCASARE, suma, numeDestinatar, numeClient);

                //int idTranzactie = (int) (1000+Math.random() * 1000);
                preluareDate.mapTranzactiiCitite.put((int) (1000 + Math.random() * 1000), tranzactie);
                preluareDate.mapTranzactiiCitite.put((int) (1000 + Math.random() * 1000), tranzactieInversa);

            } else {
                System.out.println("Destinatarul nu poate fi acelasi cu expeditorul");
                System.out.println("Introduceti datele corecte");
                adaugaTranzactie(indexClient);
            }
        }
        catch (Exception e){

            System.out.println("Datele introduse sunt incorecte. Reincercati...");
            adaugaTranzactie(indexClient);

        }

        System.out.println("Tranzactie realizata cu succes!");
        System.out.println();
        System.out.println("b - Inapoi, c- Parasiti aplicatia");
        NavigareGenerala(consoleIn.next(),4);

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
                return;
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
                return;

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

                    case 4:
                        afisareTranzactii(indexClient);
                        meniufinal();
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
                System.out.println("b - Inapoi, c- Parasiti aplicatia");
                System.out.println("--------------------------------");
                NavigareGenerala(s,nivel);
                break;
            }

        }

    }



}
