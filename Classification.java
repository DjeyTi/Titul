class Classification {
    public static void main(String[] args) {
        Cat NewCat = new Cat("Барсик", "27.10.19");
        NewCat.getInfo();
        NewCat.Purr();
        NewCat.Affection();
        NewCat.learnCommands("Лежать");
        System.out.println(NewCat.getCommands());

    }
}

interface Comands {                                             // Создал чисто для того, чтобы вспомнить интерфейсы
    public void getInfo();
}

abstract class Animal implements Comands {
    private String name = null;
    private String DoB = null;
    private String Commands = null;

    protected void setName(String name) {
        this.name = name;        
    }

    protected void setDoB(String DoB) {
        this.DoB = DoB;
    }

    protected void setCommands(String Command) {
        this.Commands = Command;
    }

    protected String getName() {
        return name;
    }

    protected String getDoB() {
        return DoB;
    }

    protected String getCommands() {
        return Commands;
    }

    public void learnCommands(String Command) {
        if (getCommands() == null) {
            setCommands(Command);
        } else {
            String NewCommands = getCommands() + " " + Command;;
            setCommands(NewCommands.replace("null", "").trim());
        }
    }
}

abstract class HouseAnimal extends Animal {
    public void Affection() {
        System.out.println(getName() + " проявляет ласку!");
    }
}

class Cat extends HouseAnimal {

    protected Cat(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Purr() {
        System.out.println(getName() + " мурлычит!");
    }
}

class Dog extends HouseAnimal {
    protected Dog(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Guard() {
        System.out.println(getName() + " охраняет собственность!");
    }
}

class Hamster extends HouseAnimal {
    protected Hamster(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Eat() {
        System.out.println(getName() + " ест!");
    }
}

abstract class PackAnimal extends Animal {
    protected void Work() {
        System.out.println(getName() + " работает!");
    }
}

class Horse extends PackAnimal {
    protected Horse(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Run() {
        System.out.println(getName() + " скачет!");
    }
}

class Donkey extends PackAnimal {
    protected Donkey(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Move() {
        System.out.println(getName() + " переносит груз!");
    }
}

class Camel extends PackAnimal {
    protected Camel(String name, String DoB) {
        setName(name);
        setDoB(DoB);
    }

    @Override
    public void getInfo() {
        System.out.println("Дата рождения: " + getDoB() + "\nИмя: " + getName());
    }

    public void Drink() {
        System.out.println(getName() + " пьёт воду!");
    }
}