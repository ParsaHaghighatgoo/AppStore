import java.util.ArrayList;
import java.util.Collections;

public class App {
    String name;
    Developer developer;
    Double price;
    String description;
    ArrayList<Double> rates;
    Double avgRate;
    Appcategory appCategory;
    String lastVersion;
    ArrayList<versionHistory> versionHistories;
    ArrayList<AppLanguages> appLanguages;
    ArrayList<Review> reviews;
    ArrayList<FeedBack> feedBacks;
    int downloadCounter;

    public App(String name, Developer developer, Double price, String description, ArrayList<Double> rates, Double avgRate, Appcategory appCategory, String lastVersion, ArrayList<versionHistory> versionHistories, ArrayList<AppLanguages> appLanguages, ArrayList<Review> reviews, ArrayList<FeedBack> feedBacks) {
        this.name = name;
        this.developer = developer;
        this.price = price;
        this.description = description;
        this.rates = rates;
        this.avgRate = avgRate;
        this.appCategory = appCategory;
        this.lastVersion = lastVersion;
        this.versionHistories = versionHistories;
        this.appLanguages = appLanguages;
        this.reviews = reviews;
        this.feedBacks = feedBacks;
        this.downloadCounter = 0;
    }

    public static void printApp(App desiredApp) {
        System.out.println("App's name: " + desiredApp.name);
        System.out.println("Apps's Developer: " + desiredApp.developer);
        System.out.println("Apps's Price: " + desiredApp.price);
        System.out.println("Apps's Description: " + desiredApp.description);
        System.out.println("Apps's Rate: " + desiredApp.avgRate);
        System.out.println("Apps's Category: " + desiredApp.appCategory);
        System.out.println("Apps's LastVersion: " + desiredApp.lastVersion);
        System.out.println("Apps's languages: " + desiredApp.appLanguages);
        System.out.println("Apps's Number of Downloads: " + desiredApp.downloadCounter);
    }

    public static void printAppReview(App desiredApp) {
        for (Review review : desiredApp.reviews) {
            System.out.println("reveiew user: " + review.user.userName);
            System.out.println("reveiew app name: " + review.app.name);
            System.out.println("reveiew about: " + review.about);
            System.out.println("reveiew title: " + review.title);
            System.out.println("reveiew date: " + review.date);
            System.out.println("reveiew this user rate to this app: " + review.userRateToThisApp);
        }
    }

    public static void printAppVersionHistory(App desiredApp) {
        for (versionHistory versionHistory : desiredApp.versionHistories) {
            System.out.println("version number: " + versionHistory.versionNum);
            System.out.println("this version history discrption: " + versionHistory.thisVersionDescription);
        }
    }



}
