package hotel;

import java.time.LocalDate;

public class Planning {
    private int numeroChambre;
    private LocalDate jour;
    private String paye;
    private String reservation;
    private String nomC;
    private String prenomC;

    public Planning() {

    }



    public Planning(int numeroChambre, LocalDate jour, String reservation, String paye, String nomC, String prenomC) {
        this.numeroChambre = numeroChambre;
        this.jour = jour;
        this.paye = paye;
        this.reservation = reservation;
        this.nomC = nomC;
        this.prenomC = prenomC;
    }

    @Override
    public String toString() {
        return  reservation;
    }

    public LocalDate getJour() {
        return this.jour;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getPrenomC() {
        return prenomC;
    }

    public void setPrenomC(String prenomC) {
        this.prenomC = prenomC;
    }
}
