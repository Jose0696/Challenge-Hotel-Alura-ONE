package model;

import java.sql.Date;

public class Reserve {

    private Integer id;
    private String nameI;
    private String lastname;
    private Integer age;
    private Long telephone;
    private String country;
    private Date admisionDate;
    private Date exitDate;
    private String valueI;
    private String payWay;

    public Reserve(String nameI, String lastname, Integer age, Long telephone, String country, Date admisionDate,
                   Date exitDate, String valueI, String payWay) {
        super();
        this.nameI = nameI;
        this.lastname = lastname;
        this.age = age;
        this.telephone = telephone;
        this.country = country;
        this.admisionDate = admisionDate;
        this.exitDate = exitDate;
        this.valueI = valueI;
        this.payWay = payWay;
    }

    public Reserve(Integer id, String nameI, String lastname, Integer age, Long telephone, String country,
                   Date admisionDate, Date exitDate, String valueI, String payWay) {
        super();
        this.id = id;
        this.nameI = nameI;
        this.lastname = lastname;
        this.age = age;
        this.telephone = telephone;
        this.country = country;
        this.admisionDate = admisionDate;
        this.exitDate = exitDate;
        this.valueI = valueI;
        this.payWay = payWay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameI() {
        return nameI;
    }

    public void setNameI(String nameI) {
        this.nameI = nameI;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getAdmisionDate() {
        return admisionDate;
    }

    public void setAdmisionDate(Date admisionDate) {
        this.admisionDate = admisionDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getValueI() {
        return valueI;
    }

    public void setValueI(String valueI) {
        this.valueI = valueI;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}