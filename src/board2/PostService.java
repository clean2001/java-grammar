package board2;

import java.util.*;
import java.util.regex.Pattern;

public class PostService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n[게시판 서비스]");
            System.out.println("1.회원가입\n2.회원 전체 목록 조회\n3.회원 상세 조회\n4.게시글 작성\n5.게시물 목록 조회\n6.게시물 상세 조회\n7.서비스 종료");
            System.out.print("선택: ");
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                Author.register(sc);
            } else if (num == 2) {
                Author.listAuthor();
            } else if (num == 3) {
                Author.detailAuthor(sc);
            } else if (num == 4) {
                Post.createPost(sc);
            } else if (num == 5) {
                Post.listPost();
            } else if (num == 6) {
                Post.detailPost(sc);
            } else if (num == 7) {
                System.out.println("서비스를 종료합니다.");
                return;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}

class Author {
    static Map<Long, Author> authors = new TreeMap<>();
    private String name;
    private String email;
    private String passwd;
    private static Long static_id = 0L;
    private Long id;

    Author(String name, String email, String passwd) {
        this.id = ++static_id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public Long getId() {
        return id;
    }


    public static void register(Scanner scan) {
        System.out.print("이름: ");
        String name = scan.nextLine();
        System.out.print("이메일: ");
        String email = scan.nextLine();
        System.out.print("비밀번호(8자리 이상): ");
        String passwd = scan.nextLine();

        if (passwd.length() < 8) {
            System.out.println("비밀번호는 8자 이상이어야 합니다.");
            return;
        }
        // 이메일 정규 표현식 몰라서 검색함..
        if (!Pattern.matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", email)) {
            System.out.println("이메일 형식이 올바르지 않습니다.");
            return;
        }
        authors.put(static_id, new Author(name, email, passwd));
        System.out.println("회원 가입이 완료되었습니다.");
    }

    public static void listAuthor() {
        for (Author author : authors.values()) {
            System.out.println("ID: " + author.getId() + "\tEmail: " + author.getEmail());
        }
    }

    public static void detailAuthor(Scanner scan) {
        System.out.print("조회할 회원 ID: ");
        Long id = scan.nextLong();
        scan.nextLine();
        Author author = authors.get(id);
        if(author != null){
            String Passwd = author.passwd.substring(0, 3) + "*".repeat(author.passwd.length() - 3);
            System.out.println("ID: " + id + "\tName: " + author.name + "\tEmail: " + author.email + "\tPassword: " + Passwd);
            return;
        }else {
            System.out.println("존재하지 않는 회원입니다.");
        }
    }

}



class Post {
    static Map<Long, Post> posts = new TreeMap<>();
    private String title;
    private String contents;
    private Author author;
    private static Long static_id = 0L;
    private Long id;

    public Post(String title, String contents, Author author) {
        this.id = ++static_id;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }
    public Long getId() {
        return id;
    }


    public static void createPost(Scanner scan) {
        System.out.print("제목: ");
        String title = scan.nextLine();
        System.out.print("내용: ");
        String contents = scan.nextLine();
        System.out.print("작성자 id: ");
        Long author_id = scan.nextLong();
        scan.nextLine();

        for(Author a : Author.authors.values()){
            System.out.println(a.getId());
            System.out.println(a.getEmail());
        }
        Author author = Author.authors.get(author_id);

        if (author == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }

        posts.put(static_id, new Post(title, contents, author));
        System.out.println("게시물이 성공적으로 업로드 되었습니다.");
    }

    public static void listPost() {
        for (Post post : posts.values()) {
            System.out.println("ID: " + post.getId() + "\tTitle: " + post.getTitle());
        }
    }

    public static void detailPost(Scanner scan) {
        System.out.print("조회할 게시물ID: ");
        Long id = Long.parseLong(scan.nextLine());
        Post p = Post.posts.get(id);
        if(p != null){
            System.out.println("Post ID: " + id + "\tTitle: " + p.title + "\tContent: " + p.contents + "\nAuthor: " + p.author.getName());
        }else {
            System.out.println("존재하지 않는 게시물입니다.");
        }
    }
}