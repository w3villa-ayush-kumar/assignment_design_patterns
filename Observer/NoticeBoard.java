public class NoticeBoard {

    private java.util.List<Observer> observers = new java.util.ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void publishNotice(String msg) {
        System.out.println("HR: " + msg);
        notifyAllObservers(msg);
    }

    public static void main(String[] args) {

        NoticeBoard board = new NoticeBoard();

        EmployeeObserver e1 = new EmployeeObserver("Alice");
        EmployeeObserver e2 = new EmployeeObserver("Bob");

        board.addObserver(e1);
        board.addObserver(e2);

        board.publishNotice("Meeting at 3 PM!");
    }
}


interface Observer {
    void update(String message);
}


class EmployeeObserver implements Observer {

    private String name;

    EmployeeObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
