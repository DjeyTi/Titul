import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class FileManager {
    private String Name = "C:/Users/papa7/OneDrive/Рабочий стол/HWJava/Titul/PetShop.txt";
    private Path PathName = Path.of(Name);

    protected FileManager() throws IOException {
        initFM();
    }

    protected void initFM() throws IOException {
        if (!Files.exists(PathName)) {
            System.out.println("Библиотеки животных не обнаружено, создание новой библиотеки по заданному пути: " + Name); 
            Files.createFile(Path.of(Name));
        }
    }

    protected String[] ReadFile() throws IOException {
        try {
            List<String> File = Files.readAllLines(PathName);
            String[] List = new String[File.size()];
            int count = 0;
            for (Object str: File) {
                List[count] = str.toString();
                count++;
            }
            return List;
        } catch (IOException e) {
            System.out.println("Ошибка: Чтение файла не получилось");
        }
        return null;
    }

    protected void WriteFile(Animal Ani, String Type) throws IOException {
        try {
            String[] List = ReadFile();
            FileWriter File = new FileWriter(Name);
            for (String str: List) {
                if (!str.contains(Ani.getName() + ", " + Ani.getDoB().trim()))
                    File.append(str + "\n");
            }
            try {
                File.append(Ani.getName() + ", " + Ani.getDoB().trim() + ", " + Ani.getCommands().trim() + "," + Type);
            } catch (Exception e) {
                File.append(Ani.getName() + ", " + Ani.getDoB().trim() + ", " + Ani.getCommands() + "," + Type);
            }
            File.close();
        } catch (IOException e) {
            System.out.println("Ошибка: Чтение файла не получилось");
        }
    }
}
