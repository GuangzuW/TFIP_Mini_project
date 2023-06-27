package ibf.miniproject.ecommerce.model;

import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

public class Address {
    private Integer id;
    private String blockNumber;
    private String streetName;
    private String unitNumber;
    private String country;
    private Integer postCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Orders orders;


    public Address() {
    }

    public Address(Integer id, String blockNumber, String streetName, String unitNumber, String country, Integer postCode) {
        this.id = id;
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.unitNumber = unitNumber;
        this.country = country;
        this.postCode = postCode;
    }

    public Address(String blockNumber, String streetName, String unitNumber, String country, Integer postCode) {
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.unitNumber = unitNumber;
        this.country = country;
        this.postCode = postCode;
    }

    public Address(Integer id, String blockNumber, String streetName, String unitNumber, String country, Integer postCode, Orders orders) {
        this.id = id;
        this.blockNumber = blockNumber;
        this.streetName = streetName;
        this.unitNumber = unitNumber;
        this.country = country;
        this.postCode = postCode;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }
    
    public Orders getOrders() {
        return orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

}
