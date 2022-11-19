import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Manager extends Worker {
    private final String departament;
    private List<Integer> subordinates;
    private List<String> tasks;

    public static ArrayList<Manager> sortedByNumberLocker(ArrayList<Manager> managers) {
        managers.sort(new Comparator<Manager>() {
            @Override
            public int compare(Manager o1, Manager o2) {
                var n1 = o1.subordinates.size();
                var n2 = o2.subordinates.size();
                return Integer.compare(n1, n2);
            }
        });
        return managers;
    }

    public Manager(int id, String name, String surname, int age, int exp, String departament, ArrayList<Integer> sub) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = exp;
        this.departament = departament;
        this.subordinates = sub;

    }

    public Manager(String id, String name, String surname, String age, String exp, String departament, String sub) {
        this.id=Integer.parseInt(id);
        this.name = name;
        this.surname = surname;
        this.age = Integer.parseInt(age);
        this.experience = Integer.parseInt(exp);
        this.departament = departament;
        this.subordinates = Arrays.stream(sub.split(",")).map(e->Integer.valueOf(e.replaceAll(" ",""))).collect(Collectors.toList());

    }

    public Manager(String departament) {
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void addSubordinates(Integer worker) {
        subordinates.add(worker);
    }

    public void changeTasks(String command, ArrayList<String> tasks) {
        switch (command) {
            case "NEWDAY" -> this.tasks = tasks;
            case "ADDTASK" -> this.tasks.addAll(tasks);
        }
    }

    @Override
    public String toString() {
        return String.format("Manager %s %s age: %s count subordinates: %s",surname,name,age,subordinates.size());
    }
}

