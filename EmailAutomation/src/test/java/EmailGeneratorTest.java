import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailGeneratorTest {
  EmailGenerator testGenerator;
  String testCSV;
  String testTemplate;
  String testOutput;

  String basePtah = Paths.get(System.getProperty("user.dir")).toString() + "/src/testFiles";

  @BeforeEach
  void setUp() throws IllegalEmailArgumentException {
    testCSV = basePtah + "/testCSV.csv";
    testTemplate = basePtah + "/testTemplate.txt";
    testOutput = basePtah + "/Output/";
    testGenerator = new EmailGenerator(testCSV, testTemplate, testOutput);
  }

  @Test
  void generate() throws IOException {
    testGenerator.generate();
    Scanner outFile = new Scanner(new File(testOutput+ "/0.txt"));
    String outData = outFile.nextLine();
    outFile.close();
    assertTrue(outData.equals("James Butt says hi"));
  }

  @Test
  void emailGeneratorArgsException() {
    assertThrows(IllegalEmailArgumentException.class, () -> new EmailGenerator(testCSV, null, testOutput));
  }

  @Test
  void fileNotFoundException() throws IllegalEmailArgumentException {
    EmailGenerator testGenerator1 = new EmailGenerator(testCSV, "abc", testOutput);
    assertThrows(IOException.class, () -> testGenerator1.generate());
  }
}