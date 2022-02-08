package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USR BIRTH DATE")
    private String userBirthDate;
    @Column(name = "USR EMAIL")
    private String userEmail;
    @Column(name = "USR FIRSTNAME")
    private String userFirstName;
    @Column(name = "USR LASTNAME")
    private String userLastName;
    @Column(name = "USR PASSWORD")
    private String userPassword;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;

}
