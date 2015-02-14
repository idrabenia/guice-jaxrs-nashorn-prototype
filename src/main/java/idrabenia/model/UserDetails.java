package idrabenia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 10/19/14.
 */
@Entity
@Table(name = "User")
@XmlRootElement
public class UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
