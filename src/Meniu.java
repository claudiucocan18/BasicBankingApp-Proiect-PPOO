import java.io.IOException;

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

    public void afisareClienti(Banca banca) throws IOException {
        int i = 0;
        System.out.println("Clienti:");
        for (Client client : banca.getListaClienti()) {

            System.out.println(i+") "+client.getNume());
            i++;
        }


    }

    public void afisareDateClient(Client c){
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

        System.out.println("Banca:"+c.getNumeBanca());


    }


    public void afisareTranzactii(){

    }


    public void afisareOptiuniNavigare(){
        System.out.println();
        System.out.println("b - inapoi, c - inchide aplicatia ");
    }

    public void adaugaBanca() {
        System.out.println("--------------------------------");
        System.out.println("Adaugare Banca");
        System.out.println();
        System.out.println("Adauga denumire");
    }
}
