package at.fh.swengs.meetpeople.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniel on 20.12.2016.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String place;

    private String email; // (kein pflichtfeld)

    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<Messages> messages;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password, String place, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.place = place;
        this.email = email;
    }

    public long getUser_id() {return user_id;}

    public void setUser_id(long id) {this.user_id = user_id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getPlace() {return place;}

    public void setPlace(String place) {this.place = place;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public List<Messages> getMessages() {return messages;}

    public void setMessages(List<Messages> messages) {this.messages = messages;}
}