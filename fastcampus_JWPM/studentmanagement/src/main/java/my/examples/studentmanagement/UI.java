package my.examples.studentmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class UI {
    public int main(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("(1) 학생 등록");
        System.out.println("(2) 학생 목록 보기");
        System.out.println("(3) 종료");

        while(true){
            System.out.print("선택 : ");    choice = sc.nextInt();
            if(choice > 0 && choice < 4)
                break;
            else
                System.out.println("잘못된 값 입력, 1~3 사이의 숫자를 선택하세요");
        }
        System.out.println();
        return choice;
    }

    public Student addStudent(){
        Student student = null;
        String name;
        String add;
        int korNum;
        int engNum;
        int mathNum;

        Scanner sc = new Scanner(System.in);

        System.out.println("학생 정보 입력");
        System.out.print("이름 : ");  name = sc.nextLine();
        System.out.print("국어 점수 : ");   korNum = sc.nextInt();
        System.out.print("영어 점수 : ");   engNum = sc.nextInt();
        System.out.print("수학 점수 : ");   mathNum = sc.nextInt();

        while(true) {
            System.out.print("등록하시겠습니까?(Y/N) ");
            add = sc.next();
            if(add.equals("Y")) {
                student = new Student(name, korNum, engNum, mathNum);
                break;
            } else if(add.equals("N")) {
                System.out.println("등록을 취소합니다.");
                break;
            } else
                System.out.println("잘못된 값 입력, Y or N 중 하나를 입력하세요!");
        }
        System.out.println();
        return student;
    }

    public void listStudent(List<Student> students){
        System.out.println("이름 \t 국어 \t 영어 \t 수학");
        for(Student student : students)
            System.out.println(student.getName() + "\t" + student.getKorNum() + "\t"
                    + student.getEngNum() + "\t" + student.getMathNum());
    }

    public void end(){
        System.out.println("시스템을 종료합니다.");
    }
}
