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

    private String firstName;
    private String lastName;
    private String address;
    private int plz;
    private String place;

    private String email; // (kein pflichtfeld)
    private String telephone; //(kein pflichtfeld)

    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<Messages> messages;

    public User() {
    }

    public User(String firstName, String lastName, String address, int plz, String place, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.plz = plz;
        this.place = place;
        this.email = email;
        this.telephone = telephone;
    }

    public long getUser_id() {return user_id;}

    public void setUser_id(long id) {this.user_id = user_id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public int getPlz() {return plz;}

    public void setPlz(int plz) {this.plz = plz;}

    public String getPlace() {return place;}

    public void setPlace(String place) {this.place = place;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getTelephone() {return telephone;}

    public void setTelephone(String telephone) {this.telephone = telephone;}

    public List<Messages> getMessages() {return messages;}

    public void setMessages(List<Messages> messages) {this.messages = messages;}
}