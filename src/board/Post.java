package board;

public class Post {
    private static Long sequenceId = 0L;
    private Long postId;
    private String title;
    private String contents;
    private Author author;

    //== Constructor Start ==//
    public Post(String title, String contents, Author author) {
        this.postId = ++sequenceId;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
    //== Constructo End ==//

    //== Getter Start ==//

    public static Long getSequenceId() {
        return sequenceId;
    }

    public Long getPostId() {
        return postId;
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

    //== Getter End ==//

}
