package chessknights.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.io.IOException;

@Slf4j
public class LaunchController {

    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    private TextField firstPlayerNameTextField;

    @FXML
    private TextField secondPlayerNameTextField;

    @FXML
    private Label errorLabel;

    public void startAction(ActionEvent actionEvent) throws IOException {
        log.info("game started");
        if (firstPlayerNameTextField.getText().isEmpty() || secondPlayerNameTextField.getText().isEmpty()) {
            errorLabel.setText("Enter names for both players!");
        } else {
            fxmlLoader.setLocation(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
//            fxmlLoader.<GameController>getController().setPlayerName(firstPlayerNameTextField.getText());
//            fxmlLoader.<GameController>getController().setPlayerName(secondPlayerNameTextField.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            log.info("The players name is set to {}, loading game scene", firstPlayerNameTextField.getText());
            log.info("The players name is set to {}, loading game scene", secondPlayerNameTextField.getText());
        }
    }

}