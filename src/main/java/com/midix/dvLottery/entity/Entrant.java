package com.midix.dvLottery.entity;

import com.midix.dvLottery.models.User;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "entrants")
public class Entrant {
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

    @Basic
    @Column(name = "middle_name", nullable = false, length = 45)
    private String middleName;
    @Basic
    @Column(name = "gender", nullable = false, length = 64)
    private String gender;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrant entrant = (Entrant) o;
        return entrantId.equals(entrant.entrantId) && Objects.equals(firstName, entrant.firstName) && Objects.equals(lastName, entrant.lastName) && Objects.equals(middleName, entrant.middleName) &&  Objects.equals(gender, entrant.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrantId, firstName, lastName, middleName,gender);
    }

    public Entrant() {
    }

    public Entrant(Long entrantId, String firstName, String lastName, String middleName, String gender, User user) {
        this.entrantId = entrantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Entrant{" +
                "entrantId=" + entrantId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(Long entrantId) {
        this.entrantId = entrantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
