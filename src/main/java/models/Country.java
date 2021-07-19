package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// This tells Hibernate to make a table out of this class
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String currency;
    private String country_code;
    private String currency_symbol;
    private String iso_code;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }

    public String getCurrencySymbol() {
        return currency_symbol;
    }

    public void setCurrencySymbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public String getIsoCode() {
        return iso_code;
    }

    public void setIsoCode(String iso_code) {
        this.iso_code = iso_code;
    }
}
