package Queries;

public class Query_Insert_Inv extends Query_Propietati{

    public void Constructor(){

        System.out.println("Numarul magazinului: ");
        int nrMagazin = scan.nextInt();

        while (nrMagazin <= 0) {
            System.out.println("Numarul magazinului nu poate fi zero/negativ. Te rog introdu un numar de magazin valid: ");
            nrMagazin = scan.nextInt();
        }
        scan.nextLine();

        System.out.println("Tip produs: ");
        String tip = scan.nextLine();

        while (tip.isEmpty()) {
            System.out.println("Tipul produsului nu poate fi gol. Te rog introdu un tip de produs valid: ");
            tip = scan.nextLine();
        }

        System.out.println("Felul produsului: ");
        String felArticol = scan.nextLine();

        while (felArticol.isEmpty()) {
            System.out.println("Felul produsului nu poate fi gol. Te rog introdu un fel de produs valid: ");
            felArticol = scan.nextLine();
        }

        System.out.println("Brand: ");
        String brand = scan.nextLine();

        while (brand.isEmpty()) {
            System.out.println("Brandul nu poate fi gol. Te rog introdu un brand valid: ");
            brand = scan.nextLine();
        }

        System.out.println("Propietate produs: ");
        String proprietate = scan.nextLine();

        while (proprietate.isEmpty()) {
            System.out.println("Proprietatea produsului nu poate fi goală. Te rog introdu o proprietate validă: ");
            proprietate = scan.nextLine();
        }

        System.out.println("Cantitate: ");
        int cantitate = scan.nextInt();
        scan.nextLine();
        System.out.println("Oras: ");
        String oras = scan.nextLine();


        String Query_Insert = "INSERT INTO INVENTAR (Nr_Magazin, Tip, Fel_Articol, Brand, Propietate, Cantitate, Oras)" +
                " VALUES(" + nrMagazin + ", '" + tip + "', '" + felArticol + "', '" + brand +
                "', '" + proprietate + "', '" + cantitate + "', '" + oras + "');";
        System.out.println(Query_Insert);
    }

//    public static void main(String[] args) {
//        Query_Insert_Inv ob = new Query_Insert_Inv();
//        ob.Constructor();
//
//    }
}
