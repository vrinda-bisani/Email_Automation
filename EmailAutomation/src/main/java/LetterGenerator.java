import java.io.IOException;

/**
 * Letter generator program for the insurance company
 */
public class LetterGenerator {
  private NotificationGenerator notificationGenerator;

  private final String err_message = "Error: --letter provided but no --letter-template was given.\n"
      + " Usage:\n"
      + "   --letter                        only generate letters\n"
      + "   --letter-template <file>  accept a filename that holds the letter template."
      + "   Required if --letter is used";

  /**
   * Letter generator program for the insurance company
   * @param csv insurance company holds some information about their members in a CSV file
   * @param template letter template file path
   * @param output_dir letter files to be stores on this path
   */
  public LetterGenerator(String csv, String template, String output_dir)
      throws IllegalLetterArgumentException {
    if(!validateArgs(template)){
      throw new IllegalLetterArgumentException(err_message);
    }
    this.notificationGenerator = new NotificationGenerator(csv, template, output_dir);
  }
  /**
   * Checks illegal combination of inputs
   * @param template email template file path
   * @return true if path is empty
   */
  private boolean validateArgs(String template) {
    return template != null;
  }
  /**
   * Generates letters
   * @throws IOException throws input output exception
   */
  public void generate() throws IOException {
    this.notificationGenerator.generate();
  }

}
