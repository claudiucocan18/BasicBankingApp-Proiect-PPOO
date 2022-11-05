import java.io.IOException;
import java.util.Scanner;

public class Meniu {

    PreluareDate preluareDateInMeniu = new PreluareDate();


    public void afisareListaBanci(PreluareDate preluareDate){
        int i = 0;
        System.out.println("Banci:");
        for (Banca banca : preluareDate.listaBanciCitite) {
            System.out.println(i+") "+banca.getDenumire());
            i++;
        }

    }

    public void afisareMeniuBanci(PreluareDate preluareDate) {
        this.afisareListaBanci(preluareDate);
        Scanner consoleIn = new Scanner(System.in);

        System.out.println();
        System.out.println("Selectati banca dorita sau parasiti aplicatia folosind tasta c");

        try {
            int indexBanca = consoleIn.nextInt();
            this.afisareClienti(preluareDate.listaBanciCitite.get(indexBanca));
            //this.NavigareBanci(preluareDate);
            System.out.println("c- Parasiti aplicatia");

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



public void afisareMeniuClienti(PreluareDate preluareDate){
    Scanner consoleIn = new Scanner(System.in);
    int indexClient = consoleIn.nextInt();
    this.afisareDateClient(preluareDate.listaClientiCititi.get(indexClient));
    NavigareGenerala(preluareDate);

}

    public void afisareClienti(Banca banca) throws IOException {
        int i = 0;
        System.out.println("--------------------------------");
        System.out.println("Clienti:");
        for (Client client : banca.getListaClienti()) {

            System.out.println(i+") "+client.getNume());
            i++;
        }
    }

    public void afisareDateClient(Client c){
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


    }


    public void afisareTranzactii(){

    }


    public void adaugaBanca() {
        System.out.println("--------------------------------");
        System.out.println("Adaugare Banca");
        System.out.println();
        System.out.println("Adauga denumire");
    }

    public void NavigareBanci(PreluareDate preluareDate){
        System.out.println("--------------------------------");
        System.out.println("c- Parasiti aplicatia");
        Scanner consoleIn = new Scanner(System.in);

        switch (consoleIn.next()){
            case "c": return;

            default:
                System.out.println("--------------------------------");
                System.out.println("Optiune inexistenta");
                NavigareBanci(preluareDate);

        }
    }


    public void NavigareGenerala(PreluareDate preluareDate){
        System.out.println("--------------------------------");
        System.out.println("b - Inapoi, c- Parasiti aplicatia");
        Scanner consoleIn = new Scanner(System.in);

        switch (consoleIn.next()){
            case "c": return;
            case "b": afisareMeniuBanci(preluareDate);
            default:
                System.out.println("--------------------------------");
                System.out.println("Optiune inexistenta");
                NavigareGenerala(preluareDate);
        }
    }

}
