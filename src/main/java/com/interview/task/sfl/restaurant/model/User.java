package com.interview.task.sfl.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.enums.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    String uUID;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    Set<RestaurantTable> restourantTables = new HashSet<>();

    @Enumerated(EnumType.STRING)
    UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUUID() {
        return uUID;
    }

    public void setUUID(String UUID) {
        this.uUID = UUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<RestaurantTable> getRestourantTables() {
        return restourantTables;
    }

    public void setRestourantTables(Set<RestaurantTable> restourantTables) {
        this.restourantTables = restourantTables;
    }

    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
