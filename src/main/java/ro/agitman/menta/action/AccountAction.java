package ro.agitman.menta.action;

import org.mentawai.core.BaseAction;
import ro.agitman.menta.entity.User;

/**
 * Created by gitmaal on 24/09/2015.
 */
public class AccountAction extends BaseAction {

    public String nav() {

        User user = getUserSession();
        output.setObject(user);

        return SUCCESS;
    }

}
