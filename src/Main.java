import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        PreluareDate preluareDate = new PreluareDate();
        Meniu m1 = new Meniu();
//
        preluareDate.citireDate("banci.txt","clienti.txt","tranzactii.txt");
        preluareDate.SincronizareDateInput();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner consoleIn = new Scanner(System.in);

        System.out.println("x - Intrati in aplicatie, c- Parasiti aplicatia");

        int consoleLvl = 0;
        while (consoleIn.hasNext()) {
            if (!consoleIn.next().equals("c")) {

                switch (consoleLvl) {

                    case 0: {
                        m1.afisareListaBanci(preluareDate);
                        System.out.println();
                        System.out.println("Selectati banca dorita");

                        try {
//                            if(consoleIn.next().equals("+")){
//                                m1.adaugaBanca();
//                            }else {
                                int indexBanca = consoleIn.nextInt();
                                System.out.println("--------------------------------");
                                m1.afisareClienti(preluareDate.listaBanciCitite.get(indexBanca));

                                consoleLvl = 1;
                                m1.afisareOptiuniNavigare();
                            }
//  }

                        catch (Exception e){

                            System.out.println("Ati introdus o optiune invalida");
                            System.out.println("Introduceti orice tasta pentru a va intoarce");
                        }

                        break;
                    }
                    default:
                        System.out.println("Entered default");

                    case 1:
                        int indexClient = consoleIn.nextInt();
                        m1.afisareDateClient(preluareDate.listaClientiCititi.get(indexClient));

                }

                if (consoleIn.next().equals("b")) {
                    consoleLvl--;

                }

            }

            else{
                return;
            }
        }

//                if(consoleIn.next().equals("c")){
//                    System.out.println("Aplicatia a fost inchisa");
//                    return;
//                }
//
//                else
            }


    }


//dobanda banca
//comision
//tranzactii
//clienti