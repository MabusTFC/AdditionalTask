import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectoryManager {
    // Метод для поиска дубликатов
    public static void searchDublicates(File files, Map<String, List<File>> map){
        File[] directory = files.listFiles();
        if(directory != null){
            for(File file: directory ){
                if(!file.isFile()){
                    searchDublicates(file,map);
                }else {
                    String cheker = SearchService.getFileHashCode(file);
                    if (!map.containsKey(cheker)) {
                        map.put(cheker, new ArrayList<>());
                    }
                    map.get(cheker).add(file);
                }
            }
        }else{
            System.out.println("Директориия пуста" + files.getName());
        }
    }
    //Вывод Листа
    public static void print(Map<String,List<File>> map){
        for (List<File> fileList : map.values()) {
            if (fileList.size() > 1) {
                System.out.println("Дублирующиеся файлы:");
                for (File file : fileList) {
                    System.out.println(file.getName());
                }
                System.out.println();
            }
        }
    }

}
