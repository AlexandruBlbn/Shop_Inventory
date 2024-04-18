package Queries;

import java.util.Scanner;

public class Query_Propietati {
    protected static Scanner scan = new Scanner(System.in);
    protected int nrMagazin;
    protected String tip;
    protected String felArticol;
    protected String brand;
    protected String proprietate;
    protected int cantitate;
    protected String oras;

    public Query_Propietati() {}

    public int getNrMagazin() {
        return nrMagazin;
    }

    public void setNrMagazin(int nrMagazin) {
        this.nrMagazin = nrMagazin;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getFelArticol() {
        return felArticol;
    }

    public void setFelArticol(String felArticol) {
        this.felArticol = felArticol;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProprietate() {
        return proprietate;
    }

    public void setProprietate(String proprietate) {
        this.proprietate = proprietate;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }
}
