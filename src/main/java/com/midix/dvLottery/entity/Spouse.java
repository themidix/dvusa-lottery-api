package com.midix.dvLottery.entity;

import com.midix.dvLottery.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "spouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spouse_id", nullable = false)
    private Long spouse_id;
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

    @Column(name = "entrant_photograph", nullable = false, length = 45)
    private String entrantPhotograph;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "entrant_id", referencedColumnName = "entrant_id", nullable = false)
    private Entrant entrant;
}
