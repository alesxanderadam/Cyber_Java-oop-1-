package Main;

import Controller.List_Students;
import Models.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student_Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List_Students list_students = new List_Students();
        do{
            System.out.println("-------------------Menu-------------------");
            System.out.println("1. Enter information student: \n");
            System.out.println("2. Print list student: \n");
            System.out.println("2. Get student by id: \n");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                while (true) {
                    System.out.println("=== Enter information student ===");
                    System.out.print("Student id: ");
                    String student_id = scanner.nextLine();

                    System.out.print("Student name: ");
                    String student_name = scanner.nextLine();

                    System.out.print("Gender (Boy / Girl): ");
                    String genderStr = scanner.nextLine();
                    boolean gender = false;
                    if (genderStr.equalsIgnoreCase("Boy")) {
                        gender = true;
                    }

                    System.out.print("Date (dd/MM/yyyy): ");
                    String dateStr = scanner.nextLine();
                    Date birth_of_date = null;
                    try{
                        birth_of_date = sdf.parse(dateStr);
                    }
                    catch (Exception ex) {
                        System.out.println("Invalid date format!");
                    }

                    Student student = new Student(student_id, student_name, gender, birth_of_date);

                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter the score of the subject  " + (i+1));
                        Score score = Score.inputScores(scanner);
                        student.addScore(score);
                    }

                    list_students.addStuden(student);

                    System.out.print("Do you want to continue? (Y/N): ");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("N")) {
                        break;
                    }
                }
            } else if (choice == 2) {
                list_students.printListStudent();
            } else if (choice == 3 ) {
                System.out.println("Enter id student to find: ");
                String id = scanner.nextLine();
                list_students.getStdudentById(id);
            }else {
                System.out.println("Chose not found!");
                break;
            }
        }while (choice != 0);
    }
}