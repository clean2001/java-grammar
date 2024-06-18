package C07ExceptionFileParsing.AuthorException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class AuthorService {
  private AuthorRepository authorRepository;

  public AuthorService() {
    authorRepository = new AuthorRepository();
  }

  // 회원가입 성공 시 새로운 Author의 id를 반환, 실패 시 IllegalArgumentException
  public Long register(String name, String email, String password) throws IllegalArgumentException {

    //== Validation Start ==//

    // 이미 존재하는 이메일인가?
    if(authorRepository.findAuthorByEmail(email).isPresent()) {
      throw new IllegalArgumentException("[Register Error] 이미 존재하는 이메일입니다.");
    }

    // email이 형식에 맞는가?
    if(!isValidEmail(email)) {
      throw new IllegalArgumentException("[Register Error] 이메일이 형식에 맞지 않습니다.");
    }

    // 비밀번호가 5자리 미만인가?
    if(password == null || password.length() < 5) {
      throw new IllegalArgumentException("[Register Error] 비밀번호는 5자리 이상이어야 합니다.");
    }

    //== Validation End ==//

    Author author = new Author(name, email, password);
    authorRepository.saveAuthor(author);

    return author.getId();
  }

  // 로그인 성공 시 해당 유저의 아이디 반환, 실패 시 IllegalArgumentException
  public Long login(String email, String password) throws IllegalArgumentException {
    // TODO: 이메일로 된 유저가 있는지 찾기
    Optional<Author> authorOpt = authorRepository.findAuthorByEmail(email);
    Author author = authorOpt.orElseThrow(() -> new IllegalArgumentException("[Login Error] 존재하지 않는 유저입니다."));

    if(!password.equals(author.getPassword())) {
      throw new IllegalArgumentException("[Login Error] 비밀번호가 일치하지 않습니다.");
    }

    System.out.println("[Login Success] 로그인 되셨습니다.");
    return author.getId();
  }


  // 모든 회원 조회
  public void printAllAuthors() {
    List<Author> authorList = authorRepository.findAllAuthors();
    System.out.printf("%3s %7s %25s %12s\n", "id", "name", "email", "password");
    for (Author author : authorList) {
      System.out.printf("%3d %7s %25s %12s\n", author.getId(), author.getName(), author.getEmail(), author.getPassword().substring(0, 2) + "*".repeat( author.getPassword().length()-2));
    }
    System.out.println();
  }


  // 특정 회원 조회
  public void printOneAuthor(String email) {
    Optional<Author> authorOpt = authorRepository.findAuthorByEmail(email);
    Author author = authorOpt.orElseThrow(() -> new IllegalArgumentException("[Find Author Error] 존재하지 않는 유저입니다."));
    System.out.printf("%3s %7s %25s %12s\n", "id", "name", "email", "password");
    System.out.printf("%3d %7s %25s %12s\n", author.getId(), author.getName(), author.getEmail(), author.getPassword().substring(0, 2) + "*".repeat(author.getPassword().length()-2));
    System.out.println();
  }


  private boolean isValidEmail(String email) {
    return Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
  }

}
