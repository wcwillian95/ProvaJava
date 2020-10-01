package alerts;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ShowAlerts {

	public void validaAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		alert.setContentText("Preencha todos os campos!");
		alert.showAndWait();
	}
}
