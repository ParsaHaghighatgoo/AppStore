import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataBase {
    public static ArrayList<User> usersDb = new ArrayList<>();
    public static ArrayList<Developer> developersDb = new ArrayList<>();
    public static ArrayList<Admin> adminsDb = new ArrayList<>();
    public static ArrayList<App> appsDb = new ArrayList<>();
    public static void start() {
        ArrayList<App> user1apps = new ArrayList<>();
        ArrayList<Buylogs> user1MyBuyLogs = new ArrayList<>();
        User user1 = new User("user1n","user1l","user1","user1",user1apps,Region.EAST, YourApplanguage.ENGLISH,Sex.MALE,"user1@gamil.com",user1MyBuyLogs);
        usersDb.add(user1);
        user1.wallet = 100.00;

        ArrayList<App> dev1apps = new ArrayList<>();
        ArrayList<App> myAppsDev1 = new ArrayList<>();
        ArrayList<Buylogs> dev1BuyLogs = new ArrayList<>();
        Developer developer1 = new Developer("developer1n","developer1l","dev1","dev1",dev1apps,Region.EAST, YourApplanguage.ENGLISH,Sex.MALE,"dev1@gamil.com",dev1BuyLogs,12.1,myAppsDev1);
        usersDb.add(developer1);
        developersDb.add(developer1);

        ArrayList<Buylogs> adminBuyLogs = new ArrayList<>();
        ArrayList<Buylogs> adminUsersBuyLogs = new ArrayList<>();
        ArrayList<App> adminApps = new ArrayList<>();
        Admin admin = new Admin("adminn","adminl","admin","admin",adminApps,Region.EAST, YourApplanguage.ENGLISH,Sex.MALE,"admin@gamil.com",adminBuyLogs,adminUsersBuyLogs);
        usersDb.add(admin);
        adminsDb.add(admin);

        ArrayList<Double> app1Rates = new ArrayList<>();
        ArrayList<versionHistory> app1VersionHistory = new ArrayList<>();
        ArrayList<AppLanguages> app1AppLanguages = new ArrayList<>();
        ArrayList<Review> app1Reviews = new ArrayList<>();
        ArrayList<FeedBack> app1Feedbacks = new ArrayList<>();
        App app1 = new App("BusinessApp" , developer1 , 20.12,"app1 description", app1Rates,0.00,Appcategory.BUSINESS
        ,"1.0.0",app1VersionHistory,app1AppLanguages,app1Reviews,app1Feedbacks);
        appsDb.add(app1);

        developer1.createdApps.add(app1);



        ArrayList<Double> app2Rates = new ArrayList<>();
        ArrayList<versionHistory> app2VersionHistory = new ArrayList<>();
        ArrayList<AppLanguages> app2AppLanguages = new ArrayList<>();
        ArrayList<Review> app2Reviews = new ArrayList<>();
        ArrayList<FeedBack> app2Feedbacks = new ArrayList<>();
        App app2 = new App("StudentApp" , developer1 , 21.00,"app2 description", app2Rates,0.00,Appcategory.EDUCATIONAL
                ,"1.0.0",app2VersionHistory,app2AppLanguages,app2Reviews,app2Feedbacks);
        appsDb.add(app2);
        developer1.createdApps.add(app2);
        user1.apps.add(app2);

        ArrayList<Double> app3Rates = new ArrayList<>();
        ArrayList<versionHistory> app3VersionHistory = new ArrayList<>();
        ArrayList<AppLanguages> app3AppLanguages = new ArrayList<>();
        ArrayList<Review> app3Reviews = new ArrayList<>();
        ArrayList<FeedBack> app3Feedbacks = new ArrayList<>();
        App app3 = new App("bApp3" , developer1 , 20.12,"app1 description", app3Rates,0.00,Appcategory.BUSINESS
                ,"1.0.0",app3VersionHistory,app3AppLanguages,app3Reviews,app3Feedbacks);
        appsDb.add(app3);
        user1.apps.add(app3);
        developer1.createdApps.add(app3);

        ArrayList<Double> app4Rates = new ArrayList<>();
        ArrayList<versionHistory> app4VersionHistory = new ArrayList<>();
        ArrayList<AppLanguages> app4AppLanguages = new ArrayList<>();
        ArrayList<Review> app4Reviews = new ArrayList<>();
        ArrayList<FeedBack> app4Feedbacks = new ArrayList<>();
        App app4 = new App("xApp4" , developer1 , 20.12,"app1 description", app4Rates,0.00,Appcategory.BUSINESS
                ,"1.0.0",app4VersionHistory,app4AppLanguages,app4Reviews,app4Feedbacks);
        appsDb.add(app4);
        user1.apps.add(app4);
        developer1.createdApps.add(app4);


        Collections.sort(appsDb, Comparator.comparing(app -> app.name));

    }

}
