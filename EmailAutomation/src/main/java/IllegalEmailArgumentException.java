/**
 * Exception to handle illegal input arguments for email
 */
public class IllegalEmailArgumentException extends Throwable {

  /**
   * Exception to handle illegal input arguments for email
   * @param message err message
   */
  public IllegalEmailArgumentException(String message) {
    super(message);
  }
}
