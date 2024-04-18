package Auth.Detalii;

import java.sql.*;

public class database_check extends Auth_Method {

    public database_check(){
    }
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/database_shop";
    }

    public Boolean Conexiune_Verificare(String url, String user, String parola){

        try {
            Connection conexiune = DriverManager.getConnection(url, user, parola);

            System.out.println("Conexiune efectuata cu succes!");
            return true;
        }
        catch (SQLException e){
            System.out.println("Nume sau parola incorecta.\n\n");
            System.out.println("Incearca din nou: ");
             return false;
        }
    }

}
