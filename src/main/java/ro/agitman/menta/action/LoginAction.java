package ro.agitman.menta.action;

import org.mentacontainer.example.BasicOperations;
import org.mentawai.action.BaseLoginAction;
import ro.agitman.menta.dao.UserDao;
import ro.agitman.menta.entity.User;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class LoginAction extends BaseLoginAction {
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
        if(user!=null && password.equals(user.getPassword())){
            setSessionObj(user);
            return SUCCESS;
        }
        return ACCESSDENIED;
    }
}
