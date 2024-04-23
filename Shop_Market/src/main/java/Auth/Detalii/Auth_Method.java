package Auth.Detalii;

import java.util.Scanner;

public class Auth_Method {
    static Scanner scan = new Scanner(System.in);
    private String nume;
    private String parola;
    public Auth_Method(){
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }



}
