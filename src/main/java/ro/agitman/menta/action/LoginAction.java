package ro.agitman.menta.action;

import org.mentacontainer.example.BasicOperations;
import org.mentawai.action.BaseLoginAction;
import org.mentawai.rule.EmailRule;
import org.mentawai.rule.EqualRule;
import org.mentawai.rule.MethodRule;
import org.mentawai.validation.Validatable;
import org.mentawai.validation.Validator;
import ro.agitman.menta.dao.UserDao;
import ro.agitman.menta.entity.User;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class LoginAction extends BaseLoginAction implements Validatable {
    private final UserDao userDAO;

    public LoginAction(UserDao userDao) {
        this.userDAO = userDao;
    }

    public String execute() throws Exception {
        String username = input.getString("username");
        String password = input.getString("password");

        if (username == null || username.trim().equals("")) {
            return ERROR;
        }

        if (password == null || password.trim().equals("")) {
            return ERROR;
        }

        User user = userDAO.findByEmail(username);
        if (user != null && password.equals(user.getPassword())) {
            setSessionObj(user);
            output.setObject(user);
            return SUCCESS;
        }
        addError("access_denied");

        return ACCESSDENIED;
    }

    @Override
    public void prepareValidator(Validator validator, String innerAction) {
        validator.requiredFields("required_field", "username", "password"); // varargs for field names
        validator.add("username", EmailRule.getInstance(), "bad_email"); // validates using any regex
    }
}
