package ro.agitman.menta.action;

import org.mentawai.core.BaseAction;
import org.mentawai.mail.Letter;
import org.mentawai.mail.SimpleEmail;
import org.mentawai.mail.TextLetter;
import org.mentawai.rule.EmailRule;
import org.mentawai.rule.EqualRule;
import org.mentawai.rule.MethodRule;
import org.mentawai.rule.RegexRule;
import org.mentawai.validation.Validatable;
import org.mentawai.validation.Validator;
import ro.agitman.menta.dao.UserDao;
import ro.agitman.menta.entity.User;

import java.util.UUID;

/**
 * Created by gitmaal on 24/09/2015.
 */
public class RegisterAction extends BaseAction implements Validatable {

    private UserDao userDao;

    public RegisterAction(UserDao userDao) {
        this.userDao = userDao;
    }

    public String add() throws Exception {
        String username = input.getString("username");
        String password = input.getString("password");

        User user = new User();
        user.setEmail(username);
        user.setAlias(username.substring(0, username.indexOf("@")));
        user.setPassword(password);
        user.setToken(UUID.randomUUID().toString().substring(0,30));
        user.setConfirmed(false);

        userDao.save(user);
        setSessionObj(user);
        Letter welcome = new TextLetter("welcome.txt"); // <=== this can also be a HTML template file (welcome.html)
        welcome.setAttribute("username", user.getEmail());
        welcome.setAttribute("password", user.getPassword());
        try {

            String subject = welcome.getSubject(getSessionLocale());
            String body = welcome.getText(getSessionLocale());

            SimpleEmail.sendNow(user.getEmail(), user.getEmail(), subject, body); // <=== you can use HtmlEmail for HTML email message

        } catch (Exception e) {

            System.err.println("Error sending email to: " + user.getEmail());

            e.printStackTrace();
        }

        return SUCCESS;
    }

    @Override
    public void prepareValidator(Validator validator, String innerAction) {
        if (innerAction != null && innerAction.equals("add")) {
            validator.requiredFields("required_field", "username", "password", "confirmPassword"); // varargs for field names
            validator.add("confirmPassword", EqualRule.getInstance("password", "confirmPassword"), "pass_no_match"); // compare two fields to validate
            validator.add("username", EmailRule.getInstance(), "bad_email"); // validates using any regex
            validator.add("username", MethodRule.getInstance(this, "checkUsernameAdd"), "username_already_exists"); // call any action method to validate
        }
    }

    public Boolean checkUsernameAdd(String username) {
        return userDao.findByEmail(username) == null;
    }
}
