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
            ResultSet resultset = MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM planning;");
            while (resultset.next()) {
                System.out.println(resultset.getDate("jour"));

                Planning planning = new Planning();
                planning.setNumeroChambre(resultset.getInt("chambre_numero"));
                planning.getJour(resultset.getDate("jour").toLocalDate());
                planning.setReservation(resultset.getInt("reservation"));
                planning.setPaye(resultset.getInt("paye"));
                planning.setIdClient(resultset.getInt("client_id"));


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
                ResultSet resultSemaine = MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM planning Where jour BETWEEN '" + dateDebutSemaine+ "' and '"+dateFin+"' ");
                while (resultSemaine.next()) {

                    Planning planningSemaine = new Planning();
                    planningSemaine.setNumeroChambre(resultSemaine.getInt("chambre_numero"));
                    planningSemaine.setJour(resultSemaine.getDate("jour").toLocalDate());
                    planningSemaine.setReservation(resultSemaine.getInt("reservation"));
                    planningSemaine.setPaye(resultSemaine.getInt("paye"));
                    planningSemaine.setIdClient(resultSemaine.getInt("client_id"));

                    planningsS.add(planningSemaine);
                }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return planningsS;

    }
}