package Admin_Stuff;

import java.util.Scanner;

public class Generare_User_Manager extends User_Props {
    static Scanner scan = new Scanner(System.in);
    public Generare_User_Manager(){}

    public static void Generare_Manager(){
        User_Props obiect = new User_Props();
        String nume = "";
        String parola = "";
        String rol = "Manager";
        obiect.setRol(rol);
        int Nr_Magazin = 0;
        System.out.println("\nGenerare manager\n ");
        System.out.println("Nume: ");
        obiect.setNume(nume = scan.nextLine());
        System.out.println("Parola ");
        obiect.setParola(parola = scan.nextLine());
        System.out.println("Numarul magazinului:");
        obiect.setNr_Magazin(Nr_Magazin = scan.nextInt());

//***************************
//        necesare pentru generare user + inregistrare in tabela.
        String Query_Generare = "CREATE USER '" + obiect.getNume() +"'@'localhost' IDENTIFIED BY '" +obiect.getParola()+"'; grant SELECT, UPDATE, DELETE, INSERT ON database_shop.inventar to '" + obiect.getNume() + "'@'localhost';  grant SELECT (ID, Nume, Rol, ID_Magazin) ON database_shop.angajatii to '" + obiect.getNume() + "'@'localhost';  ";
        String Query_tabela = "INSERT INTO ANGAJATII (Nume, Rol, Id_Magazin, parola) values('" + obiect.getNume() + "', '" + rol + "', " + obiect.getNr_Magazin() + ", '" + obiect.getParola() + "');";
//****************************
        System.out.println(Query_Generare);
        System.out.println(Query_tabela);
    }

//    public static void main(String[] args) {
//        Generare_Manager();
//    }
}

