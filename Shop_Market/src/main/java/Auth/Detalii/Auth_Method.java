package Auth.Detalii;

import java.util.Scanner;

public class Auth_Method {
    static Scanner scan = new Scanner(System.in);
    protected String nume = "";
    protected String parola = "";

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        System.out.println("Nume: ");
        nume = scan.nextLine();
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        System.out.println("Parola: ");
        parola = scan.nextLine();
        this.parola = parola;
    }

    public Auth_Method(){
    }

}
