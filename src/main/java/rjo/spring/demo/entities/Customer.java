package rjo.spring.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last")
    private String lastName;

    @Column(name ="adress")
    private String address;

    @Column(name ="postal_code")
    private String postal_code;

    @Column(name ="phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Cart> carts;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String address, String postal_code, String phone, Division division, Set<Cart> carts, Date create_date, Date last_update) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = division;
        this.carts = carts;
        this.create_date = create_date;
        this.last_update = last_update;
    }
}
