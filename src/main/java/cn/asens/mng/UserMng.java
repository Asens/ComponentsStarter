package cn.asens.mng;

import cn.asens.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2015/12/24.
 */
public interface UserMng {

    User findByName(String name);

    void save(User user);

    List<User> getList();
}
