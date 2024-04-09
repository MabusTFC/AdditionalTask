import java.io.File;
import java.util.*;
//Смирнов Иван Андреевич ПрИ-201
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите путь:");
        String folderPath = scan.nextLine();
        File folder = new File(folderPath);
        if(!folder.isDirectory() || !folder.exists()){
            System.out.println("Путь введен некорректно!");
            return;
        }
        List<File> folderList = new ArrayList<>();
        Map<String, List<File>> map = new HashMap<>();
        DirectoryManager.searchDublicates(folder, map);
        DirectoryManager.print(map);
    }
}
//C:\Users\vanec\OneDrive\Рабочий стол\ПрограммированиеLAST