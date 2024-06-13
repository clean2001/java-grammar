package board;

public class Author {
    private static Long sequenceId = 0L;
    private Long authorId;
    private String name;
    private String email;
    private String password;

    //== Constructor Start ==//
    public Author(String name, String email, String password) {
        this.authorId = ++sequenceId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //== Constructor End ==//

    //== Getter Start ==//
    public static Long getSequenceId() {
        return sequenceId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //== Getter End ==//

    //== Custom Methods ==//
    public void changeName(String name) {
        this.name = name;
    }

    public void changePassword(String password) {
        this.name = name;
    }

    //== Custom Methods End ==//
}
