package com.edu.bean;

public class Country {
    private Integer cId;

    private String cCountryname;

    private String cCapital;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcCountryname() {
        return cCountryname;
    }

    public void setcCountryname(String cCountryname) {
        this.cCountryname = cCountryname == null ? null : cCountryname.trim();
    }

    public String getcCapital() {
        return cCapital;
    }

    public void setcCapital(String cCapital) {
        this.cCapital = cCapital == null ? null : cCapital.trim();
    }
}