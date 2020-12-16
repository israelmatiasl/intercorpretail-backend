package com.intercorpretail.customers.core.dtos;

import java.util.Date;

public class CustomerDto {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Date birthdate;
    private Date deathdate;

    public CustomerDto() {}

    public CustomerDto(Integer id, String name, String surname, Integer age, Date birthdate, Date deathdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Date deathdate) {
        this.deathdate = deathdate;
    }
}
