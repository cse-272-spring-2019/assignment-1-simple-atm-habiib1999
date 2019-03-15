package guitesting;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Menu {
    Stage stage;
    Scene scene;
    Login login;
    DepositScene depositScene;
    WithdrawalScene withdrawalScene;
    Pre previous;

    public Menu(Stage stage) {
        this.stage = stage;
    }
    
    
    public void preparescene(){
        Label deplabel = new Label("Deposit ");
        Label withlabel = new Label("Withdraw ");
        Label ballabel = new Label("Balance ");
        Button deposit = new Button();
        Button withdrawal = new Button();
        Button balance = new Button();
        Button logout = new Button();
        Button history = new Button();
        //Button next = new Button();
        logout.setText("Logout");
        deposit.setText("DEPOSIT");
        withdrawal.setText("WITHDRAWAL");
        balance.setText("GET BALANCE");
        history.setText("History");
        //next.setText("Next");
        GridPane grid = new GridPane();
        grid.setMinSize(400, 200);
        grid.setVgap(5); 
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER); 
        grid.add(deplabel, 0,0);
        grid.add(withlabel, 0, 3);
        grid.add(ballabel, 0, 5);
        grid.add(deposit, 3,0);
        grid.add(withdrawal, 3, 3);
        grid.add(balance, 3, 5);
        grid.add(logout, 3, 10);
        grid.add(history, 3, 8);
        //grid.add(next, 8, 8);
        scene = new Scene(grid, 400, 300);
        
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(login.getscene());
            }
        });
        
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(depositScene.getscene());
            }
        });
            
        withdrawal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdrawalScene.getscene());
            }
        });
        
        
        balance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               int balance = Account.balance; 
               Alert a = new Alert(AlertType.NONE);
               a.setAlertType(AlertType.INFORMATION);
               a.setContentText("Your Balance is : " + balance); 
               a.show();
            }
        });
        
        
        history.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(previous.getscene());
               /*Alert a = new Alert(AlertType.NONE);
               a.setAlertType(AlertType.INFORMATION);
               a.setContentText("Your Last Action is  " + Account.history[Transactions.indexCounter] + ".                 IF YOU WANT TO GO PREVIUOS MORE CLICK [Previous].");
               a.show();*/
            }
        });
    
    }

    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setDepositScene(DepositScene depositScene) {
        this.depositScene = depositScene;
    }

    public void setWithdrawalScene(WithdrawalScene withdrawalScene) {
        this.withdrawalScene = withdrawalScene;
    }

    public void setPrevious(Pre previous) {
        this.previous = previous;
    }

    
}
    
    

