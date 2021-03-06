package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public static List<Client> listclients () {
        List<Client> clients = new ArrayList<Client>();
        try {
            //ResultSet resultset = MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM `clients` WHERE 1");
            ResultSet resultset = MySQLDatabaseUtil.dbExecuteQuery("SELECT * FROM clients order by nom;");
            while (resultset.next()) {
                System.out.println(resultset.getString("civilite")+" "+resultset.getString("nom")+" "+
                        resultset.getString("prenom")+" "+ " résidant au "+
                        resultset.getString("adresse")+" "+
                        resultset.getString("codePostal")+" "+resultset.getString("ville"));


                   int idl=resultset.getInt("id");
                   String civilitel= resultset.getString("civilite");
                   String nomL = resultset.getString("nom");
                   String prenomL = resultset.getString("prenom");
                   String adresseL = resultset.getString("adresse");
                   String cpL = resultset.getString("codePostal");
                   String villeL = resultset.getString("ville");
                   int idPaysL = resultset.getInt("pays_id");


                   Client clientL= new Client(idl,civilitel,nomL,prenomL,adresseL,cpL,villeL);

                clients.add(clientL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return clients;
    }
    public static void addClient(Client client) throws SQLException, ClassNotFoundException {
        String AddQueryClient = "insert into clients (civilite, nom, prenom, adresse, codePostal, ville) values ('"+client.getCivilite()+"','"+client.getNom()+"','"+client.getPrenom()+"','"+client.getAdresse()+"','"+client.getCodePostal()+"','"+client.getVille()+"')";
        MySQLDatabaseUtil.dbExecuteUpdate(AddQueryClient);
    }
    public static void removeClient(Client clientD) throws SQLException, ClassNotFoundException {
        MySQLDatabaseUtil.dbExecuteUpdate("delete from clients where (id="+clientD.getId_client()+")");
    }

    public static void updateClient(Client clientU) throws SQLException, ClassNotFoundException {
        String updateQueryClient = "update clients set civilite = '"+clientU.getCivilite()+"', nom= '"+clientU.getNom()+"', prenom = '"+clientU.getPrenom()+"', adresse='"+clientU.getAdresse()+"', codePostal='"+clientU.getCodePostal()+"', ville='"+clientU.getVille()+"', pays_id="+clientU.getId_pays()+" where id="+clientU.getId_client()+";";

        MySQLDatabaseUtil.dbExecuteUpdate(updateQueryClient);
    }
    public  static List<Client> searchClient(String searchNom) throws SQLException {
        ResultSet searchResult= null;
        List<Client> clientsSearch = new ArrayList<Client>();
        try {
           searchResult= MySQLDatabaseUtil.dbExecuteQuery("Select * from clients where nom like '%"+searchNom+"%'");
           while (searchResult.next()) {
               int idl=searchResult.getInt("id");
               String civilitel= searchResult.getString("civilite");
               String nomL = searchResult.getString("nom");
               String prenomL = searchResult.getString("prenom");
               String adresseL = searchResult.getString("adresse");
               String cpL = searchResult.getString("codePostal");
               String villeL = searchResult.getString("ville");
               int idPaysL = searchResult.getInt("pays_id");
               Client clientL= new Client(idl,civilitel,nomL,prenomL,adresseL,cpL,villeL);
              clientsSearch.add(clientL);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       return clientsSearch;
    }



}
