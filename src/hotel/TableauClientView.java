package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableauClientView extends TableView<Client> {

    public TableauClientView()

    {

        TableColumn<Client, String> civiliteCol = new TableColumn<Client, String>("Civilité");
        getColumns().add(civiliteCol);
        civiliteCol.setCellValueFactory(new PropertyValueFactory<>("civilite"));

        TableColumn<Client, String> nomCol = new TableColumn<Client, String>("Nom");
        getColumns().add(nomCol);
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Client, String> prenomCol = new TableColumn<Client, String>("Prenom");
        getColumns().add(prenomCol);
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Client, String> adresseCol = new TableColumn<Client, String>("Adresse");
        getColumns().add(adresseCol);
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        TableColumn<Client, String> cpCol = new TableColumn<Client, String>("Code postal");
        getColumns().add(cpCol);
        cpCol.setCellValueFactory(new PropertyValueFactory<>("codePostal"));

        // Display row data
        List<Client> clients = ClientDAO.listclients();
        ObservableList<Client> list = FXCollections.observableArrayList(clients);
        setItems(list);

        //Search Client data
        List<Client> clientSearch = ClientDAO.listclients();
        ObservableList<Client> searchList = FXCollections.observableArrayList(clientSearch);
        setItems(searchList);
    }
}
