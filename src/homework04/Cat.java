package homework04;

public class Cat {
    private String name = "Belyash";
    private int age = 2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Cat cat = (Cat) obj;
        return cat.name.equals(name) && cat.age == age;
    }

    @Override
    public String toString() {
        return "name='" + name + ", age=" + age;
    }
}
