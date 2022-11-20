import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //var managers= WorkerFromCSV.getManagers("manager_data.csv");
        //var waiters=WorkerFromCSV.getWaiters("waiter_data.csv");
        //System.out.println(managers);
        //System.out.println(waiters);
        //WorkersToTXT.saveInfoManager((Manager) managers.getWorkers().get(0),waiters.getWorkers().stream().map(e -> (Waiter)e).collect(Collectors.toList()));
        System.out.println(TakeDataFromBrowser.getWaitersFromBrowser());
    }
}