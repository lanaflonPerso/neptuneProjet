package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableauReservationsView extends TableView {

    public TableauReservationsView()

    {

        TableColumn<Client, String> noChambreCol = new TableColumn<Client, String>("Numéro de chambre");
        getColumns().add(noChambreCol);
        noChambreCol.setCellValueFactory(new PropertyValueFactory<>("numeroChambre"));

        TableColumn<Client, String> nomCol = new TableColumn<Client, String>("Nom");
        getColumns().add(nomCol);
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomC"));

        TableColumn<Client, String> prenomCol = new TableColumn<Client, String>("Prenom");
        getColumns().add(prenomCol);
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenomC"));

        TableColumn<Client, String> dateCol = new TableColumn<Client, String>("Date de reservation");
        getColumns().add(dateCol);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("jour"));

        TableColumn<Client, String> reservationCol = new TableColumn<Client, String>("Réservé");
        getColumns().add(reservationCol);
        reservationCol.setCellValueFactory(new PropertyValueFactory<>("reservation"));

        TableColumn<Client, String> payeCol = new TableColumn<Client, String>("Payé");
        getColumns().add(payeCol);
        payeCol.setCellValueFactory(new PropertyValueFactory<>("paye"));





    }
}
