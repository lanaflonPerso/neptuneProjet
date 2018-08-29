package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FenetreAddReservation extends Stage {
    FenetreAddReservation(){

        //Pane de l'ajout de réservation
        GridPane contenuAjoutReserv = new GridPane();
        contenuAjoutReserv.setPadding(new Insets(20));
        contenuAjoutReserv.setVgap(15);
        contenuAjoutReserv.setHgap(10);

        //Bouton Valider
        Button btnValider = new Button("Valider");

        //Champs de saisie
        Label nomClient = new Label("Nom du client: ");
        List<Client> listeDeroulanteClients = ClientDAO.listclients();
        ObservableList<Client> list = FXCollections.observableArrayList(listeDeroulanteClients);
        ChoiceBox champClient = new ChoiceBox<Client>(list);

        Label dateLabel = new Label("Date: ");
        DatePicker dateReserv = new DatePicker();

        Label numeroChambre = new Label("Chambre: ");
        List<Chambre> listeDeroulanteChambre = ChambreDAO.listchambres();
        ObservableList<Chambre> listChambre = FXCollections.observableArrayList(listeDeroulanteChambre);
        ChoiceBox champChambre = new ChoiceBox<Chambre>(listChambre);

        Label reserveLabel = new Label("Réservé: ");
        List<String> reserve = Arrays.asList("Oui","Non");
        ObservableList<String> reserveOuiNon = FXCollections.observableArrayList(reserve);
        ChoiceBox reserveChoice = new ChoiceBox(reserveOuiNon);

        Label payeLabel = new Label("Payé: ");
        List<String> paye = Arrays.asList("Oui","Non");
        ObservableList<String> payeOuiNon = FXCollections.observableArrayList(paye);
        ChoiceBox payeChoice = new ChoiceBox(payeOuiNon);


        contenuAjoutReserv.add(nomClient,0,0,1,1);
        contenuAjoutReserv.add(champClient,1,0,1,1);
        contenuAjoutReserv.add(numeroChambre,0,1);
        contenuAjoutReserv.add(champChambre,1,1,1,1);
        contenuAjoutReserv.add(dateLabel,0,2,1,1);
        contenuAjoutReserv.add(dateReserv,1,2,1,1);
        contenuAjoutReserv.add(reserveLabel,0,3,1,1);
        contenuAjoutReserv.add(reserveChoice,1,3,1,1);
        contenuAjoutReserv.add(payeLabel,0,4,1,1);
        contenuAjoutReserv.add(payeChoice,1,4,1,1);
        contenuAjoutReserv.add(btnValider,1,5,1,1);



        //Scene
        Scene sceneReservationAjout = new Scene(contenuAjoutReserv,640,480);
        this.setTitle("Ajout de réservation");
        this.setScene(sceneReservationAjout);

        //Comportement boutton
//        btnValider.setOnAction(event -> {
//            Client c = (Client)champClient.getValue();
//            Chambre ch = (Chambre)champChambre.getValue();
//            dateReserv.getValue();
//            payeChoice.getValue();
//            reserveChoice.getValue();
//            PlanningDAO.addReservation(c, ch);
//
//        });
    }
}
