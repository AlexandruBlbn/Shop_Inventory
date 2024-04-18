package Admin_Stuff;

import java.util.Scanner;

public class Generare_User_Angajat extends User_Props {
    static Scanner scan = new Scanner(System.in);
    public Generare_User_Angajat(){}

    public static void Generare_Angajat(){
        User_Props obiect = new User_Props();
        String nume = "";
        String parola = "";
        String rol = "Angajat";
        obiect.setRol(rol);
        int Nr_Magazin = 0;
                System.out.println("\nGenerare angajat\n ");
        System.out.println("Nume: ");
        obiect.setNume(nume = scan.nextLine());
        System.out.println("Parola ");
        obiect.setParola(parola = scan.nextLine());
        System.out.println("Numarul magazinului:");
        obiect.setNr_Magazin(Nr_Magazin = scan.nextInt());

//***************************
//        necesare pentru generare user + inregistrare in tabela.
        String Query_Generare = "CREATE USER '" + obiect.getNume() +"'@'localhost' IDENTIFIED BY '" +obiect.getParola()+"'; \n grant SELECT ON database_shop.inventar to '" + obiect.getNume() + "'@'localhost'; ";
        String Query_tabela = "INSERT INTO ANGAJATII VALUES(Nume, Rol, Id_Magazin, parola) values('" + obiect.getNume() + "', '" + rol + "', '" + obiect.getNr_Magazin() + "', '" + obiect.getParola() + "');";
//****************************
        System.out.println(Query_Generare);
        System.out.println(Query_tabela);
    }

}

