package Queries;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Query_Update_Inv extends Query_Propietati {

    protected String Query_Update = "UPDATE INVENTAR SET";
    protected Scanner scan = new Scanner(System.in);

    public void Constructor() {
        boolean valoare = false;

        do {
            System.out.println("Elemente ce se vor actualiza:  \n");
            System.out.println("1. Numar Magazin");
            System.out.println("2. Tip produs");
            System.out.println("3. Felul Articolului");
            System.out.println("4. Brand");
            System.out.println("5. Propietati");
            System.out.println("6. Cantitate");
            System.out.println("7. Oras");
            System.out.println("0. Iesire");
            System.out.println("Optiune selectata: \n");

            try {
                int optiune = scan.nextInt();
                scan.nextLine();
                switch (optiune) {
                    case 1:
                        System.out.println("Introduceti valoarea pentru Numar magazin: ");
                        String nrMagazin = scan.nextLine();
                        Query_Update += " Nr_Magazin = '" + nrMagazin + "',";
                        break;
                    case 2:
                        System.out.println("Introduceti valoarea pentru Tip produs: ");
                        String tip = scan.nextLine();
                        Query_Update += " TIP = '" + tip + "',";
                        break;
                    case 3:
                        System.out.println("Introduceti valoarea pentru Fel articol: ");
                        String felArticol = scan.nextLine();
                        Query_Update += " Fel_Articol = '" + felArticol + "',";
                        break;
                    case 4:
                        System.out.println("Introduceti valoarea pentru Brand: ");
                        String brand = scan.nextLine();
                        Query_Update += " Brand = '" + brand + "',";
                        break;
                    case 5:
                        System.out.println("Introduceti valoarea pentru Propietate produs: ");
                        String proprietate = scan.nextLine();
                        Query_Update += " PROPIETATE = '" + proprietate + "',";
                        break;
                    case 6:
                        System.out.println("Introduceti valoarea pentru Cantitate: ");
                        String cantitate = scan.nextLine();
                        Query_Update += " Cantitate = '" + cantitate + "',";
                        break;
                    case 7:
                        System.out.println("Introduceti valoarea pentru Oras: ");
                        String oras = scan.nextLine();
                        Query_Update += " Oras = '" + oras + "',";
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Optiune invalida! ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Format incorect!");
                scan.nextLine();
            }

            System.out.println("Adauga alta conditie pentru actualizare? (da/nu): ");
            String continua = scan.nextLine();
            if (continua.equalsIgnoreCase("nu")) {
                valoare = true;
            }
        } while (!valoare);

        if (valoare) {
            Query_Update = Query_Update.substring(0, Query_Update.length() - 1);
            System.out.println("Introduceti conditiile pentru actualizare (ex: Nr_Magazin = 2, TIP = 'ELECTRONIC'): ");
            String conditii = scan.nextLine();
            Query_Update += " WHERE " + conditii + ";";
            System.out.println("Query-ul generat: " + Query_Update);
        }
    }
}
