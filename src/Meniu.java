import java.io.IOException;
import java.util.HashSet;
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
            if(consoleIn.next().equals("c"))
                return;
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

        for(Map.Entry <Integer,Tranzactie> mt : preluareDate.mapTranzactii.entrySet()){
            if(c.getNume().equals(mt.getValue().getNumeClient())){
                System.out.println(i + ") "+"Id: "+ mt.getKey() +" "+ mt.getValue());
                i++;
            }
        }


        meniufinal();
    }

    public void meniufinal() throws IOException {

        System.out.println("Selecteaza o tranzactie");
        Scanner consoleIn = new Scanner(System.in);
        String input = consoleIn.next();

        switch (input){
            case "+t":
                adaugaTranzactie(indexBanca, indexClient);

            case "+c":
                adaugaCredit(indexBanca, indexClient);
        }

        NavigareGenerala("2",4);
    }

    private void adaugaCredit(int indexBanca, int indexClient) {
    }

    private void adaugaTranzactie(int indexBanca, int indexClient) {
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
