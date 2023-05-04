import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndexTest {
  String[] emailArgs;
  String[] letterArgs;

  @BeforeEach
  void setUp() {
    Index idx = new Index();
  }

  @Test
  void mainIllegalEmailArgsException(){
    emailArgs = new String[]{"--csv-file", "customer.csv", "--letter-template", "email-template.txt",
        "--output-dir", "emails", "--email"};
    assertThrows(IllegalEmailArgumentException.class, () -> Index.main(emailArgs));
  }

  @Test
  void mainIllegalLetterArgsException(){
    letterArgs = new String[]{"--csv-file", "customer.csv", "--email-template", "letter-template.txt",
        "--output-dir", "letters", "--letter"};
    assertThrows(IllegalLetterArgumentException.class, () -> Index.main(letterArgs));
  }

  @Test
  void mainIllegalArgsException(){
    assertThrows(IllegalArgumentException.class, () -> Index.main(new String[]{}));
  }

  @Test
  void mainEmailIOException(){
    emailArgs = new String[]{"--csv-file", "customer.csv", "--email-template", "email-template.txt",
        "--output-dir", "emails", "--email"};
    assertThrows(IOException.class, () -> Index.main(emailArgs));
  }

  @Test
  void mainLetterIOException(){
    letterArgs = new String[]{"--csv-file", "customer.csv", "--letter-template", "letter-template.txt",
        "--output-dir", "letters", "--letter"};
    assertThrows(IOException.class, () -> Index.main(letterArgs));
  }


}