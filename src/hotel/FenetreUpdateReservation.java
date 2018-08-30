package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FenetreUpdateReservation extends Stage {

    public FenetreUpdateReservation(TableauReservationsView tableReservation, TableauClientView tableClient, TableauChambresView tableChambres){


        //Pane de la modif de réservation
        GridPane contenuUpdateReserv = new GridPane();
        contenuUpdateReserv.setPadding(new Insets(20));
        contenuUpdateReserv.setVgap(15);
        contenuUpdateReserv.setHgap(10);

        //Bouton Valider
        Button btnValider = new Button("Valider");

        //Récupération de l'ancien client/chambre/planning
        Planning planningSelect = tableReservation.getSelectionModel().getSelectedItem();
        Client clientSelect = tableClient.getSelectionModel().getSelectedItem();
        Chambre chambreSelect = tableChambres.getSelectionModel().getSelectedItem();

        //Champs de saisie
        Label nomClient = new Label("Nom du client: ");
        List<Client> listeDeroulanteClients = ClientDAO.listclients();
        ObservableList<Client> list = FXCollections.observableArrayList(listeDeroulanteClients);
        ChoiceBox<Client> champClient = new ChoiceBox<Client>(list);
        champClient.setValue(clientSelect);

        Label dateLabel = new Label("Date: ");
        DatePicker dateReserv = new DatePicker();
        dateReserv.setValue(planningSelect.getJour());

        Label numeroChambre = new Label("Chambre: ");
        List<Chambre> listeDeroulanteChambre = ChambreDAO.listchambres();
        ObservableList<Chambre> listChambre = FXCollections.observableArrayList(listeDeroulanteChambre);
        ChoiceBox<Chambre> champChambre = new ChoiceBox<Chambre>(listChambre);
        champChambre.setValue(chambreSelect);

        Label reserveLabel = new Label("Réservé: ");
        List<String> reserve = Arrays.asList("Oui","Non");
        ObservableList<String> reserveOuiNon = FXCollections.observableArrayList(reserve);
        ChoiceBox<String> reserveChoice = new ChoiceBox(reserveOuiNon);
        reserveChoice.setValue(planningSelect.getReservation());

        Label payeLabel = new Label("Payé: ");
        List<String> paye = Arrays.asList("Oui","Non");
        ObservableList<String> payeOuiNon = FXCollections.observableArrayList(paye);
        ChoiceBox<String> payeChoice = new ChoiceBox(payeOuiNon);
        payeChoice.setValue(planningSelect.getPaye());

        Scene sceneReservationMaj = new Scene(contenuUpdateReserv,640,480);
        this.setTitle("Modification de réservation");
        this.setScene(sceneReservationMaj);

        contenuUpdateReserv.add(nomClient,0,0,1,1);
        contenuUpdateReserv.add(champClient,1,0,1,1);
        contenuUpdateReserv.add(numeroChambre,0,1);
        contenuUpdateReserv.add(champChambre,1,1,1,1);
        contenuUpdateReserv.add(dateLabel,0,2,1,1);
        contenuUpdateReserv.add(dateReserv,1,2,1,1);
        contenuUpdateReserv.add(reserveLabel,0,3,1,1);
        contenuUpdateReserv.add(reserveChoice,1,3,1,1);
        contenuUpdateReserv.add(payeLabel,0,4,1,1);
        contenuUpdateReserv.add(payeChoice,1,4,1,1);
        contenuUpdateReserv.add(btnValider,1,5,1,1);


        //Btn valider
        btnValider.setOnAction(event -> {

            if(planningSelect != null && champClient.getValue() != null && champChambre.getValue() != null && dateReserv.getValue() != null && payeChoice != null && reserveChoice != null) {
                Client c = champClient.getValue();
                Chambre ch = champChambre.getValue();
                Planning planningMaj = new Planning(ch.getId(), dateReserv.getValue(), payeChoice.getValue(), reserveChoice.getValue(), c.getNom(), c.getPrenom());
                System.out.println(dateReserv.getValue());
                    try {
                        PlanningDAO.updateReservation(planningMaj, planningSelect, c, ch);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            }

        });
    }
}
