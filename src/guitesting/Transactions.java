
package guitesting;


public class Transactions {
   
    //private String history[] = new String[200];
    //static int indexCounter = -1;
    //static int endCounter;
    //static int five = 5;
   
    
    public int setdeposit(int depositamount){
        int x = 0,i;
        if(depositamount <= 0){
                return 0;
        }
        else{
            for(i=0; i>=0 ; i++){
                if(Account.history[i] == null) {
                    x=i;
                    break;
                } 
            }
            Account.indexCounter = (x - 1);
            Account.balance = Account.balance + depositamount;
            Account.indexCounter++;
            Account.history[Account.indexCounter] = "You deposited : " + depositamount;
            return 1 ;  
            }
    }
    public int setwithdrawal(int withdrawalamount){
          int x = 0,i;
    if(withdrawalamount > Account.balance){
        return 0;
    }
    else{ 
            for(i=0; i>=0 ; i++){
                if(Account.history[i] == null) {
                    x=i;
                    break;
                } 
            }
        Account.indexCounter = x - 1;
        Account.balance = Account.balance - withdrawalamount;
        Account.indexCounter++;
        Account.history[Account.indexCounter]="You withdrew : " + withdrawalamount;
        return 1;
        }
    }

   
    public int getBalance() {
        return Account.balance;
    }
   
    public int previuos(){
        
        Account.endCounter = Account.indexCounter - Account.five; 
        if(Account.indexCounter == Account.endCounter){
            //Account.indexCounter = Account.indexCounter +1;
            return 0;
        }
        else{
        Account.five--;
        return 1;
        }
    }
    
    
    public int next(){ 
        if(Account.casecounter == Account.indexCounter)
            Account.indexCounter = Account.indexCounter + 1;
        if(Account.indexCounter < 0)
            Account.indexCounter = Account.indexCounter + 1;
        if(Account.history[Account.indexCounter] == null){
            //System.out.println("There is no next.");
            // back to menu
            Account.indexCounter--;
            return 0;
        }
        else{
        //System.out.println(Account.history[indexCounter]);
        Account.indexCounter++;
        return 1;
        }
    
    }
}
