package homework11.classwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputReader {
    public static void main(String[] args) {
        File file = Path.of("D:\\dev\\it-academy\\src\\classworkFiles\\text.txt").toFile();
//        System.out.println(file.exists());
        FileInputStream inputStream = null;

        try {
/** I variant */
            inputStream = new FileInputStream(file);
            byte[] bytes = inputStream.readAllBytes();
            String text = new String(bytes);
            System.out.println(text);
/** II variant
 byte[] bytes = new byte[inputStream.available()];
 int index = 0;
 byte currentByte;
 while ((currentByte = (byte) inputStream.read()) != -1) {
 bytes[index++] = currentByte;
 }
 String text = new String(bytes);
 System.out.println(text);
 */
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
