package hotel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.time.LocalDate;
import java.util.List;

public class Main extends Application {
   // Chambre chambre = new Chambre(1,2,"port",0,1,2);
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
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane contenuFenetre = new BorderPane();
        primaryStage.setTitle("Hôtel Neptune");

        //Vue menu
        HBox boutonsMenu = new HBox();
        Button btnListeClients = new Button("Liste des clients");
        Button  btnListeChambres = new Button("Chambres Libres");
        TextField champTexte = new TextField("Entrez le nom du client");
        Button search = new Button("Rechercher");
        boutonsMenu.getChildren().add(btnListeClients);
        boutonsMenu.getChildren().add(btnListeChambres);
        boutonsMenu.getChildren().add(champTexte);
        boutonsMenu.getChildren().add(search);
        boutonsMenu.setSpacing(10);
        boutonsMenu.setPadding(new Insets(15,20, 10,10));

        //Pane central Accueil
        HBox accueil= new HBox();
        Label msg = new Label("Bienvenue sur cette interface de gestion de l'hôtel Netpune");
        accueil.getChildren().add(msg);

        //Table liste clients
        TableView<Client> table = new TableView<Client>();

        TableColumn<Client, String> civiliteCol = new TableColumn<Client, String>("Civilité");
        table.getColumns().add(civiliteCol);
        civiliteCol.setCellValueFactory(new PropertyValueFactory<>("civilite"));

        TableColumn<Client, String> nomCol = new TableColumn<Client, String>("Nom");
        table.getColumns().add(nomCol);
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Client, String> prenomCol = new TableColumn<Client, String>("Prenom");
        table.getColumns().add(prenomCol);
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Client, String> adresseCol = new TableColumn<Client, String>("Adresse");
        table.getColumns().add(adresseCol);
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        TableColumn<Client, String> cpCol = new TableColumn<Client, String>("Code postal");
        table.getColumns().add(cpCol);
        cpCol.setCellValueFactory(new PropertyValueFactory<>("codePostal"));

        // Display row data
        List<Client> clients = ClientDAO.listclients();
        ObservableList<Client> list = FXCollections.observableArrayList(clients);
        table.setItems(list);



        //Vue Liste des chambres

//        TableView<Chambre> tableChambres = new TableView<>();
//
//        TableColumn<Chambre, String> numeroCol = new TableColumn<Chambre, String>("Numéro");
//        tableChambres.getColumns().add(numeroCol);
//        numeroCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<Chambre, String> capaciteCol = new TableColumn<Chambre, String>("Capacité (nb personnes)");
//        tableChambres.getColumns().add(capaciteCol);
//        capaciteCol.setCellValueFactory(new PropertyValueFactory<>("capacite"));
//
//        TableColumn<Chambre, String> expositionCol = new TableColumn<Chambre, String>("Exposition");
//        tableChambres.getColumns().add(expositionCol);
//        expositionCol.setCellValueFactory(new PropertyValueFactory<>("exposition"));
//
//        TableColumn<Chambre, String> doucheCol = new TableColumn<Chambre, String>("Douche");
//        tableChambres.getColumns().add(doucheCol);
//        doucheCol.setCellValueFactory(new PropertyValueFactory<>("douche"));
//
//        TableColumn<Chambre, String> etageCol = new TableColumn<Chambre, String>("Etage");
//        tableChambres.getColumns().add(etageCol);
//        etageCol.setCellValueFactory(new PropertyValueFactory<>("etage"));
//
//        TableColumn<Chambre, String> prixCol = new TableColumn<Chambre, String>("Prix");
//        tableChambres.getColumns().add(prixCol);
//        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
       TableauChambres tableChambres= new TableauChambres();
        // Display row data
//        List<Chambre> chambres = ChambreDAO.listchambres();
//        ObservableList<Chambre> listChambre  = FXCollections.observableArrayList(chambres);
//        tableChambres.setItems(listChambre);


        //Hbox Clients
        HBox tableauClients = new HBox();
        Scene sceneClient= new Scene(tableauClients,500,600);
        primaryStage.setScene(sceneClient);
        tableauClients.getChildren().add(table);

        //Hbox Chambres
        HBox tableauChambres = new HBox();
        Scene sceneChambre = new Scene(tableauChambres,500,600);
        primaryStage.setScene(sceneChambre);
        tableauChambres.getChildren().add(tableChambres);
        System.out.println(tableauChambres);

        //Contenu fenêtre
        contenuFenetre.setTop(boutonsMenu);
        contenuFenetre.setCenter(accueil);
        primaryStage.setScene(new Scene(contenuFenetre, 640, 480));
        primaryStage.show();
        btnListeClients.setOnAction(event -> {
           contenuFenetre.setCenter(tableauClients);
                });
        btnListeChambres.setOnAction(event -> {
           contenuFenetre.setCenter(tableauChambres);
                });
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

       //Vue liste clients
//        Stage secondaryStage = new Stage();
//        TableView<Client> table = new TableView<Client>();
//
//        TableColumn<Client, String> civiliteCol = new TableColumn<Client, String>("Civilité");
//        table.getColumns().add(civiliteCol);
//        civiliteCol.setCellValueFactory(new PropertyValueFactory<>("civilite"));
//
//        TableColumn<Client, String> nomCol = new TableColumn<Client, String>("Nom");
//        table.getColumns().add(nomCol);
//        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
//
//        TableColumn<Client, String> prenomCol = new TableColumn<Client, String>("Prenom");
//        table.getColumns().add(prenomCol);
//        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//
//        TableColumn<Client, String> adresseCol = new TableColumn<Client, String>("Adresse");
//        table.getColumns().add(adresseCol);
//        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//
//        TableColumn<Client, String> cpCol = new TableColumn<Client, String>("Code postal");
//        table.getColumns().add(cpCol);
//        cpCol.setCellValueFactory(new PropertyValueFactory<>("codePostal"));
//
//    // Display row data
//        List<Client> clients = ClientDAO.listclients();
//        ObservableList<Client> list = FXCollections.observableArrayList(clients);
//        table.setItems(list);
//
//        BorderPane tableauClients = new BorderPane();
//        //hBox.setPadding(new Insets(1,2));
//        secondaryStage.setScene(new Scene(tableauClients, 500,600));
//        tableauClients.setCenter(table);
//        secondaryStage.show();



        //Affichage liste planning
        for (Planning planning: PlanningDAO.planningDeLaSemaine()){
            System.out.println(planning);}

         //Affichage liste chambres
        for (Chambre chambre: ChambreDAO.listchambres()){
            System.out.println(chambre);}

         ClientDAO.searchClient("coussot");


         //ClientDAO.addClient(client);
        //ClientDAO.removeClient(clientD);
       // ClientDAO.updateClient(clientU);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
