import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        PreluareDate preluareDate = new PreluareDate();
        Meniu m1 = new Meniu();
//
        preluareDate.citireDate("banci.txt", "clienti.txt", "tranzactii.txt");
        preluareDate.SincronizareDate();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner consoleIn = new Scanner(System.in);

        System.out.println("x - Intrati in aplicatie, c - Parasiti aplicatia");

        //int consoleLvl = 0;

//        while (1 == 1) {
//
//            switch (consoleIn.next()) {
//                case "c": {
//                    return;
//                }
//                case "b": {
//                    consoleLvl--;
//                }
//
//                default: {
//                    switch (consoleLvl) {
//                        case 0: {
//                            m1.afisareListaBanci(preluareDate);
//                            System.out.println();
//                            System.out.println("Selectati banca dorita");
//
//                            try {
////                            if(consoleIn.next().equals("+")){
////                                m1.adaugaBanca();
////                            }else {
//                                int indexBanca = consoleIn.nextInt();
//                                System.out.println("--------------------------------");
//                                m1.afisareClienti(preluareDate.listaBanciCitite.get(indexBanca));
//
//                                consoleLvl = 1;
//                                m1.afisareOptiuniNavigare();
//
//                            }
////  }
//                            catch (Exception e) {
//
//                                System.out.println("Ati introdus o optiune invalida");
//                                System.out.println("Introduceti orice tasta pentru a va intoarce");
//                            }
//
//                            break;
//                        }
//                        default:
//                            System.out.println("Entered default");
//                            break;
//
//                        case 1:
//                            int indexClient = consoleIn.nextInt();
//                            m1.afisareDateClient(preluareDate.listaClientiCititi.get(indexClient));
//                            consoleLvl = 2;
//                            break;
//
//                    }
//
//                }
//
//            }
//        }

        m1.afisareMeniuBanci(preluareDate);

            }
//afara main





}


//dobanda banca
//comision
//tranzactii
//clienti