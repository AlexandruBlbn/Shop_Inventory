package Queries;

public class Query_Update_Inv_ACT {
    public void Constructor(StringBuilder queryBuilder, String nrMagazin, String tip, String felArticol, String brand, String proprietate, String cantitate, String oras ) {
        String queryComplet = "SET ";
        queryBuilder.append(queryComplet);
        boolean hasConditions = false;

        if (nrMagazin != null && !nrMagazin.isEmpty()){
            queryBuilder.append("Nr_Magazin = ").append(nrMagazin);
            hasConditions = true;
        }
        if (tip != null && !tip.isEmpty()) {
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("Tip = '").append(tip).append("'");
            hasConditions = true;
        }
        if (felArticol != null && !felArticol.isEmpty()) {
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("Fel_Articol = '").append(felArticol).append("'");
            hasConditions = true;
        }
        if (brand != null && !brand.isEmpty()) {
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("Brand = '").append(brand).append("'");
            hasConditions = true;
        }
        if (proprietate != null && !proprietate.isEmpty()){
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("Propietate = '").append(proprietate).append("'");
            hasConditions = true;
        }
        if (cantitate != null && !cantitate.isEmpty()){
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("CANTITATE = ").append(cantitate);
            hasConditions = true;
        }
        if (oras != null && !oras.isEmpty()){
            if (hasConditions) {
                queryBuilder.append(", ");
            }
            queryBuilder.append("Oras = '").append(oras).append("'");
            hasConditions = true;
        }

    }
}
