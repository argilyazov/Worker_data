import java.util.ArrayList;
import java.util.Comparator;

public class WorkerManager {
    private ArrayList<Worker> workers =new ArrayList<>();

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        for (var worker: workers){
            result.append(worker.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public void sortWorkers() {
        workers.sort(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                var n1 = o1.age;
                var n2 = o2.age;
                return Integer.compare(n1, n2);
            }
        });
    }
}

