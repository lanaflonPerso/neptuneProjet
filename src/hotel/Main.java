package hotel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class Main extends Application {
   // Chambre chambre = new Chambre(1,2,"port",0,1,2);
    Client client = new Client("Monsieur", "toto", "tata", "1 rue des oisillions", "34000", "Montpellier");
    /*Client clientU = new Client(163,
                                "madame",
                                "tata",
                                "titine",
                                "2 rue des exemples",
                                "000010", "Salopette", 3);
    Client clientD = new Client(161,"Monsieur","titi","tata","1 rue des oisillions","34000","Montpellier", 2);*/
    //LocalDate datetest= LocalDate.parse("2016-12-31");
   // Planning planning = new Planning(9, LocalDate.parse("2016-12-31"),-1,-1,161);


    @Override
    public void start(Stage primaryStage) throws Exception{

        //Fenêtre principale

        BorderPane contenuFenetre = new BorderPane();

        HBox footerLstClients = new HBox();

        primaryStage.setTitle("Hôtel Neptune");

        //Vue top window ( accueil+ menu)

        VBox topWindow = new VBox();
        HBox boutonsMenu = new HBox();
        HBox msgAccueil = new HBox();
        Label msg = new Label("Bienvenue sur cette interface de gestion de l'hôtel Netpune");


        //Menu
        Button btnListeClients = new Button("Liste des clients");
        Button  btnListeChambres = new Button("Liste des Chambres");
        Button btnAddReservation = new Button("Ajouter une réservation");
        TextField champTexte = new TextField();
        champTexte.setPromptText("Rechercher un client par nom");
        Button btnsearch = new Button("Rechercher");
        Button btnreservation = new Button("Reservations");
        msgAccueil.getChildren().add(msg);
        boutonsMenu.getChildren().add(btnListeClients);
        boutonsMenu.getChildren().add(btnListeChambres);
        boutonsMenu.getChildren().add(champTexte);
        boutonsMenu.getChildren().add(btnsearch);
        boutonsMenu.getChildren().add(btnreservation);
        boutonsMenu.getChildren().add(btnAddReservation);
        boutonsMenu.setSpacing(10);
        boutonsMenu.setPadding(new Insets(15,20, 10,10));
        topWindow.getChildren().add(msgAccueil);
        topWindow.getChildren().add(boutonsMenu);

        //Footer Reservations
        HBox footerReservation = new HBox();
        footerReservation.setPadding(new Insets(15,20,20,20));
        Button btnPlanningSemaine = new Button("Réservation de la semaine");
        Button btnSupprReserv = new Button("Supprimer la réservation");
        Button btnmajReserv = new Button("Modifier la réservation");
        btnPlanningSemaine.setPadding(new Insets(5, 5, 5, 5));
        footerReservation.getChildren().add(btnPlanningSemaine);
        footerReservation.getChildren().add(btnSupprReserv);
        footerReservation.getChildren().add(btnmajReserv);

        //Footer Liste Clients
        footerLstClients.setPadding(new Insets(15,20,20,20));
        footerLstClients.setPadding(new Insets(15,20,20,20));
        Button btnAjoutClient = new Button("Ajouter un client");
        Button btnSupprClient = new Button("Supprimer client");
        footerLstClients.getChildren().add(btnAjoutClient);
        footerLstClients.getChildren().add(btnSupprClient);

        //TableView Table liste clients

        TableauClientView tableClient = new TableauClientView();

        //TableView Liste des chambres

        TableauChambresView tableChambres= new TableauChambresView();

        //TableView Liste Reservation

        TableauReservationsView tableReservation= new TableauReservationsView();

        //Fenêtre d'ajout de réservation

        FenetreAddReservation fenetreAjoutReserv = new FenetreAddReservation();

        //Fenêtre d'ajout de client
        FenetreAddClient fenetreAjoutClient = new FenetreAddClient();

        //Hbox Clients
        HBox tableauClients = new HBox();
        Scene sceneClient= new Scene(tableauClients,800,600);
        primaryStage.setScene(sceneClient);
        tableauClients.getChildren().add(tableClient);

        //Hbox Chambres
        HBox tableauChambres = new HBox();
        Scene sceneChambre = new Scene(tableauChambres,800,600);
        primaryStage.setScene(sceneChambre);
        tableauChambres.getChildren().add(tableChambres);
        System.out.println(tableauChambres);

        //Contenu fenêtre
        contenuFenetre.setTop(topWindow);
        contenuFenetre.setCenter(tableClient);
        contenuFenetre.setBottom(footerLstClients);
        footerLstClients.setAlignment(Pos.BOTTOM_CENTER);
        primaryStage.setScene(new Scene(contenuFenetre, 800, 600));
        primaryStage.show();

        //Click Buttons
        btnListeClients.setOnAction(event -> {
            List<Client> clients = ClientDAO.listclients();
            ObservableList<Client> list = FXCollections.observableArrayList(clients);
            tableClient.setItems(list);
            contenuFenetre.setCenter(tableClient);
            contenuFenetre.setBottom(footerLstClients);
            footerLstClients.setAlignment(Pos.BOTTOM_CENTER);
                });
        btnListeChambres.setOnAction(event -> {
            contenuFenetre.setCenter(tableChambres);
            contenuFenetre.setBottom(null);
                });
        btnsearch.setOnAction(event -> {
            try {
                List<Client> searchResult = ClientDAO.searchClient( champTexte.getText());
                ObservableList<Client> searchList = FXCollections.observableArrayList(searchResult);
                tableClient.setItems(searchList);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        btnreservation.setOnAction(event -> {
            List<Planning> plannings = PlanningDAO.listplanning();
            ObservableList<Planning> planning = FXCollections.observableArrayList(plannings);
            tableReservation.setItems(planning);
            contenuFenetre.setCenter(tableReservation);
            contenuFenetre.setBottom(footerReservation);
            footerReservation.setAlignment(Pos.BOTTOM_CENTER);

        });

        btnSupprReserv.setOnAction(event -> {
            Planning planningSelect = tableReservation.getSelectionModel().getSelectedItem();
            if( planningSelect != null){
                try {
                    PlanningDAO.removeReservation(planningSelect);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                List<Planning> plannings = PlanningDAO.listplanning();
                ObservableList<Planning> planning = FXCollections.observableArrayList(plannings);
                tableReservation.setItems(planning);
            }

        });
        btnPlanningSemaine.setOnAction(event -> {
            List<Planning>planningsS =PlanningDAO.planningDeLaSemaine();
            ObservableList<Planning> planning = FXCollections.observableArrayList(planningsS);
            tableReservation.setItems(planning);
        });
        btnAddReservation.setOnAction(event -> {
            fenetreAjoutReserv.show();
        });
        btnmajReserv.setOnAction(event -> {
            //Fenêtre màj réservation

            FenetreUpdateReservation fenatreMajReserv = new FenetreUpdateReservation(tableReservation, tableClient, tableChambres);

            fenatreMajReserv.show();
        });
        btnAjoutClient.setOnAction(event -> {
            fenetreAjoutClient.show();
        });
        btnSupprClient.setOnAction(event -> {
            Client clientSuppr = tableClient.getSelectionModel().getSelectedItem();
            if (clientSuppr != null){
                try {
                    ClientDAO.removeClient(clientSuppr);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            List<Client> clients = ClientDAO.listclients();
            ObservableList<Client> client = FXCollections.observableArrayList(clients);
            tableClient.setItems(client);
        });













        MySQLDatabaseUtil.dbConnect();



        //Affichage liste planning
        for (Planning plannings: PlanningDAO.planningDeLaSemaine()){
            System.out.println(plannings);}

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
