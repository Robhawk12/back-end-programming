package rjo.spring.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="division")
    private String division_name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    public Division() {
    }

    public Division(Long id, String division_name, Country country, Date create_date, Date last_update) {
        this.id = id;
        this.division_name = division_name;
        this.country = country;
        this.create_date = create_date;
        this.last_update = last_update;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
