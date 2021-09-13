package com.example.demoSpringBoot;

import org.springframework.stereotype.Component;

import javax.persistence.*;
//@Component
@Entity
@Table(name="sdetails")
public class StudentDTo {
    @Id
   // @GeneratedValue  //Automatically increments by 1
    private String sid;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column(name="dob")  //Incase the variable name in table is different
    private String db1;
    @Column
    private String address;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDb1() {
        return db1;
    }

    public void setDb1(String db1) {
        this.db1 = db1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

