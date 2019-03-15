
package guitesting;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WithdrawalScene {
    Stage stage;
    Scene scene;
    Menu menu;
    
    public WithdrawalScene(Stage stage) {
        this.stage = stage;
    }



    public void preparescene() {
        Transactions with = new Transactions();
        Label amountLabel = new Label("Amount ");
        TextField amountField = new TextField();
        Button submit = new Button();
        Button back = new Button();
        back.setText("Back to Menu");
        submit.setText("Submit");
        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setVgap(5); 
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER); 
        grid.add(amountLabel, 4,4);
        grid.add(amountField, 6, 4);
        grid.add(submit, 6, 8);
        grid.add(back, 6, 10);
        scene = new Scene(grid, 400, 300);
     
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(menu.getScene());
                
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int x;
                x = with.setwithdrawal(Integer.parseInt(amountField.getText()));
                if (x==0){
                Alert a = new Alert(Alert.AlertType.NONE);         
                a.setAlertType(Alert.AlertType.ERROR); 
                a.setContentText("YOU CAN'T MAKE THIS ACTION");
                a.show();
                } 
                else{
                Alert a = new Alert(Alert.AlertType.NONE);         
                a.setAlertType(Alert.AlertType.INFORMATION); 
                a.setContentText("SUCCESSFULLY DONE .. IF YOU WANT TO WITHDRAW ANOTHER AMOUNT YOU HAVE TO GO TO MENU FIRST ");
                a.show();
                }
                amountField.clear();
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