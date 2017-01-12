package at.fh.swengs.meetpeople.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniel on 20.12.2016.
 */

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String categoryName;

    @OneToMany(mappedBy = "category",orphanRemoval = true)
    private List<Messages> messages;

    public Categories(){
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {this.categoryName = categoryName;}

    public List<Messages> getMessages() {return messages;}

    public void setMessages(List<Messages> messages) {this.messages = messages;}
}
