import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkersToTXT {
    public static void saveInfoManager(Manager manager, List<Waiter> waiters){
        List<String> lines = new ArrayList<>();
        lines.add(String.format("Information about %s\n",manager.toString()));
        waiters.stream().filter(e -> manager.getSubordinates().contains((Integer) e.id)).forEach(e -> lines.add(String.format("[%s] %s",e.id,e)));
        try {
            Path file = Paths.get(String.format("%s_%s_%s.txt",manager.surname,manager.name,manager.id));
            Files.write(file, lines, StandardCharsets.UTF_8);
        }
        catch(IOException e){
            System.out.println("Error writing workers to txt");
        }
    }
}
