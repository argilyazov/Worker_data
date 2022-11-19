import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WorkerFromCSV {
    public static WorkerManager getManagers(String path){
        var workers = new WorkerManager();
        try {
            CSVReader reader = new CSVReader(new FileReader(path), ';', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                workers.addWorker(new Manager(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4], nextLine[5], nextLine[6]));
            }
        }
        catch (IOException e){
            System.out.println("Error CSV Parser");
        }
        return workers;
    }
    public static WorkerManager getWaiters(String path){
        var workers = new WorkerManager();
        try {
            CSVReader reader = new CSVReader(new FileReader(path), ';', '"', 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                workers.addWorker(new Waiter(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4], nextLine[5], nextLine[6]));
            }
        }
        catch (IOException e){
            System.out.println("Error CSV Parser");
        }
        return workers;
    }
}
