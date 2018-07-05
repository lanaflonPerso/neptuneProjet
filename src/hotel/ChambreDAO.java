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
                System.out.println("La chambre numero "+resultset.getInt("numero")+ " pour "+resultset.getInt("capacite")+
                        " personnes est exposée côté "+resultset.getString("exposition")+
                        ", possède "+resultset.getInt("douche")+ " douche, est située au "+resultset.getString("etage"));
                int numeroL = resultset.getInt("numero");
                int capaciteL= resultset.getInt("capacite");
                String expositionL = resultset.getString("exposition");
                int doucheL =  resultset.getInt("douche");
                int etageL = resultset.getInt("etage");
                int idTarifL = resultset.getInt("tarif_id");
                Chambre chambreL = new Chambre(numeroL,capaciteL,expositionL,doucheL,etageL,idTarifL);

               chambres.add(chambreL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return chambres;



    }
}
