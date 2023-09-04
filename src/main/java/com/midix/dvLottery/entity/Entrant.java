package com.midix.dvLottery.entity;
import com.midix.dvLottery.constant.EducationLevel;
import com.midix.dvLottery.constant.Gender;
import com.midix.dvLottery.constant.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Entrants")
public class Entrant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrant_id", nullable = false)
    private Long entrantId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "middle_name", nullable = false, length = 45)
    private String middleName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 45)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false, length = 45)
    private Date birthDate;

    @Column(name = "birth_city", nullable = false, length = 45)
    private String birthCity;

    @Column(name = "country_of_birth", nullable = false, length = 45)
    private String countryOfBirth;

    @Column(name = " eligibility_country", nullable = false, length = 45)
    private String eligibilityCountry;

    @Column(name = "entrant_photograph", nullable = false, length = 45)
    private String entrantPhotograph;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Column(name = "country_of_residence", nullable = false, length = 45)
    private String countryOfResidence;

    @Column(name = "phone_number", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "email_address", nullable = false, length = 45)
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level", nullable = false, length = 45)
    private EducationLevel educationLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", nullable = false, length = 45)
    private MaritalStatus maritalStatus;

    @Column(name = "number_of_children", nullable = false, length = 45)
    private int numberOfChildren;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_spouse_id")
    private Spouse spouse;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_entrant_id")
    private Set<Child> childSet;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}

