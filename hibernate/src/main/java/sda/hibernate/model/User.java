package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "`User`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USR_BIRTH_DATE", columnDefinition="DATETIME")
    private Date userBirthDate;
    @Column(name = "USR_EMAIL")
    private String userEmail;
    @Column(name = "USR_FIRSTNAME")
    private String userFirstName;
    @Column(name = "USR_LASTNAME")
    private String userLastName;
    @Column(name = "USR_PASSWORD")
    private String userPassword;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;

}
