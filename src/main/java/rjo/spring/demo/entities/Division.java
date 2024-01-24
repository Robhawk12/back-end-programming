package rjo.spring.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id",nullable = false)
    private Long id;

    @Column(name ="division")
    private String division_name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",nullable = false,updatable = false,insertable = false)
    private Country country;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "Country_ID")
    private long country_id;

    //@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JoinColumn(name = "customer_id")


    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
}
