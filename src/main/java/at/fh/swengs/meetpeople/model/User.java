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
    private String adress;
    private int plz;
    private String place;

    private String email; // (kein pflichtfeld)
    private String telefon; //(kein pflichtfeld)

    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<Messages> messages;

    public User() {
    }

    public User(String firstName, String lastName, String adress, int plz, String place, String email, String telefon) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.plz = plz;
        this.place = place;
        this.email = email;
        this.telefon = telefon;
    }

    public long getUser_id() {return user_id;}

    public void setUser_id(long id) {this.user_id = user_id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getAdress() {return adress;}

    public void setAdress(String adress) {this.adress = adress;}

    public int getPlz() {return plz;}

    public void setPlz(int plz) {this.plz = plz;}

    public String getPlace() {return place;}

    public void setPlace(String place) {this.place = place;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getTelefon() {return telefon;}

    public void setTelefon(String telefon) {this.telefon = telefon;}

    public List<Messages> getMessages() {return messages;}

    public void setMessages(List<Messages> messages) {this.messages = messages;}
}