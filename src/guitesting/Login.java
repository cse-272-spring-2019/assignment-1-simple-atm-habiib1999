
package guitesting;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
    Stage stage;
    Scene scene;
    Menu menu;

    public Login(Stage stage) {
        this.stage = stage;
    }

    public void preparescene() {
        Account check = new Account();
        Label idLabel = new Label("ID ");
        Label welcome = new Label("WELCOME TO ATM APP :) ");
        PasswordField idTextField = new PasswordField();
        Button submit = new Button();
        submit.setText("Submit");
        GridPane grid = new GridPane();
        grid.setMinSize(400, 300);
        grid.setVgap(5); 
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER); 
        grid.add(welcome, 6,0);
        grid.add(idLabel, 4,4);
        grid.add(idTextField, 6, 4);
        grid.add(submit, 6, 8);
        scene = new Scene(grid, 400, 300);
     
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int x;
                x = check.checkAccountId(Integer.parseInt(idTextField.getText()));
                if(x ==0){
                Alert a = new Alert(Alert.AlertType.NONE);         
                a.setAlertType(Alert.AlertType.ERROR); 
                a.setContentText("YOUR ID IS WRONG");
                a.show();
                }
                else{
                stage.setScene(menu.getScene()); 
                }
            }
        });
        
    }
    
    public Scene getscene(){
        return this.scene;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
        
}
