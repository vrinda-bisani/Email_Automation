import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterGeneratorTest {
  LetterGenerator testGenerator;
  String testCSV;
  String testTemplate;
  String testOutput;
  String basePtah = Paths.get(System.getProperty("user.dir")).toString() + "/src/testFiles";
  @BeforeEach
  void setUp() throws IllegalLetterArgumentException {
    testCSV = basePtah + "/testCSV.csv";
    testTemplate = basePtah + "/testTemplate.txt";
    testOutput = basePtah + "/Output/";
    testGenerator = new LetterGenerator(testCSV, testTemplate, testOutput);
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
  void letterGeneratorArgsException() {
    assertThrows(IllegalLetterArgumentException.class, () -> new LetterGenerator(testCSV, null, testOutput));
  }
}