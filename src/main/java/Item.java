import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Item {
    private Long id;
    private String name;
    private Date dateCreated;
    private Date lastUpdateDate;
    private String description;

    public Item() {
    }

    @Id
    @SequenceGenerator(name = "I_SEQ" , sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "I_SEQ")
    @Column(name = "ID")
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Column(name = "DATE_CREATED")
    @JsonProperty("dateCreated")
    public Date getDateCreated() {
        return dateCreated;
    }

    @Column(name = "DATE_LAST_UPDATE")
    @JsonProperty("lastUpdateDate")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Column(name = "DESCRIPTION")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdateDate=" + lastUpdateDate +
                ", description='" + description + '\'' +
                '}';
    }
}
