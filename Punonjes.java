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
public class Punonjes {

    private int ID;
    private int idDepartamentit;
    private String emri;
    private String mbiemri;
    private int mosha;
    private double paga;
    private String llojiPunonjesit;

    public Punonjes(int ID, int idDepartamentit, String emri, String mbiemri,
            int mosha, double paga, String llojiPunonjesit) {
        this.ID = ID;
        this.idDepartamentit = idDepartamentit;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.mosha = mosha;
        this.paga = paga;
        this.llojiPunonjesit = llojiPunonjesit;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdDepartamentit() {
        return idDepartamentit;
    }

    public void setIdDepartamentit(int idDepartamentit) {
        this.idDepartamentit = idDepartamentit;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public double getPaga() {
        return paga;
    }

    public void setPaga(double paga) {
        this.paga = paga;
    }

    public String getLloji() {
        return llojiPunonjesit;
    }

    public void setLloji(String llojiPunonjesit) {
        this.llojiPunonjesit = llojiPunonjesit;
    }

    @Override
    public String toString() {
        return "\nID e punonjesit: " + getID() + "\nID e Departamentit: " + getIdDepartamentit()
                + "\nEmri: " + getEmri() + "\nMbiemri: " + getMbiemri() + "\nMosha: " + getMosha()
                + "\nPaga: " + getPaga() + " ALL"
                + "\nLloji( FT -> FULLTIME , PT -> PARTTIME): " + getLloji() + "\n";
    }

}
