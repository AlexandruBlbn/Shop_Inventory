package Admin_Stuff;

public class User_Props {
    private String nume;
    private String parola;
    private int Nr_Magazin;
    private String Rol;

    public User_Props(){}

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

    public int getNr_Magazin() {
        return Nr_Magazin;
    }

    public void setNr_Magazin(int nr_Magazin) {
        Nr_Magazin = nr_Magazin;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }
}
