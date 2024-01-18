import java.util.ArrayList;

public class Developer extends User{
    Double Rate;
    ArrayList<App> createdApps;

    public Developer(String name, String lastName, String userName, String password, ArrayList<App> apps, Region region, YourApplanguage applanguge, Sex sex, String email, ArrayList<Buylogs> myBuyLogs, Double rate, ArrayList<App> myapps) {
        super(name, lastName, userName, password, apps, region, applanguge, sex, email, myBuyLogs);
        Rate = rate;
        this.createdApps = myapps;
        this.role = "Developer";
    }

    public static void showADev() {
        System.out.println("enter desired dev's name");
        String desiredDevName = Main.scanner.nextLine();
        for (Developer developer:DataBase.developersDb){
            if (developer.name.equals(desiredDevName)){
                System.out.println("dev name: " + developer.name);
                System.out.println("dev email: " + developer.email);
                System.out.println("dev rate: " + developer.Rate);
                int cnt = 0;
                for (App app: developer.createdApps){
                    System.out.println(cnt + ". " + app.name);
                    cnt++;
                }
                return;
            }
        }
        System.out.println("can't find desired developer!");
    }
    // end of final session commit
}
