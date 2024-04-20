import Auth.Detalii.Auth_Method;
import Auth.Detalii.database_check;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void Data(Auth_Method data){
        data.setNume();
        data.setParola();
    }

    public static void Verificare(String url, String user, String parola){
        database_check verific = new database_check();
        Auth_Method data = new Auth_Method();
        verific.Conexiune_Verificare(url, user ,parola );
    }


    public static void main(String[] args) {
        Auth_Method data = new Auth_Method();
        database_check verific = new database_check();
        Data(data);
        System.out.println(data.getNume());
        Verificare(database_check.getUrl(), data.getNume(), data.getParola());

    }
}
