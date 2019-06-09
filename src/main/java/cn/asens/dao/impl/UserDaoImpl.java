/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.asens.dao.impl;

import cn.asens.dao.UserDao;
import cn.asens.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }
    
    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }
    
    @Override
    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }
    
    @Override
    public Long insert(final User entity) {
        entityManager.persist(entity);
        return entity.getUserId();
    }
    
    @Override
    public void delete(final Long id) {
        Query query = entityManager.createQuery("DELETE FROM User o WHERE o.userId = ?1");
        query.setParameter(1, id.intValue());
        query.executeUpdate();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<User> selectAll() {
        return (List<User>) entityManager.createQuery("SELECT o FROM User o").getResultList();
    }

    @Override
    public User findByUsername(String name) {
        return (User)entityManager.createQuery("from User where username=:name")
                .setParameter("name",name)
                .getSingleResult();
    }
}
