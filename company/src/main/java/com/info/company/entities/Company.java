package com.info.company.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Table(name = "Company")
@Entity
@Data
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "Company name cannot be NULL")
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    @NotNull(message = "contact info cannot be NULL")
    private long contact;
    
    private String bussinessType;
    private String currencysymbol;
    
    
    @Column(unique = true, length = 100, nullable = false)
    @Email(message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be NULL")
    private String email;
    
    private String address;
    private Boolean enablecompanypassword;
    private Boolean enableWarehousing;
    private Boolean enableManifacturing;
    private Boolean enable_GST;
    private Boolean enablecmposition_scheme;
    private Boolean taxrate;
    private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getBussinessType() {
		return bussinessType;
	}
	public void setBussinessType(String bussinessType) {
		this.bussinessType = bussinessType;
	}
	public String getCurrencysymbol() {
		return currencysymbol;
	}
	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getEnablecompanypassword() {
		return enablecompanypassword;
	}
	public void setEnablecompanypassword(Boolean enablecompanypassword) {
		this.enablecompanypassword = enablecompanypassword;
	}
	public Boolean getEnableWarehousing() {
		return enableWarehousing;
	}
	public void setEnableWarehousing(Boolean enableWarehousing) {
		this.enableWarehousing = enableWarehousing;
	}
	public Boolean getEnableManifacturing() {
		return enableManifacturing;
	}
	public void setEnableManifacturing(Boolean enableManifacturing) {
		this.enableManifacturing = enableManifacturing;
	}
	public Boolean getEnable_GST() {
		return enable_GST;
	}
	public void setEnable_GST(Boolean enable_GST) {
		this.enable_GST = enable_GST;
	}
	public Boolean getEnablecmposition_scheme() {
		return enablecmposition_scheme;
	}
	public void setEnablecmposition_scheme(Boolean enablecmposition_scheme) {
		this.enablecmposition_scheme = enablecmposition_scheme;
	}
	public Boolean getTaxrate() {
		return taxrate;
	}
	public void setTaxrate(Boolean taxrate) {
		this.taxrate = taxrate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Company(long id, String name, String country, long contact, String bussinessType, String currencysymbol,
			String email, String address, Boolean enablecompanypassword, Boolean enableWarehousing,
			Boolean enableManifacturing, Boolean enable_GST, Boolean enablecmposition_scheme, Boolean taxrate,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.contact = contact;
		this.bussinessType = bussinessType;
		this.currencysymbol = currencysymbol;
		this.email = email;
		this.address = address;
		this.enablecompanypassword = enablecompanypassword;
		this.enableWarehousing = enableWarehousing;
		this.enableManifacturing = enableManifacturing;
		this.enable_GST = enable_GST;
		this.enablecmposition_scheme = enablecmposition_scheme;
		this.taxrate = taxrate;
		this.password = password;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", country=" + country + ", contact=" + contact
				+ ", bussinessType=" + bussinessType + ", currencysymbol=" + currencysymbol + ", email=" + email
				+ ", address=" + address + ", enablecompanypassword=" + enablecompanypassword + ", enableWarehousing="
				+ enableWarehousing + ", enableManifacturing=" + enableManifacturing + ", enable_GST=" + enable_GST
				+ ", enablecmposition_scheme=" + enablecmposition_scheme + ", taxrate=" + taxrate + ", password="
				+ password + "]";
	}
    
    
}