package web.dao;

import org.springframework.stereotype.Repository;
import web.dao.interfaces.UserDao;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void update(long id, User user) {
        User userForUpdate = findById(id);
        userForUpdate = user;
        userForUpdate.setId(id);
        em.merge(userForUpdate);

    }
    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public List<User> findAll() {
        String hql = "select u from User u";
        Query query = em.createQuery(hql, User.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        em.remove(findById(id));
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByLogin(String login) {
        Query query = em.createQuery("select u from User u where u.login=:login")
                .setParameter("login", login);
        try {
            return (User) query.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}