import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            int id = sc.nextInt();
            String name = sc.next();
            String major = sc.next();
            long phone = sc.nextLong();

            students[i] = new Student(id, name, major, phone);
        }

        System.out.println("\n입력된 학생들의 정보는 다음과 같습니다.");
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println((i+1) + "번째 학생: "
                    + s.getStudentId() + " "
                    + s.getName() + " "
                    + s.getMajor() + " "
                    + s.getFormattedPhone());
        }

        sc.close();
    }
}

