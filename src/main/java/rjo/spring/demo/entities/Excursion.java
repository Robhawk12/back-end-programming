package rjo.spring.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@NoArgsConstructor
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id",nullable = false)
    private Long id;

    @Column(name ="excursion_title")
    private String excursion_title;

    @Column(name ="excursion_price")
    private BigDecimal excursion_price;

    @Column(name ="image_url")
    private String image_URL;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;


    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;
}
