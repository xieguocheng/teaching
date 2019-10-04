package com.teaching.pojo;

import lombok.Data;

import javax.persistence.*;
@Data
public class District {
    @Id
    @Column(name = "district_id")
    private Integer districtId;

    private String name;

    @Column(name = "city_id")
    private Integer cityId;

    private Integer weight;

    /**
     * @return district_id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return city_id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}