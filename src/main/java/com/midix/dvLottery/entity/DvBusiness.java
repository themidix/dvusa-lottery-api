package com.midix.dvLottery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dv_businesses")
public class DvBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dv_business_id", nullable = false)
    private Long dvBusinessId;
    private String businessName;
    @Basic
    @Column(name = "business_address", nullable = false, length = 45)
    private String businessAddress;
    @Basic
    @Column(name = "business_email", nullable = false, length = 45)
    private String businessEmail;
    @Basic
    @Column(name = "business_phone_number", nullable = false, length = 45)
    private String businessPhoneNumber;
}
