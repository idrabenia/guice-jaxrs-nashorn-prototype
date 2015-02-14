package idrabenia.service;

import idrabenia.infrastructure.hibernate.UserDao;
import idrabenia.model.Address;
import idrabenia.model.User;

import javax.inject.Inject;

import static java.lang.String.format;


public class HelloService {
    private final UserDao userDao;

    @Inject
    public HelloService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String sayHello(String name) {
        userDao.save(
            new User()
                .withFirstName(name)
                .withLastName(name)
                .withAddress(
                    new Address("Minsk")
                )
                .withAddress(
                    new Address("Grodno")
                )
        );

        return format("Hello, %s!!!", name);
    }

}
