package C07ExceptionFileParsing.AuthorException;

public class Author {
  private Long id;
  private String name;
  private String email;
  private String password;

  private static Long sequenceId = 0L;

  public Author(String name, String email, String password) {
    this.id = ++sequenceId;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
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

}
