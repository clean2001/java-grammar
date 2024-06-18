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

  public List<Author> findAllAuthors() {
    return new ArrayList<>(authorList);
  }

}
