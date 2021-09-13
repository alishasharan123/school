package com.example.demoSpringBoot;

import javax.persistence.*;

@Entity
@Table(name="marks")
//@IdClass(MarksKey.class)
public class MarkDTO {


    @Id
    String sid;
    @Column
    private String testno;
    @Column
    private String m1;
    @Column
    private String m2;
    @Column
    private String m3;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }
}

