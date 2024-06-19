package C07ExceptionFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AuthorRepository {
  List<Author> authorList;

  public AuthorRepository() {
    authorList = new ArrayList<>();
  }

  public void saveAuthor(Author author) {
    authorList.add(author);
  }

  public Optional<Author> findAuthorByEmail(String email) {
    for (Author author : authorList) {
      if(email.equals(author.getEmail())) {
        return Optional.of(author);
      }
    }
    return Optional.empty();
  }


  // 강사님이 피드백해주신 코드
  public Optional<Author> findAuthorByEmail2(String email) {
    Author ret = null;
    for (Author author : authorList) {
      if(email.equals(author.getEmail())) {
        ret = author;
        break;
      }
    }
    return Optional.ofNullable(ret);
  }

  // findByEmail
  public Optional<Author> findAuthorByEmail3(String email) {
    return authorList.stream()
        .filter(a -> email.equals(a.getEmail()))
        .findFirst(); // 가장 간단한 코드
  }


  // 리스트 같은 경우는 Optional로 감싸지 않는다. List에는 아무것도 안들어 있을 수도 있는 거임
  public List<Author> findAllAuthors() {
    return new ArrayList<>(authorList);
  }

}
