
package guitesting;

import java.awt.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pre {
    Stage stage;
    Scene scene;
    Menu menu;

    public Pre(Stage stage) {
        this.stage = stage;
    }



    public void preparescene() {
        Transactions t = new Transactions();
        Button previous = new Button();
        previous.setText("Previous");
        Button next = new Button();
        next.setText("Next");
        Label result = new Label();
        Button back = new Button();
        back.setText("Back to Menu");
        //result.setText(value);
        GridPane grid = new GridPane();
        grid.setMinSize(400, 300);
        grid.setVgap(3); 
        grid.setHgap(3);
        grid.setAlignment(Pos.CENTER); 
        grid.add(previous, 1, 6);
        grid.add(next, 3, 6);
        grid.add(result, 1, 0);
        grid.add(back, 1, 8);
        scene = new Scene(grid, 400, 300);
        
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(menu.getScene());
                
            }
        });
        
     
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int x;
                x = t.next();
                if(x == 0){
                        stage.setScene(menu.getScene());
                }
                else{
                        result.setText(Account.history[Account.indexCounter]);

                    } 
            }
        });
        
        
        
        
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int x;
                x = t.previuos();
                if(x==0){
                    Alert a = new Alert(Alert.AlertType.NONE);         
                    a.setAlertType(Alert.AlertType.ERROR); 
                    a.setContentText("THERE IS NO PREVIOUS");
                    a.show();
                }
                else{
                        if(Account.indexCounter < 0){
                            Alert a1 = new Alert(Alert.AlertType.NONE);
                            a1.setAlertType(Alert.AlertType.ERROR); 
                            a1.setContentText("THERE IS NO PREVIOUS");
                            a1.show();
                            //Account.indexCounter++;
                        }
                        else{
                            result.setText(Account.history[Account.indexCounter]);
                                Account.indexCounter--;
                                Account.casecounter = Account.indexCounter;
                                
                        }
                    
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

