package cn.asens.mng.impl;

import cn.asens.dao.UserDao;
import cn.asens.dao.UserRepository;
import cn.asens.entity.User;
import cn.asens.mng.UserMng;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2015/12/24.
 */

@Transactional
@Service
public class UserMngImpl implements UserMng {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
       return userRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        userRepository.insert(user);
    }

    @Override
    public List<User> getList() {
        return userRepository.selectAll();
    }

}
