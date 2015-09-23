package ro.agitman.menta.dao;

import ro.agitman.menta.entity.User;

/**
 * Created by gitmaal on 23/09/2015.
 */
public interface UserDao {

    User findByEmail(String email);
}
