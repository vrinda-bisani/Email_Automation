import java.io.IOException;

/**
 * Email generator program for the insurance company
 */
public class EmailGenerator {
  private NotificationGenerator notificationGenerator;

  private final String err_message = "Error: --email provided but no --email-template was given.\n"
      + " Usage:\n"
      + "   --email                        only generate email messages\n"
      + "   --email-template <file>  accept a filename that holds the email template. "
      + "   Required if --email is used";

  /**
   * Email generator program for the insurance company
   * @param csv insurance company holds some information about their members in a CSV file
   * @param template email template file path
   * @param output_dir email files to be stores on this path
   */
  public EmailGenerator(String csv, String template, String output_dir)
      throws IllegalEmailArgumentException {
    if(!validateArgs(template)){
      throw new IllegalEmailArgumentException(err_message);
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
   * Generates emails
   * @throws IOException throws input output exception
   */
  public void generate() throws IOException {
    this.notificationGenerator.generate();
  }





}
