package Queries;

public class Query_Insert_Inv extends Query_Propietati{

    public void Constructor(StringBuilder queryBuilder, String nr_magazin, String tip, String fel, String brand, String propietate, String cantitate, String oras) {
        queryBuilder.append("INSERT INTO INVENTAR (Nr_Magazin, Tip, Fel_Articol, Brand, Propietate, Cantitate, Oras) VALUES (")
                .append(nr_magazin).append(", '")
                .append(tip).append("', '")
                .append(fel).append("', '")
                .append(brand).append("', '")
                .append(propietate).append("', '")
                .append(cantitate).append("', '")
                .append(oras).append("');");
    }

//    public static void main(String[] args) {
//        Query_Insert_Inv ob = new Query_Insert_Inv();
//        ob.Constructor();
//
//    }
}
