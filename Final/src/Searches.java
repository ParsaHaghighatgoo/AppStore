import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Searches {
    public static App linearSearch(String targetName){
        for (App app: DataBase.appsDb){
            if (app.name.equals(targetName)){
                return app;
            }
        }
        return null;
    }

    public static App searchAppWithBinarySearch(String targetName) {
        Collections.sort(DataBase.appsDb, Comparator.comparing(app -> app.name));
        int literate = 0;
        int riterate = DataBase.appsDb.size() - 1;

        while (literate <= riterate) {
            int mid = literate + (riterate - literate) / 2;
            App midApp = DataBase.appsDb.get(mid);

            int comparisonResult = targetName.compareTo(midApp.name);

            if (comparisonResult == 0) {
                return midApp;
            } else if (comparisonResult < 0) {
                riterate = mid - 1;
            } else {
                literate = mid + 1;
            }
        }

        return null;
    }
}
