package C07ExceptionFileParsing.AuthorException;

import java.util.Scanner;

public class AuthorController {
  public static void main(String[] args) {
    AuthorService authorService = new AuthorService();
    Scanner sc = new Scanner(System.in);

    mainLoop:
    while(true) {
      System.out.println("어떤 서비스를 이용하시겠습니까?");
      System.out.print("1. 회원 가입 / 2. 로그인 / 3. 모든 회원 조회 / 4. 특정 회원 조회 / 5. 종료: ");
      int cmd;
      String name, email, password;
      try {
        cmd = Integer.parseInt(sc.nextLine());

        switch(cmd) {
          case 1:
            System.out.println("== 회원 가입 서비스 ==");

            System.out.print("이름: ");
            name = sc.nextLine();
            System.out.print("이메일: ");
            email = sc.nextLine();
            System.out.print("비밀번호: ");
            password = sc.nextLine();

            authorService.register(name, email, password);
            break;
          case 2:
            System.out.println("== 로그인 서비스 ==");

            System.out.print("이메일: ");
            email = sc.nextLine();
            System.out.print("비밀번호: ");
            password = sc.nextLine();

            authorService.login(email, password);
            break;
          case 3:
            System.out.println("== 모든 회원 조회 서비스 ==");
            authorService.printAllAuthors();
            break;
          case 4:
            System.out.println("== 특정 회원 조회 서비스 ==");
            System.out.print("이메일: ");
            email = sc.nextLine();
            authorService.printOneAuthor(email);
            break;
          case 5:
            System.out.println("== 종료합니다 ==");
            break mainLoop;
          default:
            throw new IllegalArgumentException("[Error] 1~4 사이의 정수를 입력해주세요.");
        }

      } catch(NumberFormatException ne) {
        System.out.println("[Error] 숫자 값을 입력해주세요.");
      } catch(IllegalArgumentException ie) {
        System.out.println(ie.getMessage());
      } catch (Exception e) {
        System.out.println("[Error] 에러가 발생했습니다.");
      }
    }
  }

}
