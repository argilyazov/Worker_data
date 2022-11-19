public abstract class Worker {
    protected String name;
    protected String surname;
    protected int age;

    protected int experience;
    protected int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public void setAge(int number) {
        if (number < 18 || number > 70)
            throw new RuntimeException(String.format("%s %s введен неверный возраст %s", name, surname, age));
        age = number;
    }

    public void setExperience(int number) {
        if (number < 0 || number > 70)
            throw new RuntimeException(String.format("%s %s введен неверный стаж %s", name, surname, age));
        experience = number;
    }
}
