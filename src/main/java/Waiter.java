import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Waiter extends Worker {
    private ArrayList<String> tables;
    private ArrayList<Calendar> workedShifts;
    private int numberLocker;

    private int boss;

    public Waiter(int id, String name, String surname, int age, int exp, int numberLocker, int boss) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = exp;
        this.numberLocker = numberLocker;
        this.id = id;
        this.boss = boss;
    }

    public Waiter(String id, String name, String surname, String age, String exp, String numberLocker, String boss) {
        this.name = name;
        this.surname = surname;
        this.age = Integer.parseInt(age);
        this.experience = Integer.parseInt(exp);
        this.numberLocker = Integer.parseInt(numberLocker);
        this.id = Integer.parseInt(id);
        this.boss = Integer.parseInt(boss);
    }

    public static ArrayList<Waiter> sortedByNumberLocker(ArrayList<Waiter> waiters) {
        waiters.sort(new Comparator<Waiter>() {
            @Override
            public int compare(Waiter o1, Waiter o2) {
                var n1 = o1.getNumberLocker();
                var n2 = o2.getNumberLocker();
                return Integer.compare(n1, n2);
            }
        });
        return waiters;
    }

    public int getBoss() {
        return boss;
    }


    public int getNumberLocker() {
        return numberLocker;
    }

    public ArrayList<Calendar> getWorkedShifts() {
        return workedShifts;
    }

    public ArrayList<String> getTables() {
        return tables;
    }

    public void changeWorkedShifts(ArrayList<Calendar> workedShifts) {
        this.workedShifts = workedShifts;
    }

    public void changeTables(ArrayList<String> tables) {
        this.tables = tables;
    }

    public void setNumberLocker(int numberLocker) {
        this.numberLocker = numberLocker;
    }

    public void setBoss(int boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return String.format("Waiter %s %s age: %s number locker: %s", surname, name, age, numberLocker);
    }
}


