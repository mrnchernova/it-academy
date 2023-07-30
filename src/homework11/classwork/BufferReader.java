package homework11.classwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * позволяет в функциональном виде читать данные из файла
 */
public class BufferReader {
    public static void main(String[] args) {
        File file = Path.of("D:\\dev\\it-academy\\src\\classworkFiles\\text.txt").toFile();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str = reader.lines().collect(Collectors.joining("\n"));
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
