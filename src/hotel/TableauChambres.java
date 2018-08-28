package hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableauChambres extends TableView<Chambre> {

    public TableauChambres() {


        TableColumn<Chambre, String> numeroCol = new TableColumn<Chambre, String>("Numéro");
        getColumns().add(numeroCol);
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Chambre, String> capaciteCol = new TableColumn<Chambre, String>("Capacité (nb personnes)");
        getColumns().add(capaciteCol);
        capaciteCol.setCellValueFactory(new PropertyValueFactory<>("capacite"));

        TableColumn<Chambre, String> expositionCol = new TableColumn<Chambre, String>("Exposition");
        getColumns().add(expositionCol);
        expositionCol.setCellValueFactory(new PropertyValueFactory<>("exposition"));

        TableColumn<Chambre, String> doucheCol = new TableColumn<Chambre, String>("Douche");
        getColumns().add(doucheCol);
        doucheCol.setCellValueFactory(new PropertyValueFactory<>("douche"));

        TableColumn<Chambre, String> etageCol = new TableColumn<Chambre, String>("Etage");
        getColumns().add(etageCol);
        etageCol.setCellValueFactory(new PropertyValueFactory<>("etage"));

        TableColumn<Chambre, String> prixCol = new TableColumn<Chambre, String>("Prix");
        getColumns().add(prixCol);
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));

        // Display row data
        List<Chambre> chambres = ChambreDAO.listchambres();
        ObservableList<Chambre> listChambre = FXCollections.observableArrayList(chambres);
        setItems(listChambre);
    }
}
