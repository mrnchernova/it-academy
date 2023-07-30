package homework11.classwork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStream {
    public static void main(String[] args) {
        File file = Path.of("D:\\dev\\it-academy\\src\\classworkFiles\\output.txt").toFile();
/** Перезаписывает файл
 //        try (FileOutputStream outputStream = new FileOutputStream(file)) {
 //            String text = "hello Obama!";
 //            outputStream.write(text.getBytes());
 //        } catch (IOException e) {
 //            e.printStackTrace();
 //        }
 */

/** НЕ перезаписывает файл
 //        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
 //            String text = "hello Obama!";
 //            outputStream.write(text.getBytes());
 //        } catch (IOException e) {
 //            e.printStackTrace();
 //        }
 */

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            String text = "hello Obama!";
            for (int i = 0; i < 10; i++) {

                outputStream.write(text.getBytes());
//                outputStream.write("\n".getBytes());
                outputStream.write(System.lineSeparator().getBytes());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
