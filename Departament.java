/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinjava;

/**
 *
 * @author Henri
 */
public class Departament {

    private int idDepartamentit;
    private String llojiDepartamentit;
    private String administratori;
    private int nrPunonjesve;

    public Departament(int idDepartamentit, String llojiDepartamentit, String administratori, int nrPunonjesve) {
        this.idDepartamentit = idDepartamentit;
        this.llojiDepartamentit = llojiDepartamentit;
        this.administratori = administratori;
        this.nrPunonjesve = nrPunonjesve;
    }

    public int getIdDepartamentit() {
        return idDepartamentit;
    }

    public void setIdDepartamentit(int idDepartamentit) {
        this.idDepartamentit = idDepartamentit;
    }

    public String getLlojiDepartamentit() {
        return llojiDepartamentit;
    }

    public void setLlojiDepartamentit(String llojiDepartamentit) {
        this.llojiDepartamentit = llojiDepartamentit;
    }

    public String getAdministratori() {
        return administratori;
    }

    public void setAdministratori(String administratori) {
        this.administratori = administratori;
    }

    public int getNrPunonjesve() {
        return nrPunonjesve;
    }

    public void setNrPunetorve(int nrPunonjesve) {
        this.nrPunonjesve = nrPunonjesve;
    }

    @Override
    public String toString() {
        return "\nID e departamentit: " + getIdDepartamentit()
                + "\nLloji i departamentit: " + getLlojiDepartamentit()
                + "\nAdministratori i departamentit: " + getAdministratori()
                + "\nNumri i punonjesve: " + getNrPunonjesve() + "\n";
    }

}
