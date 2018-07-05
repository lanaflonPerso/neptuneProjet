package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanningDAO {

    public static List<Planning> listplanning (){
        List<Planning> plannings= new ArrayList<Planning>();
        try {
            ResultSet resultset=MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM planning;");
            while(resultset.next()){
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

}
