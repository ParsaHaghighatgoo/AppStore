import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static User logedInUser;
    public static void main(String[] args) {
        DataBase.start();
        while (true){
            System.out.println("Welcome to my App Store application," +
                    "\nThis is a open source application you can see it in :" +
                    "https://github.com/ParsaHaghighatgoo/AppStore");
            System.out.println("1.login" +
                    "\n2.sign up" +
                    "\n3.explore as guest" +
                    "\n0.exit");
            int startCommand = Integer.parseInt(scanner.nextLine());
            if(startCommand == 1){
                System.out.println("enter your username");
                String inpUsername = scanner.nextLine();
                System.out.println("enter ur pass");
                String inpPassword = scanner.nextLine();
                if(User.login(inpUsername,inpPassword) != null)
                {
                    logedInUser = User.login(inpUsername,inpPassword);
                    System.out.println("Welcome " +logedInUser.name + "your defult app languge is english and your wallet based on dollers" +
                            " you can change it to persian if you want" +
                            "enter 1 esle enter 0 for continue" );
                    int changeLang = Integer.parseInt(scanner.nextLine());
                    if(changeLang == 1 ){
                        logedInUser.applanguge = YourApplanguage.PERSIAN;
                    }
                    while (true){
                        if (logedInUser.role.equals("User")){
                            User.menu(logedInUser);
                            int command = Integer.parseInt(scanner.nextLine());
                            if (command == 0){
                                break;
                            } else if (command == 1) {
                                User.changeLang(logedInUser);
                            } else if (command == 2) {
                                User.searchApp(logedInUser);
                            }
                            else if (command == 3){
                                System.out.println("this app recommended to u based on your profile taste: ");
                                App.printApp(User.appRecoms(logedInUser));
                            } else if (command == 4) {
                                User.buy(logedInUser);
                            } else if (command == 5) {
                                User.showMyBuyLogs(logedInUser);
                            } else if (command == 6) {
                                Developer.showADev();
                            }
                        } else if (logedInUser.role.equals("Admin")) {
                            User.menu(logedInUser);
                            int command = Integer.parseInt(scanner.nextLine());
                            if (command == 0){
                                break;
                            } else if (command == 1) {
                                Admin.showUsersBuyLogs();
                            }
                        }
                    }

                }
                else{
                    System.out.println("wrong username or pass");
                }
            }
            else if (startCommand == 0){
                System.out.println("Thanks for using our app" +
                        "\nBye :D");
                break;
            }
        }

    }
}