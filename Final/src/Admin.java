import java.util.ArrayList;

public class Admin extends User{
   ArrayList<Buylogs> UsersBuyLogs;

    public Admin(String name, String lastName, String userName, String password, ArrayList<App> apps, Region region, YourApplanguage applanguge, Sex sex, String email, ArrayList<Buylogs> myBuyLogs,ArrayList<Buylogs> usersBuyLogs) {
        super(name, lastName, userName, password, apps, region, applanguge, sex, email, myBuyLogs);
        this.UsersBuyLogs = usersBuyLogs;
        this.role = "Admin";
    }
    public static void showUsersBuyLogs() {
        for (Buylogs buylogs: DataBase.adminsDb.get(0).UsersBuyLogs){
            System.out.println("User "+buylogs.customer.name + " buy " + buylogs.app.name + " and this app price is " +
                    buylogs.price);
        }
    }
}
