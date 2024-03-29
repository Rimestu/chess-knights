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
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    private TextField firstPlayerNameTextField;

    @FXML
    private TextField secondPlayerNameTextField;

    @FXML
    private Label errorLabel;

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (firstPlayerNameTextField.getText().isEmpty() || secondPlayerNameTextField.getText().isEmpty()) {
            errorLabel.setText("Enter both names!");
        }else if(firstPlayerNameTextField.getText().equals(secondPlayerNameTextField.getText())){
            errorLabel.setText("Enter different names!");
        }else{
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            fxmlLoader.<GameController>getController().setFirstPlayerName(firstPlayerNameTextField.getText());
            fxmlLoader.<GameController>getController().setSecondPlayerName(secondPlayerNameTextField.getText());
            stage.setScene(new Scene(root));
            stage.show();
            log.info("The players name are set to {} and {}, loading game scene", firstPlayerNameTextField.getText(),secondPlayerNameTextField.getText());
        }
    }

}
