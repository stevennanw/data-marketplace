package dataMarketplace;

public class Singleton {
    private static Singleton single_instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    public static int customer_login_id = 0;

}
