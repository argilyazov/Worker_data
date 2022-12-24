import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var managers= WorkerFromCSV.getManagers("manager_data.csv");
        var waiters=WorkerFromCSV.getWaiters("waiter_data.csv");
        //System.out.println(managers);
        //System.out.println(waiters);
        //WorkersToTXT.saveInfoManager((Manager) managers.getWorkers().get(0),waiters.getWorkers().stream().map(e -> (Waiter)e).collect(Collectors.toList()));
        //System.out.println("Из интернета\n" + TakeDataFromBrowser.getWaitersFromBrowser());
        //WorkerDB.createTableInDataBase();
        //WorkerDB.addWaitersToDB(waiters.getWorkers());
        //WorkerDB.addManagersToDB(managers.getWorkers());
        System.out.println("Датабаза\n" + WorkerDB.getWaitersFromDB());
        Graphics.Show(Graphics.createDemoPanel(managers.getWorkers().stream().map(x->(Manager)x).collect(Collectors.toCollection(ArrayList::new))));

    }
}