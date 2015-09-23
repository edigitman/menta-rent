package ro.agitman.menta.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class Advert {

    public enum Currency{

    }

    public enum BuildingType{

    }

    private Long id;
    private String description;
    private BuildingType buildingType;
    private Date dateFrom;
    private Date dateUntil;
    private BigDecimal price;
    private BigDecimal deposit;
    private Boolean negotiable;
    private Currency currency;
    private Integer noRooms;
    private BigDecimal sqrm;
    private Long features;
    private Integer buildingYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(Date dateUntil) {
        this.dateUntil = dateUntil;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Boolean getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        this.negotiable = negotiable;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(Integer noRooms) {
        this.noRooms = noRooms;
    }

    public BigDecimal getSqrm() {
        return sqrm;
    }

    public void setSqrm(BigDecimal sqrm) {
        this.sqrm = sqrm;
    }

    public Long getFeatures() {
        return features;
    }

    public void setFeatures(Long features) {
        this.features = features;
    }

    public Integer getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(Integer buildingYear) {
        this.buildingYear = buildingYear;
    }
}
