package hotel;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


public class PlanningDAO {

    public static List<Planning> listplanning() {
        List<Planning> plannings = new ArrayList<Planning>();
        try {
            ResultSet resultset = MySQLDatabaseUtil.dbExecuteQuery("SELECT client_id, chambre_numero, reservation ,paye, jour, clients.nom, clients.prenom FROM planning join clients  on clients.id = planning.client_id ORDER BY clients.nom");
            while (resultset.next()) {
                System.out.println(resultset.getDate("jour"));

                Planning planning = new Planning();
                planning.setNumeroChambre(resultset.getInt("chambre_numero"));
                planning.setJour(resultset.getDate("jour").toLocalDate());
                if (resultset.getInt("reservation")== -1){
                    planning.setReservation("Non");
                }
                else if (resultset.getInt("reservation")== 0){
                    planning.setReservation("Oui");
                }
                //planning.setReservation(resultset.getInt("reservation"));
                if (resultset.getInt("paye")==-1){
                    planning.setPaye("Non");
                }
                else if (resultset.getInt("paye")== 0){
                    planning.setPaye("Oui");
                }
                //planning.setPaye(""+resultset.getInt("paye"));
                planning.setNomC(resultset.getString("nom"));
                planning.setPrenomC(resultset.getString("prenom"));


                plannings.add(planning);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return plannings;

    }

    public static List<Planning> planningDeLaSemaine() {

        List<Planning> planningsS = new ArrayList<Planning>();

        try {
            LocalDate dateDebutSemaine = LocalDate.now();
            /*LocalDate semaine = dateDuJour.minusDays(7);*/


            //System.out.println( dateDuJour.getDayOfWeek() != DayOfWeek.FRIDAY);

            while (dateDebutSemaine.getDayOfWeek() != DayOfWeek.MONDAY) {
                dateDebutSemaine = dateDebutSemaine.minusDays(1);


            }
            LocalDate dateFin = dateDebutSemaine.plusDays(6);
                ResultSet resultSemaine = MySQLDatabaseUtil.dbExecuteQuery("SELECT chambre_numero, reservation ,paye, jour, clients.nom, clients.prenom FROM planning join clients \n" +
                        "on clients.id = planning.client_id  Where jour BETWEEN '" + dateDebutSemaine+ "' and '"+dateFin+"' ");
                while (resultSemaine.next()) {

                    Planning planningSemaine = new Planning();
                    planningSemaine.setNumeroChambre(resultSemaine.getInt("chambre_numero"));
                    planningSemaine.setJour(resultSemaine.getDate("jour").toLocalDate());
                    if (resultSemaine.getInt("reservation")==-1){
                        planningSemaine.setReservation("Non");
                    }
                    else if (resultSemaine.getInt("reservation")== 0){
                        planningSemaine.setReservation("Oui");
                    }
                    //planningSemaine.setReservation(resultSemaine.getInt("reservation"));
                    if (resultSemaine.getInt("paye")==-1){
                        planningSemaine.setPaye("Non");
                    }
                    else if (resultSemaine.getInt("paye")== 0){
                        planningSemaine.setPaye("Oui");
                    }
                    //planningSemaine.setPaye(resultSemaine.getInt("paye"));
                    planningSemaine.setNomC(resultSemaine.getString("nom"));
                    planningSemaine.setPrenomC(resultSemaine.getString("prenom"));

                    planningsS.add(planningSemaine);
                }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return planningsS;

    }
    public static void addReservation(Planning reservation, Client client, Chambre chambre) throws SQLException, ClassNotFoundException {
        String AddQueryReservation = "insert into planning (chambre_numero, jour, reservation, paye, client_id) values ('"+chambre.getId()+"','"+reservation.getJour()+"','"+reservation.reserveInt("")+"',  "+reservation.payeInt("")+","+client.getId_client()+");";
        MySQLDatabaseUtil.dbExecuteUpdate(AddQueryReservation);
    }
    public static void removeReservation(Planning reservation) throws SQLException, ClassNotFoundException {
        MySQLDatabaseUtil.dbExecuteUpdate("delete from planning where (jour='"+reservation.getJour()+"')");

    }
    public static void updateReservation(Planning reservation, Planning reservationOld, Client client, Chambre chambre) throws SQLException, ClassNotFoundException {
        String updateQueryReservation = "update planning set chambre_numero = '"+chambre.getId()+"', jour = '"+reservation.getJour()+"', reservation = "+reservation.reserveInt("")+", paye = "+reservation.payeInt("")+", client_id="+client.getId_client()+" where client_id="+client.getId_client()+" and jour='"+reservationOld.getJour()+"';";
        System.out.println(updateQueryReservation);
        MySQLDatabaseUtil.dbExecuteUpdate(updateQueryReservation);
    }



}