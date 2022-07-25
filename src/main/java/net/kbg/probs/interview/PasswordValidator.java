package net.kbg.probs.interview;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public PasswordValidator() { }

    /**
     * The password ...
     *      * has a minimum length of 8 characters
     *      * Must contain at least 1 upper-case letter
     *      * Must contain at least 1 lower-case letter
     *      * Must contain at least 1 number
     *      * Must contain at least 1 special character from this group (#, ?, !)
     *      * Can't contain the username
     *      * Can't re-use previous passwords
     */
    public boolean isValidPassword(String password, List<String> forbidden) {
        if (password == null || forbidden == null || forbidden.size() < 2) {
            throw new IllegalArgumentException("Please check your arguments for nullity or invalid size.");
        }
        Pattern p = Pattern.compile("^(?=.*[A-Z]])(?=.*[a-z])(?=.*\\d)(?=.*[#?!])[A-Za-z\\d#?!]{8,}$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public boolean isValidPasswordSimple(String password, List<String> forbidden) {
        if (password == null || forbidden == null || forbidden.size() < 2) {
            throw new IllegalArgumentException("Please check your arguments for nullity or invalid size.");
        }
        Matcher mlow = Pattern.compile("[a-z]").matcher(password);
        Matcher mup = Pattern.compile("[A-Z]").matcher(password);
        Matcher mnum = Pattern.compile("\\d").matcher(password);
        Matcher mspec = Pattern.compile("[#?!]").matcher(password);
        return password.length() >= 8 &&
                mlow.find() &&
                mup.find() &&
                mnum.find() &&
                mspec.find();
    }

}
