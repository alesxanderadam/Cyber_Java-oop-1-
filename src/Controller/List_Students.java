package Controller;

import Models.Student;

import java.util.ArrayList;

public class List_Students {
    private ArrayList<Student> lst_student;

    public List_Students() {
        this.lst_student = new ArrayList<Student>();
    }

    public List_Students(ArrayList<Student> lst_student) {
        this.lst_student = lst_student;
    }

    public void addStuden(Student st){
        this.lst_student.add(st);
    }
    public void printListStudent(){
        for (Student student: lst_student) {
            System.out.println(student);
        }
    }
    public void getStdudentById(String st){
        for (Student student: lst_student) {
          if(student.getStudent_id().indexOf(st) > 0){
            System.out.println(student);
          }else{
              System.out.println("Student id not found!");
              return;
          }
        }
    }
}
