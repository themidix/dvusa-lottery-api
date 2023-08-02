package com.midix.dvLottery.entity;

import com.midix.dvLottery.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrant_id", nullable = false)
    private Long child_id;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Entrant entrant;

}
