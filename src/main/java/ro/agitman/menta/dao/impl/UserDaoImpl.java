package ro.agitman.menta.dao.impl;

import org.mentabean.BeanSession;
import org.mentacontainer.example.BasicOperations;
import ro.agitman.menta.dao.UserDao;
import ro.agitman.menta.entity.User;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class UserDaoImpl implements UserDao {
    private final BeanSession beanSession;

    public UserDaoImpl(BeanSession beanSession) {
        this.beanSession = beanSession;
    }

    @Override
    public User findByEmail(String email) {
        User user = new User(email);
        return beanSession.loadUnique(user);
    }
}
