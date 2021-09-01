package com.crud.springboot.dao;

import org.springframework.stereotype.Repository;
import com.crud.springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user, long id) {
        User updatedUser = getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setCar(user.getCar());
        em.merge(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(getUserById(id));
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("select u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserByName(String name) {
        Query query = em.createQuery("select u from User u where u.name =: name");
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return em.find(User.class, user.getId());
    }
}