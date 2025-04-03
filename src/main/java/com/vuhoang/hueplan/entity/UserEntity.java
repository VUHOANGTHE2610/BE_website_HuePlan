package com.vuhoang.hueplan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_ID;

    @Column(name = "user_Name")
    private String user_Name;

    @Column(name = "user_Password")
    private String user_Password;

    @Column(name = "user_Email")
    private String user_Email;

    @Column(name = "role")  // (client - Admin - cooperator)
    private String role;

    public UserEntity(){
        super();
    }

    public UserEntity(int user_ID, String user_Name, String user_Password, String user_Email, String role) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Email = user_Email;
        this.role = role;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_ID=" + user_ID +
                ", user_Name='" + user_Name + '\'' +
                ", user_Password='" + user_Password + '\'' +
                ", user_Email='" + user_Email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
