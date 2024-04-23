package Auth.Detalii;

import java.sql.*;

public class database_check extends Auth_Method {

    public database_check(){
    }
    public static String getUrl() {
        return "jdbc:mysql://127.0.0.1:3306/database_shop";
    }

    public static Boolean Conexiune_Verificare(String url, String user, String parola){
            Auth_Method obiect = new Auth_Method();
        try {
            Connection conexiune = DriverManager.getConnection(url, user, parola);
            System.out.println("Conexiune efectuata cu succes!");
            conexiune.close();
            return true;
        }
        catch (SQLException e){
            System.out.println("Nume sau parola incorecta.\n\n");
            System.out.println(e);
            return false;
        }

    }

}
