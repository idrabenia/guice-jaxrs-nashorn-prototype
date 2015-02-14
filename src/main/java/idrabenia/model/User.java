package idrabenia.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;


@Entity
@XmlRootElement
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "user_id")
    @BatchSize(size = 50)
    private Set<Address> addressList = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }

    public User withAddressList(List<Address> addressList) {
        this.addressList = new HashSet<>(addressList);
        return this;
    }

    public User withAddress(Address address) {
        addressList.add(address);
        return this;
    }
}
