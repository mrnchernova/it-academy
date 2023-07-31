package homework11.order;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

    // Читает txt, переносит его в массив и передает последний id
    public static int initFile(File file, List list) {
        int id = 0;
        // если файл не пустой, то парсить
        if (file.length() != 0L) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String str;
                while ((str = reader.readLine()) != null) {

                    String[] item = str.split("\\|");
                    id = Integer.parseInt(item[0].trim());
                    item[1] = item[1].trim();

                    try {
                        Date date = Utils.simpleDateFormat.parse(item[2].trim());

                        /** проверка для добавления данных в нужный класс.
                         Из пути получаем имя файла с которым работаем */
                        String fileName = file.getPath().substring(file.getPath().lastIndexOf('\\') + 1, file.getPath().lastIndexOf('.'));
                        if (fileName.equals("product")) {
                            list.add(new Product(id, item[1], date));
                        } else {
                            list.add(new Order(id, item[1], date));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    // считывает содержимое файла и выводит в консоль
    public static void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = reader.lines().collect(Collectors.joining("\n"));
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    // из массива записывается все в txt
    public static void writeToFile(File file, List list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Object o : list) {
                writer.append(o.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

