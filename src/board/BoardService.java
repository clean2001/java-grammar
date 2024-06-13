package board;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BoardService {
    private static Map<String, Author> authorRepositoryByEmail = new HashMap<>();
    private static Map<Long, Author> authorRepositoryById = new HashMap<>();
    private static Map<Long, Post> postRepository = new HashMap<>();

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        loop1:
        while(true) {
            int cmd;
            try {
                printServiceList();
                cmd = sc.nextInt();
                sc.nextLine();
                switch(cmd) {
                    case 0:
                        break loop1;
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        findAllAuthors();
                        break;
                    case 3:
                        findAuthorById();
                        break;
                    case 4:
                        createPost();
                        break;
                    case 5:
                        findAllPosts();
                        break;
                    case 6:
                        findDetailedPost();
                        break;
                    default:
                        System.out.println("지원하지 않는 서비스입니다.");
                }
            } catch(Exception e) {
                System.out.println("====Error====");
                sc.nextLine();
            }

        }
    }

    public static void printServiceList() {
        System.out.println("\n================");
        System.out.println("게시판 서비스입니다.");
        System.out.println("================");
        System.out.println("0. 종료");
        System.out.println("1. 회원 가입");
        System.out.println("2. 회원 전체 목록 조회");
        System.out.println("3. 회원 상세 조회");
        System.out.println("4. 게시글 작성");
        System.out.println("5. 게시글 목록 조회");
        System.out.println("6. 게시글 상세 조회");
        System.out.println("================");
        System.out.print("입력: ");
    }

    // 회원 가입
    public static void createAccount() {

        String name, email, password;

        System.out.println("================");
        System.out.println("회원 가입 서비스입니다.");
        System.out.print("회원 이름(공백 불가능): ");
        name = sc.nextLine();
        System.out.print("회원 이메일: ");
        email = sc.nextLine();
        System.out.print("회원 비밀번호(공백 불가능): ");
        password = sc.nextLine();

        /*
        1. 회원 이메일이 이메일 형식인지 확인
        2. 회원 이메일 정보가 맵에 저장돼 있는지 확인
        3. paasword, name이 empty 인지 확인
        4. 다 잘 돼있다면 저장하기
         */

        if(isValidEmail(email) && !name.isEmpty() && !password.isEmpty()) {
            Author author = new Author(name, email, password);
            authorRepositoryByEmail.put(email, author);
            authorRepositoryById.put(author.getAuthorId(), author);
        } else {
            System.out.println("[Error]: 회원 가입에 실패했습니다. 입력 형식을 확인해주세요.");
        }

    }

    // 전체 리스트 조회
    public static void findAllAuthors() {
        System.out.println("================");
        System.out.println("== 전체 회원 목록 ==");
        System.out.printf("%5s %10s %20s\n", "id", "name", "email");
        for(Author author : authorRepositoryById.values()) {
            String s = String.format("%5d %10s %20s\n", author.getAuthorId(), author.getName(), author.getEmail());
            System.out.println(s);
        }
    }

    // 회원 상세 조회
    public static void findAuthorById() {
        System.out.println("================");
        System.out.print("회원 아이디(숫자): ");
        Long authorId = sc.nextLong();
        sc.nextLine();

        Author author = authorRepositoryById.get(authorId);
        if(author == null) {
            System.out.println("존재하지 않는 회원입니다.");
        } else {
            System.out.println("아이디: " + author.getAuthorId());
            System.out.println("이름: " + author.getName());
            System.out.println("이메일: " + author.getEmail());
        }
    }

    public static void createPost() {
        System.out.println("================");
        System.out.print("작성자 이메일: ");
        String email = sc.nextLine();
        System.out.print("글 제목: ");
        String title = sc.nextLine();
        System.out.print("글 내용: ");
        String contents = sc.nextLine();

        // 작성자 찾기
        Author author = authorRepositoryByEmail.get(email);
        if(author == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }

        Post post = new Post(title, contents, author);
        postRepository.put(post.getPostId(), post);
        System.out.println("글이 성공적으로 등록되었습니다.");
    }

    public static void findAllPosts() {
        System.out.println("================");
        System.out.println("== 전체 글 목록 ==");
        System.out.printf("%5s %10s %30s\n", "id", "author id", "title");
        for(Post post : postRepository.values()) {
            System.out.printf("%5d %5d %20s\n", post.getPostId(),
                    post.getAuthor().getAuthorId(),
                    post.getTitle());
        }
    }

    public static void findDetailedPost() {
        System.out.println("================");
        System.out.print("조회하고 싶은 글 아이디: ");
        Long postId = sc.nextLong();
        sc.nextLine();

        Post post = postRepository.get(postId);
        if(post == null) {
            System.out.println("글이 존재하지 않습니다.");
            return;
        }

        System.out.println("===== 글 상세 조회 =====");
        System.out.println("글 아이디: " + post.getPostId());
        System.out.println("제목: " + post.getTitle());
        System.out.println("작성자 : " + post.getAuthor().getName());
        System.out.println("글 내용: ");
        System.out.println(post.getContents());
        System.out.println("===== 상세 조회 끝 =====");
    }

    // 이메일 형식에 맞고, 아직 가입되지 않은 이메일인지 확인
    private static boolean isValidEmail(String email) {
        return (Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email)
                && authorRepositoryByEmail.get(email) == null);
    }

}
