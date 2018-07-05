package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    Client client = new Client( 161, "Monsieur", "toto", "tata", "1 rue des oisillions", "34000", "Montpellier", 2);
    Client clientU = new Client(163,
                                "madame",
                                "tata",
                                "titine",
                                "2 rue des exemples",
                                "000010", "Salopette", 3);
    Client clientD = new Client(161,"Monsieur","titi","tata","1 rue des oisillions","34000","Montpellier", 2);
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        MySQLDatabaseUtil.dbConnect();
//        List<Client> nbClients = ClientDAO.listclients();
   //     System.out.println(nbClients.size());
        //PlanningDAO.listplanning();
        //List<Chambre> nbChambres= ChambreDAO.listchambres();
        /*for (Client client: ClientDAO.listclients()){
        System.out.println(client);}*/
        for (Planning planning: PlanningDAO.listplanning()){
            System.out.println(planning);}
        //ClientDAO.addClient(client);
        //ClientDAO.removeClient(clientD);
       // ClientDAO.updateClient(clientU);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
