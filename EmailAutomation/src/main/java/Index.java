import java.io.IOException;
import java.util.HashMap;

public class Index {
  public static void main(String[] args)
      throws IOException, IllegalLetterArgumentException, IllegalEmailArgumentException {
    String argsString = String.join(" ", args);
    String[] commands = argsString.split("--");
    HashMap<String,String> inputArgs = new HashMap<>();
    for (String command : commands){
      if(!command.equals("")){
      String key = command.split(" ",2)[0];
      String value = command.split(" ").length == 1 ? null : command.split(" ",2)[1];
      inputArgs.put(key,value);
      }
    }

    if(inputArgs.containsKey("email")){
      EmailGenerator email = new EmailGenerator(inputArgs.get("csv-file"),inputArgs.get("email-template"),inputArgs.get("output-dir"));
      email.generate();
    }
    else if (inputArgs.containsKey("letter")) {
      LetterGenerator letter = new LetterGenerator(inputArgs.get("csv-file"),inputArgs.get("letter-template"),inputArgs.get("output-dir"));
      letter.generate();
    }
    else{
      throw new IllegalArgumentException("Illegal Argument");
    }

  }

}
