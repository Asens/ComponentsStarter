package cn.asens.dao;

import cn.asens.entity.User;

import java.util.List;

/**
 * Created by Asens on 2017/7/16
 */

public interface UserDao {
    void save(User user);

    User findByUsername(String name);

    List<User> getList();

    void update(User user);

    User findByEmail(String email);
}
