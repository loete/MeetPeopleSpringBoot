package at.fh.swengs.meetpeople.model;

import at.fh.swengs.meetpeople.util.JsonDateDeserializer;
import at.fh.swengs.meetpeople.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Daniel on 20.12.2016.
 */

@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Temporal(TemporalType.DATE)
    private Date dayOfMessage;

    private String placeOfMessage;

    private String message;

    @ManyToOne
    private User user;

    @ManyToOne
    private Categories category;

    public Messages(){
    }

    public Messages(Date dayOfMessage, String placeOfMessage, String message) {
        this.dayOfMessage = dayOfMessage;
        this.placeOfMessage = placeOfMessage;
        this.message = message;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public Date getDayOfMessage() {return dayOfMessage;}

    public void setDayOfMessage(Date dayOfMessage) {this.dayOfMessage = dayOfMessage;}

    public String getPlaceOfMessage() {return placeOfMessage;}

    public void setPlaceOfMessage(String placeOfMessage) {this.placeOfMessage = placeOfMessage;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Categories getCategory() {return category;}

    public void setCategory(Categories category) {this.category = category;}
}

