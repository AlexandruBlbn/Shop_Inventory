package Queries;


import java.util.Scanner;




    public class Query_Delete_Inv extends Query_Propietati {

        protected String Query_Delete = "DELETE FROM INVENTAR";

        public void Constructor() {
            Scanner scan = new Scanner(System.in);

            boolean valoare = false;

            do {
                System.out.println("Introduceti numarul magazinului: ");
                int nrMagazin = scan.nextInt();
                scan.nextLine();
                System.out.println("Introduceti brand-ul: ");
                String brand = scan.nextLine();
                System.out.println("Introduceti proprietatea: ");
                String proprietate = scan.nextLine();
                String conditii = "Nr_Magazin = " + nrMagazin + " AND Brand = '" + brand + "' AND Proprietate = '" + proprietate + "'";
                Query_Delete += " WHERE " + conditii + ";";
                System.out.println("Query-ul generat: " + Query_Delete);
                System.out.println("Doriti sa introduceti alte conditii de stergere? (da/nu): ");
                String continua = scan.nextLine();
                if (continua.equalsIgnoreCase("nu")) {
                    valoare = true;
                }
            } while (!valoare);

        }
    }


