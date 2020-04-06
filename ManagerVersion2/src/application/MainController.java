package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

/**
 * This class controls the Main FXML File
 * 
 * @author yangliu
 *
 */
public class MainController {
	@FXML
	private Button btnTable, btnTransaction, btnEmployees, btnInventory, btn1;

	// Event Listener on Button[#btnTable].onAction
	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage = (Stage) btn1.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		if (event.getSource() == btn1) {
			stage = (Stage) btn1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		} else if (event.getSource() == btnTable) {
			stage = (Stage) btnTable.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Tables.fxml"));
		} else if (event.getSource() == btnTransaction) {
			stage = (Stage) btnTransaction.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
		} else if (event.getSource() == btnEmployees) {
			stage = (Stage) btnEmployees.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
		} else {
			stage = (Stage) btnInventory.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}