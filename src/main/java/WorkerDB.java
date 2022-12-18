import java.sql.*;
import java.util.*;

public class WorkerDB {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "123456";

    //id;name;surname;age;exp;departament;sub
    public static void createTableInDataBase() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение установлено..");
            connection.prepareStatement("CREATE SCHEMA IF NOT EXISTS newSchema").execute();
            connection.prepareStatement("CREATE TABLE IF NOT EXISTS newSchema.Waiters (id SERIAL PRIMARY KEY, name VARCHAR(60)  NULL," +
                    "surname VARCHAR(60) NULL, age INT NOT NULL, exp INT NOT NULL, numLock INT NOT NULL, boss VARCHAR(60) NOT NULL)").execute();
            connection.prepareStatement("CREATE TABLE IF NOT EXISTS newSchema.Managers (id SERIAL PRIMARY KEY, name VARCHAR(60)  NULL," +
                    "surname VARCHAR(60) NULL, age INT NOT NULL, exp INT NOT NULL, departament VARCHAR(60) NULL)").execute();
            System.out.println("База данных создана");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addWaitersToDB(ArrayList<Worker> waiters) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            for (int i = 0; i < waiters.size(); i++) {
                try {
                    var waiter = (Waiter) waiters.get(i);
                    connection.prepareStatement(String.format("INSERT INTO newSchema.Waiters VALUES (%d, '%s', '%s', %d, %d, %d, %s)",
                            waiter.id, waiter.name, waiter.surname, waiter.age, waiter.experience, waiter.getNumberLocker(), waiter.getBoss())).execute();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addManagersToDB(ArrayList<Worker> managers) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            for (int i = 0; i < managers.size(); i++) {
                try {
                    var manager = (Manager) managers.get(i);
                    connection.prepareStatement(String.format("INSERT INTO newSchema.Managers VALUES (%d, '%s', '%s', %d, %d)",
                            manager.id, manager.name, manager.surname, manager.age, manager.experience)).execute();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static WorkerManager getWaitersFromDB() {
        var workers = new WorkerManager();
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT id, name, surname, age, exp, numlock, boss FROM newschema.waiters");
            while (set.next()) {
                String name = set.getString("name");
                String surname = set.getString("surname");
                int boss = set.getInt("boss");
                int exp = set.getInt("exp");
                int id = set.getInt("id");
                int age = set.getInt("age");
                int numberLocker = set.getInt("numlock");
                workers.addWorker(new Waiter(id, name, surname, age, exp, numberLocker, boss));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return workers;
    }
}
