package Queries;

import java.util.InputMismatchException;

public class Query_Select_Inv extends Query_Propietati {

    public void Constructor() {
        boolean valoare = false;
        String queryComplet = "SELECT * FROM INVENTAR";

        do {
            System.out.println("Criterii selectie: \n");
            System.out.println("1. Numar Magazin");
            System.out.println("2. Tip produs");
            System.out.println("3. Felul Articolului");
            System.out.println("4. Brand");
            System.out.println("5. Propietati");
            System.out.println("6. Cantitate");
            System.out.println("7. Oras");
            System.out.println("0. Iesire");
            System.out.println("10. Cautare\n");
            System.out.println("Optiune selectata: \n");

            try {
                int optiune = scan.nextInt();
                scan.nextLine();
                switch (optiune) {
                    case 1:
                        System.out.println("Numar magazin: ");
                        nrMagazin = scan.nextInt();
                        scan.nextLine();
                        break;
                    case 2:
                        System.out.println("Tip produs: ");
                        tip = scan.nextLine();
                        break;
                    case 3:
                        System.out.println("Fel articol: ");
                        felArticol = scan.nextLine();
                        break;
                    case 4:
                        System.out.println("Brand: ");
                        brand = scan.nextLine();
                        break;
                    case 5:
                        System.out.println("Propietate produs: ");
                        proprietate = scan.nextLine();
                        break;
                    case 6:
                        System.out.println("Cantitate: ");
                        cantitate = scan.nextInt();
                        scan.nextLine();
                        break;
                    case 7:
                        System.out.println("Oras: ");
                        oras = scan.nextLine();
                        break;
                    case 0:
                        return;
                    case 10:
                        valoare = true;
                        break;
                    default:
                        System.out.println("Optiune invalida! ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Format incorect!");
                scan.nextLine();
            }

        } while (!valoare);


        StringBuilder queryBuilder = new StringBuilder(queryComplet);
        queryBuilder.append(" WHERE 1=1");
        if (nrMagazin != 0){
            queryBuilder.append(" AND Nr_Magazin = ").append(nrMagazin);
        }
        if (tip != null && !tip.isEmpty()) {
            queryBuilder.append(" AND Tip = '").append(tip).append("'");
        }
        if (felArticol != null && !felArticol.isEmpty()) {
            queryBuilder.append(" AND Fel_Articol = '").append(felArticol).append("'");
        }
        if (brand != null && !brand.isEmpty()) {
            queryBuilder.append(" AND Brand = '").append(brand).append("'");
        }
        if (proprietate != null && !proprietate.isEmpty()){
            queryBuilder.append(" AND Propietate = '").append(proprietate).append("'");
        }
        if (cantitate != 0) {
            queryBuilder.append(" AND Cantitate = ").append(cantitate);
        }
        if (oras != null && !oras.isEmpty()){
            queryBuilder.append(" AND Oras = '").append(oras).append("'");
        }

        String queryFinal = queryBuilder.toString();
        System.out.println(queryFinal);
    }
}
