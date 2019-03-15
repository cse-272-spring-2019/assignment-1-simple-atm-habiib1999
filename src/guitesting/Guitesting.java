
package guitesting;

import javafx.application.Application;
import javafx.stage.Stage;

public class Guitesting extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM APP");
        //CREATE OBJ ------------------------------------------------------
        Login login = new Login(primaryStage);
        Menu menu = new Menu(primaryStage);
        DepositScene depositScene = new DepositScene(primaryStage);
        WithdrawalScene withdrawalScene = new WithdrawalScene(primaryStage);
        Pre previous = new Pre(primaryStage);
        //PREAPARE -------------------------------------------------------
        login.preparescene();
        menu.preparescene();
        depositScene.preparescene();
        withdrawalScene.preparescene();
        previous.preparescene();;
        //DEF ------------------------------------------------------------
        login.setMenu(menu);
        menu.setLogin(login);
        depositScene.setMenu(menu);
        menu.setDepositScene(depositScene);
        withdrawalScene.setMenu(menu);
        menu.setWithdrawalScene(withdrawalScene);
        previous.setMenu(menu);
        menu.setPrevious(previous);
        //SHOW -----------------------------------------------------------
        primaryStage.setScene(login.getscene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
