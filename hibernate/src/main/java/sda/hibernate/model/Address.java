package sda.hibernate.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_ID")
    private int id;
    @Column(name = "CO_STREET")
    private String street;
    @Column(name = "CO_BUILDING_NO")
    private String buildingNo;
    @Column(name = "CO_APARTMENT_NO")
    private String apartmentNo;
    @Column(name = "CO_CITY")
    private String city;
    @Column(name = "CO_POSTAL_CODE")
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
    private Country country;

}
