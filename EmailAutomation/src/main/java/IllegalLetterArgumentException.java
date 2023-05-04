/**
 * Exception to handle illegal input arguments for letter
 */
public class IllegalLetterArgumentException extends Throwable {

  /**
   * Exception to handle illegal input arguments for email
   * @param err_message error message
   */
  public IllegalLetterArgumentException(String err_message) {
    super(err_message);
  }
}
