package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class Main extends Application {
    Chambre chambre = new Chambre(1,2,"port",0,1,2);
    Client client = new Client( 161, "Monsieur", "toto", "tata", "1 rue des oisillions", "34000", "Montpellier", 2);
    /*Client clientU = new Client(163,
                                "madame",
                                "tata",
                                "titine",
                                "2 rue des exemples",
                                "000010", "Salopette", 3);
    Client clientD = new Client(161,"Monsieur","titi","tata","1 rue des oisillions","34000","Montpellier", 2);*/
    //LocalDate datetest= LocalDate.parse("2016-12-31");
    Planning planning = new Planning(9, LocalDate.parse("2016-12-31"),-1,-1,161);


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        MySQLDatabaseUtil.dbConnect();
        //List<Client> nbClients = ClientDAO.listclients();
         //System.out.println(nbClients.size());
        //ChambreDAO.singleChambre(9);
        //PlanningDAO.removeReservation(planning,client);
        //PlanningDAO.addReservation(planning, client, chambre);
        //lanningDAO.updateReservation(planning, client, chambre);
        //List<Chambre> nbChambres= ChambreDAO.listchambres();
        //ChambreDAO.singleChambre(9);

        //Affichage liste clients
        /*for (Client client: ClientDAO.listclients()){
        System.out.println(client);}*/


        //Affichage liste planning
        for (Planning planning: PlanningDAO.planningDeLaSemaine()){
            System.out.println(planning);}

         //Affichage liste chambres
        /*for (Chambre chambre: ChambreDAO.listchambres()){
            System.out.println(chambre);}*/

         ClientDAO.searchClient("coussot");


         //ClientDAO.addClient(client);
        //ClientDAO.removeClient(clientD);
       // ClientDAO.updateClient(clientU);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
