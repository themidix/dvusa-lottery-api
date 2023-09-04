package com.midix.dvLottery.entity;

import com.midix.dvLottery.entity.User;

import java.util.Date;
import javax.persistence.*;


@Entity
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agent_id", nullable = false)
	private Long agentId;
//
//	private String firstName;
//	private String middleName;
//	private String lastName;
//	private String agentEmail;
//	private String agentPhoneNumber;
//	@ManyToOne
//	@JoinColumn(name = "agent_id")
//	private Address agentAddress;
//
//	@ManyToOne
//	@JoinColumn(name = "dv_business_dv_business_id")
//	private DvBusiness dvBusiness;
//
//	@OneToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public DvBusiness getDvBusiness() {
//		return dvBusiness;
//	}
//
//	public void setDvBusiness(DvBusiness dvBusiness) {
//		this.dvBusiness = dvBusiness;
//	}
//
//	public Address getAgentAddress() {
//		return agentAddress;
//	}
//
//	public void setAgentAddress(Address agentAddress) {
//		this.agentAddress = agentAddress;
//	}
}
