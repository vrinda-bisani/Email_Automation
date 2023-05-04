import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that generates notification given the data in csv, template file and output directory
 */
public class NotificationGenerator {

  private String csv;
  private String template;
  private String output_dir;

  /**
   * Class that generates notification
   * @param csv file contains company's members information
   * @param template template file to be used
   * @param output_dir directory to store the output file
   */
  public NotificationGenerator(String csv, String template, String output_dir) {
    this.csv = csv;
    this.template = template;
    this.output_dir = output_dir;
  }

  /**
   * returns csv file path
   * @return csv file path
   */
  public String getCsv() {
    return csv;
  }


  /**
   * Replaces data in template file using CSV file value and generates new file
   * @throws IOException input output exception
   */
  public void generate() throws IOException {
    int counter = 0;
    Scanner csvFileData = new Scanner(new FileReader(getCsv()));

    String[] header = csvFileData.nextLine().split(",");
    final String templateFileContents = getTemplateFileContents(template);

    while (csvFileData.hasNext()) {
      String[] value = csvFileData.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
      String newData = replaceData(templateFileContents, header, value);
      writeToFile(newData, output_dir.trim() + "/" + counter + ".txt");
      counter++;
    }
    csvFileData.close();
  }

  /**
   * fetches template file given the path
   * @param path template file path
   * @return file data as string
   * @throws FileNotFoundException if file does not exist
   */
  private String getTemplateFileContents(String path) throws FileNotFoundException {
    Scanner sc_template = new Scanner(new File(path.trim()));
    StringBuffer buffer = new StringBuffer();
    while (sc_template.hasNextLine()) {
      buffer.append(sc_template.nextLine()+System.lineSeparator());
    }
    sc_template.close();

    return buffer.toString();
  }

  /**
   * Replaces template placeholders with CSV file's header values
   * @param template template file data
   * @param header CSV file's header values
   * @param value member data
   * @return replaced template data
   */
  private static String replaceData(String template, String[] header, String[] value){
    for(int i =0; i< header.length; i++){
      template = template.replaceAll("\\[\\["+header[i].replace("\"", "")+"\\]\\]", value[i].replace("\"", ""));
    }
    return template;
  }

  /**
   * Writes replaced template data to new file
   * @param data data to be written in file
   * @param filename file name
   * @throws IOException throws input output exception
   */
  private static void writeToFile(String data, String filename) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      writer.append(data);
      writer.flush();
    }
  }


}
