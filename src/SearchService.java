import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SearchService {
    //Метод вычисления хэщ-кода файла
    public static String getFileHashCode(File file)  {
        try (FileInputStream fis = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[8000];
            int read = 0;
            while ((read = fis.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] hashBytes = digest.digest();
            return bytesToHex(hashBytes);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Error"; // В случае ошибки
        }
    }
    //Преобразование массива байтов в стринг
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
