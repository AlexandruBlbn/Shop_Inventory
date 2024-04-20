package Auth.Detalii;

import java.util.Scanner;

public class Auth_Method {
    static Scanner scan = new Scanner(System.in);
    protected String nume;
    protected String parola;

    public String getNume() {
        return nume;
    }

    public void setNume() {
        System.out.println("Nume: ");
        this.nume = scan.nextLine();
    }

    public String getParola() {
        return parola;
    }

    public void setParola() {
        System.out.println("Parola: ");
        this.parola = scan.nextLine();
    }

    public Auth_Method(){
    }

}
