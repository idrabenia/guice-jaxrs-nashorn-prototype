package idrabenia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String city;

    private Address() {

    }

    public Address(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        // not used
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        // not used
    }

    public Address withCity(String city) {
        return new Address(city);
    }

}
