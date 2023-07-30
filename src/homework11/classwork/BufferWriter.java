package homework11.classwork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class BufferWriter {
    public static void main(String[] args) {
        File file = Path.of("D:\\dev\\it-academy\\src\\classworkFiles\\output.txt")
                .toFile();

//        try(FileWriter writer = new FileWriter(file)){
//            writer.append("Hi");
//            writer.append("Obama");
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.append("Hi");
            writer.newLine();
            writer.append("Obama");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
