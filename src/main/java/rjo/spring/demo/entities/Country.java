package rjo.spring.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private  String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<Division> divisions;

    public Country() {
    }

    public Country(Long id, String country_name, Date create_date, Date last_update, Set<Division> divisions) {
        this.id = id;
        this.country_name = country_name;
        this.create_date = create_date;
        this.last_update = last_update;
        this.divisions = divisions;
    }
}
