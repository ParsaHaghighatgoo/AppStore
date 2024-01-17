import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;

public class User {
    String name;
    String lastName;
    String userName;
    String password;
    ArrayList<App> apps;
    Region region;
    YourApplanguage applanguge;
    Sex sex;
    String email;
    String role;
    Double wallet;
    ArrayList<Buylogs> myBuyLogs;


    public User(String name, String lastName, String userName, String password, ArrayList<App> apps, Region region, YourApplanguage applanguge
            , Sex sex, String email,ArrayList<Buylogs> myBuyLogs) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.apps = apps;
        this.region = region;
        this.applanguge = applanguge;
        this.sex = sex;
        this.email = email;
        this.role = "User";
        this.wallet = 0.00;
        this.myBuyLogs = myBuyLogs;
    }

    public static User login(String username, String password) {
        for (User user : DataBase.usersDb) {
            if (user.userName.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void menu(User logedInUser) {
        if (logedInUser.role.equals("User")) {
            System.out.println("0.sign out" +
                    "\n1.change defualt app language" +
                    "\n2.search a app" +
                    "\n3.Recommendations for apps: " +
                    "\n4.buy a app: " +
                    "\n5.show my BuyLogs: " +
                    "\n6.show a developer profile");
        } else if (logedInUser.role.equals("Developer")) {

        } else if (logedInUser.role.equals("Admin")) {
            System.out.println("0.sign out " +
                    "\n1.show users buy logs: ");
        }
    }

    public static void changeLang(User logedInUser) {
        System.out.println("1.English" +
                "\n2.Persian");
        int whichLang = Integer.parseInt(Main.scanner.nextLine());
        if (whichLang == 1) {
            logedInUser.applanguge = YourApplanguage.ENGLISH;
        } else if (whichLang == 2) {
            logedInUser.applanguge = YourApplanguage.PERSIAN;
        }
        System.out.println("your app language changed :D");
    }

    public static void searchApp(User logedInUser) {
        System.out.println("you can search a app using:" +
                "\n1.simple linear search" +
                "\n2.search app using binary search algoritm");
        int command = Integer.parseInt(Main.scanner.nextLine());
        if (command == 1) {
            System.out.println("enter desired app name:");
            String desiredName = Main.scanner.nextLine();
            App desiredApp = Searches.linearSearch(desiredName);
            System.out.println("1.you can see this app deatils" +
                    "\n2.you can see this app version histories" +
                    "\n3.you can see this app reviews" +
                    "\n4.write a feedback for this app");
            int commandApp = Integer.parseInt(Main.scanner.nextLine());
            if (commandApp == 1) {
                App.printApp(desiredApp);
            } else if (commandApp == 2) {
                App.printAppVersionHistory(desiredApp);
            } else if (commandApp == 3) {
                App.printAppReview(desiredApp);
            } else if (commandApp == 4) {
                FeedBack.createAFeedBack(logedInUser,desiredApp);
            }
        } else if (command == 2) {
            System.out.println("enter desired name: ");
            String desiredName = Main.scanner.nextLine();
            App desiredApp = Searches.searchAppWithBinarySearch(desiredName);
            System.out.println("1.you can see this app deatils" +
                    "\n2.you can see this app version histories" +
                    "\n3.you can see this app reviews" +
                    "\n4.write a feedback for this app");
            int commandApp = Integer.parseInt(Main.scanner.nextLine());
            if (commandApp == 1) {
                App.printApp(desiredApp);
            } else if (commandApp == 2) {
                App.printAppVersionHistory(desiredApp);
            } else if (commandApp == 3) {
                App.printAppReview(desiredApp);
            }
            else if (commandApp == 4) {
                FeedBack.createAFeedBack(logedInUser,desiredApp);
            }
        }
    }

    public static App appRecoms(User logedInUser) {
        int bcounter = 0;
        int ecounter = 0;
        int pcounter = 0;
        int gcounter = 0;
        for (App app : logedInUser.apps) {
            if (app.appCategory.equals(Appcategory.BUSINESS)) {
                bcounter++;
            } else if (app.appCategory.equals(Appcategory.EDUCATIONAL)) {
                ecounter++;
            } else if (app.appCategory.equals(Appcategory.PERSONAL)) {
                pcounter++;
            } else if (app.appCategory.equals(Appcategory.GAME)) {
                gcounter++;
            }
        }
        ArrayList<Integer> counters = new ArrayList<>();
        counters.add(bcounter);
        counters.add(ecounter);
        counters.add(pcounter);
        counters.add(gcounter);
        Collections.sort(counters, Collections.reverseOrder());
        int max = counters.get(0);
        Appcategory biggest = Appcategory.PERSONAL;
        if (max == bcounter) {
            biggest = Appcategory.BUSINESS;
        } else if (max == gcounter) {
            biggest = Appcategory.GAME;
        } else if (max == pcounter) {
            biggest = Appcategory.PERSONAL;
        } else if (max == ecounter) {
            biggest = Appcategory.EDUCATIONAL;
        }
        for (App app:DataBase.appsDb){
            if (app.appCategory.equals(biggest)){
                return app;
            }
        }
        return DataBase.appsDb.get(0);
    }

    public static void buy(User logedInUser) {
        System.out.println("enter the app name: ");
        String targetName = Main.scanner.nextLine();
        for(App app: DataBase.appsDb){
            if(app.name.equals(targetName)){
                if (logedInUser.wallet >= app.price){
                    logedInUser.wallet = logedInUser.wallet - app.price;
                    logedInUser.apps.add(app);
                    Buylogs newBuyLog = new Buylogs(logedInUser,app.price,app);
                    DataBase.adminsDb.get(0).UsersBuyLogs.add(newBuyLog);
                    logedInUser.myBuyLogs.add(newBuyLog);
                    logedInUser.wallet += 1.00;
                }
            }
        }
        System.out.println("cant found desired app!");
    }

    public static void showMyBuyLogs(User logedInUser) {
        for (Buylogs buylogs: logedInUser.myBuyLogs){
            System.out.println("User "+buylogs.customer.name + " buy " + buylogs.app.name + " and this app price is " +
                    buylogs.price);
        }
    }

}
