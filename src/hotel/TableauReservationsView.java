package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableauReservationsView extends TableView<Planning> {

    public TableauReservationsView()

    {

        TableColumn<Planning, String> noChambreCol = new TableColumn<Planning, String>("Numéro de chambre");
        getColumns().add(noChambreCol);
        noChambreCol.setCellValueFactory(new PropertyValueFactory<>("numeroChambre"));

        TableColumn<Planning, String> nomCol = new TableColumn<Planning, String>("Nom");
        getColumns().add(nomCol);
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nomC"));

        TableColumn<Planning, String> prenomCol = new TableColumn<Planning, String>("Prenom");
        getColumns().add(prenomCol);
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenomC"));

        TableColumn<Planning, String> dateCol = new TableColumn<Planning, String>("Date de reservation");
        getColumns().add(dateCol);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("jour"));

        TableColumn<Planning, String> reservationCol = new TableColumn<Planning, String>("Réservé");
        getColumns().add(reservationCol);
        reservationCol.setCellValueFactory(new PropertyValueFactory<>("reservation"));

        TableColumn<Planning, String> payeCol = new TableColumn<Planning, String>("Payé");
        getColumns().add(payeCol);
        payeCol.setCellValueFactory(new PropertyValueFactory<>("paye"));



    }

}
