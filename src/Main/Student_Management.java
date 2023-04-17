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
            System.out.println("1. Print list student: \n");
            System.out.println("2. Get student by id: \n");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                while (true) {
                    System.out.println("=== Nhập thông tin sinh viên ===");
                    System.out.print("Mã sinh viên: ");
                    String student_id = scanner.nextLine();

                    System.out.print("Họ tên sinh viên: ");
                    String student_name = scanner.nextLine();

                    System.out.print("Giới tính (Nam/Nữ): ");
                    String genderStr = scanner.nextLine();
                    boolean gender = false;
                    if (genderStr.equalsIgnoreCase("Nam")) {
                        gender = true;
                    }

                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
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
                        System.out.println("Nhập điểm môn học thứ " + (i+1));
                        Score score = Score.inputScores(scanner);
                        student.addScore(score);
                    }

                    list_students.addStuden(student);

                    System.out.print("Bạn có muốn nhập tiếp không? (Y/N): ");
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