public class HRManager {

    private static HRManager instance;

    private HRManager() { }

    public static HRManager getInstance() {
        if (instance == null) {
            instance = new HRManager();
        }
        return instance;
    }

    public void publishNotice(String message) {
        System.out.println("Notice: " + message);
    }

    public static void main(String[] args) {
        HRManager hr1 = HRManager.getInstance();
        HRManager hr2 = HRManager.getInstance();

        hr1.publishNotice("Office holiday tomorrow!");

        System.out.println("Same instance? " + (hr1 == hr2));
    }
}
