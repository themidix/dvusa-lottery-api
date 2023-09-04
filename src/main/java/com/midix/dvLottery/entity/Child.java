package com.midix.dvLottery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id", nullable = false)
    private Long childId;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Basic
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

    @Column(name = "child_photo", nullable = false, length = 45)
    private String childPhoto;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "entrant_id")
//    @JsonBackReference
//    private Entrant entrant;
}
