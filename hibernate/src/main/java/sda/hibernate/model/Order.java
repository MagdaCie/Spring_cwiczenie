package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ORD DATE")
    private String date;
    @Column(name = "ORD_PRICE")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Cart",
            joinColumns = {@JoinColumn(name = "ORD_ID")}, // klucz obcy w tabeli CART - wskazujący na tabelę Order
            inverseJoinColumns = {@JoinColumn(name = "PRO_ID")}) // klucz obcy w tabeli CART - wskazujący na tabelę Product
    Set<Product> products;

}
