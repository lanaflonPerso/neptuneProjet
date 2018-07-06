package hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChambreDAO {


    public static List<Chambre> listchambres (){
        List<Chambre> chambres= new ArrayList<Chambre>();
        try {
            String selectquery = "SELECT numero, etage, exposition, capacite, tarif_id,  douche FROM chambres ;";
            ResultSet resultset=MySQLDatabaseUtil.dbExecuteQuery(selectquery);
            while(resultset.next()){

                Chambre chambre = new Chambre();

                System.out.println("La chambre numero "+resultset.getInt("numero")+ " pour "+resultset.getInt("capacite")+
                        " personnes est exposée côté "+resultset.getString("exposition")+
                        ", possède "+resultset.getInt("douche")+ " douche, est située au "+resultset.getString("etage"));


                chambre.setId (resultset.getInt("numero"));
                chambre.setCapacite(resultset.getInt("capacite"));
                chambre.setExposition(resultset.getString("exposition"));
                chambre.setDouche(resultset.getInt("douche"));
                chambre.setEtage(resultset.getInt("etage"));
                chambre.setIdTarif(resultset.getInt("tarif_id"));


               chambres.add(chambre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return chambres;

    }
    public static void singleChambre (int id ) throws SQLException, ClassNotFoundException {
        String ChambreSingleQuery = "select * from chambres where numero=" + id + ";";
        MySQLDatabaseUtil.dbExecuteQuery(ChambreSingleQuery);


    }

}
