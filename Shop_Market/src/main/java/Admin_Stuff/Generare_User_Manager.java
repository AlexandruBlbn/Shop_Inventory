package Admin_Stuff;

import java.util.Scanner;

public class Generare_User_Manager extends User_Props {
    static Scanner scan = new Scanner(System.in);
    public Generare_User_Manager(){}

    public static String[] Generare_Manager(String nume, String parola, String nr_Magazin) {
        String[] queries = new String[5];
        String queryGenerare = "CREATE USER '" + nume + "'@'localhost' IDENTIFIED BY '" + parola + "'; ";
        String grant = "GRANT SELECT, UPDATE, DELETE, INSERT ON database_shop.inventar TO '" + nume + "'@'localhost';";
        String grant2 = "GRANT SELECT, Insert ON database_shop.angajatii TO '" + nume + "'@'localhost';";
        String queryTabela = "INSERT INTO ANGAJATII (Nume, Rol, Id_Magazin, Parola) VALUES ('" +
                nume + "', 'Manager', " + nr_Magazin + ", '" + parola + "');";
        String permisie = "GRANT CREATE USER ON *.* TO '" + nume + "'@'localhost';";

        queries[0] = queryGenerare;
        queries[1] = queryTabela;
        queries[2] = grant;
        queries[3] = grant2;
        queries[4] = permisie;
        return queries;
    }
}

