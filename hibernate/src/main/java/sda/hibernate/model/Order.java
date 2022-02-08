package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ORD_DATE", columnDefinition="DATETIME")
    private Date date;
    @Column(name = "ORD_PRICE")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Cart",
            joinColumns = {@JoinColumn(name = "CRT_ORD_ID")}, // klucz obcy w tabeli CART - wskazujący na tabelę Order
            inverseJoinColumns = {@JoinColumn(name = "CRT_PRO_ID")}) // klucz obcy w tabeli CART - wskazujący na tabelę Product
    Set<Product> products;

}
