package homework07.classwork;

/**
 * 	 Добавить студентов в коллекцию
 * 1. Создать класс Student, содержащий следующие характеристики –  имя, группа, курс, оценки по предметам.
 * 2. Создать коллекцию, содержащую объекты класса Student.
 * 3. Написать метод, который удаляет студентов со средним баллом <3 (название методу придумайте сами).
 * 4. Если средний балл>=3, студент переводится на следующий курс.
 * 5. Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
 * 6. А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Masha", 1, 1, 5));
        listOfStudents.add(new Student("Sasha", 1, 2, 4));
        listOfStudents.add(new Student("Dasha", 1, 1, 3));
        listOfStudents.add(new Student("Glasha", 1, 3, 2));
        listOfStudents.add(new Student("Natasha", 1, 1, 1));

        System.out.println("List of students");
        for (Student student : listOfStudents) {
            System.out.println(student.getName()
                    + " group: " + student.getGroup()
                    + " course: " + student.getCourse()
                    + " mark: " + student.getMark());
        }

        throwAway(listOfStudents);

        int course = 2;
        System.out.println("\nList of students after deduction and studying at " + course + " course");
        printStudents(listOfStudents, course);
    }

    public static void throwAway(ArrayList<Student> listOfStudents) {
        Iterator<Student> studIterator = listOfStudents.iterator();

        while (studIterator.hasNext()) {
            Student nextStudent = studIterator.next();
            if (nextStudent.getMark() < 3) {
                studIterator.remove();
            } else {
                nextStudent.setCourse(nextStudent.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        Iterator<Student> studIterator = students.iterator();
        while (studIterator.hasNext()) {
            Student nextStudent = studIterator.next();
            if (nextStudent.getCourse() == course) {
                System.out.println(nextStudent.getName()
                        + " group: " + nextStudent.getGroup()
                        + " course: " + nextStudent.getCourse()
                        + " mark: " + nextStudent.getMark());
            }
        }
    }

}
