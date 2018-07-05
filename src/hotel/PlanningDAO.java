package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanningDAO {

    public static List<Planning> listplanning (){
        List<Planning> planning= new ArrayList<Planning>();
        try {
            ResultSet resultset=MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM planning;");
            while(resultset.next()){
                System.out.println(resultset.getDate("jour"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return planning;

    }
}
