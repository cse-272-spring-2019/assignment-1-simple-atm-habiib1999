

package guitesting;


public class Account {
    private  int accountId;
    static int balance;
    static String history[] = new String[200];
    static int indexCounter = -1;
    static int endCounter;
    static  int casecounter;
    static int five = 5;
    //static ArrayList<Integer> history = new ArrayList<Integer>();
    
    
    public int checkAccountId(int accId){
        accountId = 60196019;
        if(accId == accountId)
            return 1;
        else
            return 0;
    }
    
}
