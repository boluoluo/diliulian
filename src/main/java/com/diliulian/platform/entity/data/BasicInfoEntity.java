/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.diliulian.platform.entity.data;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TManager entity. @author MyEclipse Persistence Tools
 */
@Table(name = "basic_info")
public class BasicInfoEntity implements java.io.Serializable {
    @Transient
    private static final long serialVersionUID = 8828442426459020690L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer regno;
    private String credit_code;
    private String tax_code;
    private String organization_code;
    private String entname;
    private int entstatus;
    private String area;
    private String legalperson;
    private String id_card;

    private String enttype;
    private String regcap;
    private String dom;
    private Date esdate;

    private String opfrom; //varchar
    private String opto; // varchar(5
    private String opscope; // varcha
    private String regorg; // varchar
    private String apprdate; // varch
    private int good_count; // int
    private int bad_count; // int(
    private int dishonesty_coun;
    private int xk_count; // int(1
    private int cf_count; // int(1
    private int other_count; // in
    private int rank; // int(10) N
    private String md5; // varchar(60
    private String candate; // varcha
    private String revdate; // varcha
    private int source; // tinyint
    private int solr_status; // ti
    private String valid_time; // var
    private Date sys_update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegno() {
        return regno;
    }

    public void setRegno(Integer regno) {
        this.regno = regno;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public String getOrganization_code() {
        return organization_code;
    }

    public void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }

    public String getEntname() {
        return entname;
    }

    public void setEntname(String entname) {
        this.entname = entname;
    }

    public int getEntstatus() {
        return entstatus;
    }

    public void setEntstatus(int entstatus) {
        this.entstatus = entstatus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getEnttype() {
        return enttype;
    }

    public void setEnttype(String enttype) {
        this.enttype = enttype;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public Date getEsdate() {
        return esdate;
    }

    public void setEsdate(Date esdate) {
        this.esdate = esdate;
    }

    public String getOpfrom() {
        return opfrom;
    }

    public void setOpfrom(String opfrom) {
        this.opfrom = opfrom;
    }

    public String getOpto() {
        return opto;
    }

    public void setOpto(String opto) {
        this.opto = opto;
    }

    public String getOpscope() {
        return opscope;
    }

    public void setOpscope(String opscope) {
        this.opscope = opscope;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public String getApprdate() {
        return apprdate;
    }

    public void setApprdate(String apprdate) {
        this.apprdate = apprdate;
    }

    public int getGood_count() {
        return good_count;
    }

    public void setGood_count(int good_count) {
        this.good_count = good_count;
    }

    public int getBad_count() {
        return bad_count;
    }

    public void setBad_count(int bad_count) {
        this.bad_count = bad_count;
    }

    public int getDishonesty_coun() {
        return dishonesty_coun;
    }

    public void setDishonesty_coun(int dishonesty_coun) {
        this.dishonesty_coun = dishonesty_coun;
    }

    public int getXk_count() {
        return xk_count;
    }

    public void setXk_count(int xk_count) {
        this.xk_count = xk_count;
    }

    public int getCf_count() {
        return cf_count;
    }

    public void setCf_count(int cf_count) {
        this.cf_count = cf_count;
    }

    public int getOther_count() {
        return other_count;
    }

    public void setOther_count(int other_count) {
        this.other_count = other_count;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}