import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private List<Animal> Pets = new ArrayList<Animal>();
    protected FileManager FW = new FileManager();
    private int count = 0;

    protected void setCount(int count) {
        this.count = count;
    }

    protected int getCount() {
        return count;
    }

    protected void setPets(List<Animal> Pets) {
        this.Pets = Pets;
    }
    
    protected PetShop() throws Exception {
        initPets();
    }

    protected void initPets() throws Exception {
        String[] Info = FW.ReadFile();
        List<Animal> NewPets = new ArrayList<Animal>();
        try (Counter NewCounter = new Counter()) {
            for (String str: Info) {
                NewCounter.add();
                String[] split = str.split(",");
                // System.out.println(split[0] + ", " + split[1] + ", " + split[2] + ", " + split[3]);
                NewPets.add(Create(split[0], split[1], split[3]));
                setPets(NewPets);
                getAnimal(split[0]).setCommands(split[2]);
                setCount(NewCounter.getCounter());
            }
        } catch (UnsupportedOperationException e) {
        }
    }

    protected Animal getAnimal(String Clue) {
        for (int i = 0; i < Pets.size(); i++) {
            Animal Check = Pets.get(i);
            try {
                if (Check.getName().contains(Clue) | Check.getDoB().contains(Clue) | Check.getCommands().contains(Clue))
                    return Check; 
            } catch (Exception e) {
                if (Check.getName().contains(Clue) | Check.getDoB().contains(Clue))
                    return Check; 
            }
        }
        return null;
    }

    protected Animal getAnimal(int Number) {
        if (Pets.size() <= Number) {
            System.out.println("Нету животного под данным номером");
            return null;
        } else
            return Pets.get(Number);
    }

    protected int getPetShopSize() {
        try {
            return Pets.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void AddPet(Animal Pet) {
        Pets.add(Pet);
    }

    public void ListOfCommand(Animal Pet) {
        if (Pet instanceof Cat) {
            if (Pet.getCommands() == null) 
                System.out.println("Caress, Purr");
            else
                System.out.println("Caress, Purr," + Pet.getCommands());
        } else if (Pet instanceof Dog) {
            if (Pet.getCommands() == null)
                System.out.println("Caress, Guard");
            else
                System.out.println("Caress, Guard," + Pet.getCommands());
        } else if (Pet instanceof Hamster) {
            if (Pet.getCommands() == null)
                System.out.println("Caress, Eat a lot");
            else
                System.out.println("Caress, Eat a lot," + Pet.getCommands());
        } else if (Pet instanceof Horse) {
            if (Pet.getCommands() == null)
                System.out.println("Work, Run around");
            else
                System.out.println("Work, Run around," + Pet.getCommands());
        } else if (Pet instanceof Camel) {
            if (Pet.getCommands() == null)
                System.out.println("Work, Drink a lot");
            else
                System.out.println("Work, Drink a lot," + Pet.getCommands());
        } else if (Pet instanceof Donkey) {
            if (Pet.getCommands() == null)
                System.out.println("Work, Move");
            else
                System.out.println("Work, Move," + Pet.getCommands());
        } 
    }

    public Animal Create(String name, String DoB, String Type) {
        if (Type.toLowerCase().contains("cat")) {
            Cat NewCat = new Cat(name, DoB);
            return NewCat;
        } else if (Type.toLowerCase().contains("dog")) {
            Dog NewDog = new Dog(name, DoB);
            return NewDog;
        } else if (Type.toLowerCase().contains("hamster")) {
            Hamster NewHamster = new Hamster(name, DoB);
            return NewHamster;
        } else if (Type.toLowerCase().contains("horse")) {
            Horse NewHorse = new Horse(name, DoB);
            return NewHorse;
        } else if (Type.toLowerCase().contains("camel")) {
            Camel NewCamel = new Camel(name, DoB);
            return NewCamel;
        } else if (Type.toLowerCase().contains("donkey")) {
            Donkey NewDonkey = new Donkey(name, DoB);
            return NewDonkey;
        } else {
            System.out.println("Данного типа животного нет в реестре");
            return null;
        }
    }
}
