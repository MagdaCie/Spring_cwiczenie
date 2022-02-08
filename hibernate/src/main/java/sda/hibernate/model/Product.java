package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private int id;
    @Column(name = "PRO DESCRIPTION")
    private String description;
    @Column(name = "PRO NAME")
    private String productName;
    @Column(name = "PRO PRICE")
    private BigDecimal productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRO_CAT_ID", referencedColumnName = "CAT_ID")
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    Set<Order> orders;
}
