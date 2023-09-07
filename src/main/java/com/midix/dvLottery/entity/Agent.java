package com.midix.dvLottery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agents")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agent_id", nullable = false)
	private Long agentId;
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;
	@Column(name = "middle_name", nullable = false, length = 45)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;
	@Column(name = "agent_email", nullable = false, length = 45)
	private String agentEmail;
	@Column(name = "agent_phone_number", nullable = false, length = 45)
	private String agentPhoneNumber;
	@ManyToOne
	@JoinColumn(name = "dv_business_dv_business_id")
	private DvBusiness dvBusiness;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	public DvBusiness getDvBusiness() {
		return dvBusiness;
	}
	public void setDvBusiness(DvBusiness dvBusiness) {
		this.dvBusiness = dvBusiness;
	}
}
