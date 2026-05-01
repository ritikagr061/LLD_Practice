import log.LogManager;
import log.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.error("Blah Blah error", new ArithmeticException("abc"));
        logger.info("Information - 345678");
    }
}