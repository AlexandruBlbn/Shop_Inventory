package Queries;


import java.util.Scanner;




    public class Query_Delete_Inv {


        public void Constructor(StringBuilder queryBuilder, String nrMagazin, String tip, String felArticol, String brand, String proprietate, String oras) {
            String queryComplet = "DELETE FROM INVENTAR ";
            queryBuilder.append(queryComplet);
            queryBuilder.append(" WHERE 1=1");
            if (nrMagazin != null && !tip.isEmpty()) {
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
            if (proprietate != null && !proprietate.isEmpty()) {
                queryBuilder.append(" AND Propietate = '").append(proprietate).append("'");
            }
            if (oras != null && !oras.isEmpty()) {
                queryBuilder.append(" AND Oras = '").append(oras).append("'");
            }

        }
    }


