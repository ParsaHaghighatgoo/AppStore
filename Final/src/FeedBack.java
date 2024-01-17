public class FeedBack {
    String title;
    User user;
    App app;
    String about;
    FeedBackType feedBackType;

    public FeedBack(String title, User user, App app, String about, FeedBackType feedBackType) {
        this.title = title;
        this.user = user;
        this.app = app;
        this.about = about;
        this.feedBackType = feedBackType;
    }

    public static void createAFeedBack(User logedInUser, App desiredApp) {
        System.out.println("enter a title for it: ");
        String newTitle = Main.scanner.nextLine();
        System.out.println("enter a about for it : ");
        String newAbout = Main.scanner.nextLine();
        System.out.println("1.satisfied or 2.not: ");
        int satisfied = Integer.parseInt(Main.scanner.nextLine());
        FeedBackType feed = FeedBackType.SATISFIED;
        if (satisfied == 1) {
            feed = FeedBackType.SATISFIED;
        } else {
            feed = FeedBackType.NOTSATISFIED;
        }
        FeedBack newFeedBack = new FeedBack(newTitle, logedInUser, desiredApp, newAbout, feed);
        desiredApp.feedBacks.add(newFeedBack);
    }
}
