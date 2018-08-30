package hotel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class FenetreAddClient extends Stage {

//    public FenetreAddClient(){
//
//        GridPane contenuAjoutClient = new GridPane();
//        contenuAjoutClient.setPadding(new Insets(20));
//        contenuAjoutClient.setVgap(15);
//        contenuAjoutClient.setHgap(10);
//
//        //Bouton Valider
//        Button btnValider = new Button("Valider");
//
//        //Champs de saisie
//        Label nomClient = new Label("Nom: ");
//        TextField nomClientField = new TextField();
//
//        Label prenomClient = new Label("Prenom: ");
//        TextField prenomClientField = new TextField();
//
//        Label adresseClient = new Label("Adresse: ");
//        TextField adresseClientField = new TextField();
//
//        Label cpClient = new Label("Code Postal: ");
//        TextField cpClientField = new TextField();
//
//        Label villeClient = new Label("Ville: ");
//        TextField villeClientField = new TextField();
//
//        Label pays = new Label("Pays: ");
//        TextField paysClientField = new TextField();
//
//        Client clientNew = new Client(
//                nomClientField.getText(), prenomClientField.getText(), adresseClientField.getText(),cpClientField.getText(),villeClientField.getText(),paysClientField.getText()
//        );
//        contenuAjoutClient.add(nomClient,0,0);
//        contenuAjoutClient.add(nomClientField,1,0);
//        contenuAjoutClient.add(prenomClient,0,1);
//        contenuAjoutClient.add(prenomClientField,1,1);
//        contenuAjoutClient.add(adresseClient,0,2);
//        contenuAjoutClient.add(adresseClientField,1,2);
//        contenuAjoutClient.add(cpClient,0,3);
//        contenuAjoutClient.add(cpClientField,1,3);
//        contenuAjoutClient.add(villeClient,0,4);
//        contenuAjoutClient.add(villeClientField,1,4);
//        contenuAjoutClient.add(pays,0,5);
//        contenuAjoutClient.add(paysClientField,1,5);
//        contenuAjoutClient.add(btnValider,1,6);
//
//        //Scene
//        Scene sceneClientAjout = new Scene(contenuAjoutClient,640,480);
//        this.setTitle("Ajout de client");
//        this.setScene(sceneClientAjout);
//
//       //Comportement bouton valider
//        Pays paysAdd = new Pays(paysClientField.getText());
//        btnValider.setOnAction(event -> {
//            try {
//                ClientDAO.addClient(clientNew);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }

}
