import java.io.*;
import java.util.*;

class LoginSystem {

    public static void main(String[] args) {

        createDBFile();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            String inputId = sc.nextLine().trim();

            System.out.print("password : ");
            String inputPw = sc.nextLine().trim();

            // 2. 파일에서 id/pw 읽어서 확인
            String result = checkLogin(inputId, inputPw);

            if (result.equals("NO_ID")) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
            } else if (result.equals("WRONG_PW")) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
            } else {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }

        sc.close();
    }

 //코드 안에서 txt 파일까지 만드는 구조 입니다
    public static void createDBFile() {
        try {
            FileWriter fw = new FileWriter("db.txt");  // 덮어쓰기 모드
            fw.write("myId1 myPass1\n");
            fw.write("myId2 myPass2\n");
            fw.write("myId3 myPass3\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("db.txt 파일 생성 중 오류 발생");
        }
    }


    public static String checkLogin(String id, String pw) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("db.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(" ");

                if (parts.length != 2) continue;

                String fileId = parts[0].trim();
                String filePw = parts[1].trim();

                // ID 비교
                if (fileId.equals(id)) {
                    // ID 존재 → 비번 비교
                    if (filePw.equals(pw)) {
                        br.close();
                        return "OK";
                    } else {
                        br.close();
                        return "WRONG_PW";
                    }
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("db.txt 파일을 읽는 중 오류 발생");
        }

        return "NO_ID";  // ID 없음
    }
}