package Admin_Stuff;

import java.util.Scanner;

public class Generare_User_Angajat extends User_Props {
    static Scanner scan = new Scanner(System.in);
    public Generare_User_Angajat(){}

    public static String[] Generare_Angajat(String nume, String parola, String nr_Magazin) {
        String[] queries = new String[3];
        String queryGenerare = "CREATE USER '" + nume + "'@'localhost' IDENTIFIED BY '" + parola + "'; ";
                String grant = "GRANT SELECT ON database_shop.inventar TO '" + nume + "'@'localhost';";
        String queryTabela = "INSERT INTO ANGAJATII (Nume, Rol, Id_Magazin, Parola) VALUES ('" +
                nume + "', 'angajat_', " + nr_Magazin + ", '" + parola + "');";
        queries[0] = queryGenerare;
        queries[1] = queryTabela;
        queries[2] = grant;

        return queries;
    }
}

