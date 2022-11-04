import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        PreluareDate preluareDate = new PreluareDate();
        Meniu m1 = new Meniu();
//
        preluareDate.citireDate("banci.txt","clienti.txt","tranzactii.txt");
        preluareDate.SincronizareDateInput();


        Scanner consoleIn = new Scanner(System.in);

        int consoleLvl = 0;
        while (consoleIn.hasNext()) {
            if (!consoleIn.next().equals("c")) {

                switch (consoleLvl) {

                    case 0: {
                        m1.afisareListaBanci(preluareDate);
                        System.out.println();
                        System.out.println("Selectati banca dorita");

                        int indexBanca = consoleIn.nextInt();
                        System.out.println("--------------------------------");
                        m1.afisareClienti(preluareDate.
                                listaBanciCitite.get(indexBanca));

                        consoleLvl = 1;
                        m1.afisareOptiuniNavigare();
                        break;
                    }
                    default:
                        System.out.println("A intrat pe default");

                    case 1:

                        System.out.println("Clienti");

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