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

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FenetreAddReservation extends Stage {

    public FenetreAddReservation(){

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
        ChoiceBox<Client> champClient = new ChoiceBox<Client>(list);

        Label dateLabel = new Label("Date: ");
        DatePicker dateReserv = new DatePicker();

        Label numeroChambre = new Label("Chambre: ");
        List<Chambre> listeDeroulanteChambre = ChambreDAO.listchambres();
        ObservableList<Chambre> listChambre = FXCollections.observableArrayList(listeDeroulanteChambre);
        ChoiceBox<Chambre> champChambre = new ChoiceBox<Chambre>(listChambre);

        Label reserveLabel = new Label("Réservé: ");
        List<String> reserve = Arrays.asList("Oui","Non");
        ObservableList<String> reserveOuiNon = FXCollections.observableArrayList(reserve);
        ChoiceBox<String> reserveChoice = new ChoiceBox(reserveOuiNon);

        Label payeLabel = new Label("Payé: ");
        List<String> paye = Arrays.asList("Oui","Non");
        ObservableList<String> payeOuiNon = FXCollections.observableArrayList(paye);
        ChoiceBox<String> payeChoice = new ChoiceBox(payeOuiNon);


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
        btnValider.setOnAction(event -> {
            Client c = champClient.getValue();
            Chambre ch =champChambre.getValue();
            Planning planningAdd = new Planning(ch.getId(),dateReserv.getValue(),payeChoice.getValue(),reserveChoice.getValue(),c.getNom(),c.getPrenom());
//            dateReserv.getValue();
//            payeChoice.getValue();
//            reserveChoice.getValue();
            try {
                PlanningDAO.addReservation(planningAdd,c,ch);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
    }
}
