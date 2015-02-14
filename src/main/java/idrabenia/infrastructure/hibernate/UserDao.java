package idrabenia.infrastructure.hibernate;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import idrabenia.model.User;
import idrabenia.model.UserDetails;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Singleton
public class UserDao {
    private final Provider<EntityManager> entityManager;

    @Inject
    public UserDao(Provider<EntityManager> entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public User save(User user) {
        entityManager.get().persist(user);
        return user;
    }

    public List<User> findAll() {
        List<User> users = entityManager
                .get()
                .createQuery("select u from User u", User.class)
                .getResultList();

        return users;
    }

    public List<UserDetails> findAllDetails() {
        List<UserDetails> users = entityManager
                .get()
                .createQuery("select u from UserDetails u", UserDetails.class)
                .getResultList();

        return users;
    }

    public List<User> findAll_flat() {
        List<User> users = entityManager
                .get()
                .createNativeQuery("select u.* from User u", User.class)
                .getResultList();

        return users;
    }

}
