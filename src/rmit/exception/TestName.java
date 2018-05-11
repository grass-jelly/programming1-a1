package rmit.exception;

public class TestName {
    public static boolean getName(String s) throws NameException {

        if (s.trim().length() == 0) {
            throw new NameException("Can not enter blank input!!");
        } else if (!s.matches("[a-zA-Z][a-zA-Z ]*")) {
            throw new NameException("Invalid name!");
        }
        return true;
    }
}
