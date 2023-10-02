package com.midix.dvLottery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false, length = 45)
    private Long addressId;
    @Basic
    @Column(name = "in_care_of", nullable = false, length = 45)
    private String inCareOf;
    @Basic
    @Column(name = "address_line1", nullable = false, length = 45)
    private String addressLine1;
    @Basic
    @Column(name = "address_line2", nullable = false, length = 45)
    private String addressLine2;

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Basic
    @Column(name = "district", nullable = false, length = 45)
    private String district;

    @Basic
    @Column(name = "postal_code", nullable = false, length = 45)
    private String postalCode;

    @Basic
    @Column(name = "country", nullable = false, length = 45)
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrant_id")
    private Entrant entrant;
}

