import java.util.Scanner;

public class Menu {
    public static void MainMenu() throws Exception {
        FileManager FW = new FileManager();
        PetShop NewPetShop = new PetShop();
        System.out.println("Добро пожаловать в главное меню питомника, прошу введите нужную команду");
        System.out.println("Внимание! Кириллица всё ещё не желает работать с данной версией приложения! Используйте английский язык!");
        System.out.println("Список команд:\nA - Добавить животного в реестр\nC - Показать список команд животного");
        System.out.println("AC - Добавить новую команду\nQ - Выйти из меню реестра\nR - Вывести на экран текущий реестр");
        Scanner in = new Scanner(System.in);
        String Enter = in.nextLine();
        if (Enter.contentEquals("A")) {
            int Size = NewPetShop.getPetShopSize();
            System.out.println("Введите нужную информацию через запятую (Имя, Дата Рождения, Тип животного): ");
            String[] Info = in.nextLine().split(",", 3);
            try (Counter NewCounter = new Counter()){
                NewCounter.setCounter(NewPetShop.getCount());
                NewPetShop.AddPet(NewPetShop.Create(Info[0], Info[1], Info[2]));
                NewCounter.add();
                NewPetShop.setCount(NewCounter.getCounter());
            } catch (UnsupportedOperationException e) {
            }
            FW.WriteFile(NewPetShop.getAnimal(Info[0]), NewPetShop.getAnimal(Info[0]).getClass().toString().replace("class", ""));
            if (Size != NewPetShop.getPetShopSize()) {
                System.out.println("Животное добавлено в реестр.");
            } else {
                System.out.println("Животное не получилось добавить в реестр.");
            }
            Ask();
        } else if (Enter.contentEquals("C")) {
            System.out.println("Введите Имя животного: ");
            Animal Check = NewPetShop.getAnimal(in.nextLine());
            if (Check != null) {
                NewPetShop.ListOfCommand(Check);
            } else {
                System.out.println("Нету данного животного в реестре.");
            }
            Ask();
        } else if (Enter.contains("AC")) {
            System.out.println("Введите Имя животного: ");
            Animal Check = NewPetShop.getAnimal(in.nextLine());
            if (Check != null) {
                System.out.println("Введите команду: ");
                Check.learnCommands(in.nextLine());
                FW.WriteFile(Check, Check.getClass().toString().replace("class", ""));
                System.out.println("Команда добавлена.");
            } else {
                System.out.println("Нету данного животного в реестре.");
            }
            Ask();
        } else if (Enter.contains("R")) {
            String[] List = FW.ReadFile();
            for (String str: List)
                System.out.println(str);
//          System.out.println("Операция выполнена. Count = " + NewPetShop.getCount());
            Ask();
        } else if (Enter.contains("Q")) {
            System.out.println("Выход из программы, удачного дня!");
        } else {
            System.out.println("Неизвестная команда, попробуйте ещё раз.");
            Ask();
        }
        in.close();
    }

    protected static void Ask() throws Exception {
        System.out.println("Вы желаете вернуться в главное меню?\nY - Да    N - Нет");
        Scanner in = new Scanner(System.in);
        String Enter = in.nextLine();
        if (Enter.contains("Y")) {
            System.out.println("Возврат в главое меню");
            MainMenu();
        } else if (Enter.contains("N")) {
            System.out.println("Выключение программы, удачного дня!");
        } else {
            System.out.println("Неверная команда, выключение программы.");
        }
        in.close();        
    }
}
