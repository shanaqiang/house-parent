package com.shana.house.model;

import java.util.Date;

public class HouseImg {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.hiid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private Integer hiid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.hid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private Integer hid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.img
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private String img;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.description
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.createdate
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private Date createdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_houseimg.status
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.hiid
     *
     * @return the value of t_houseimg.hiid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public Integer getHiid() {
        return hiid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.hiid
     *
     * @param hiid the value for t_houseimg.hiid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setHiid(Integer hiid) {
        this.hiid = hiid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.hid
     *
     * @return the value of t_houseimg.hid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public Integer getHid() {
        return hid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.hid
     *
     * @param hid the value for t_houseimg.hid
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.img
     *
     * @return the value of t_houseimg.img
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.img
     *
     * @param img the value for t_houseimg.img
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.description
     *
     * @return the value of t_houseimg.description
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.description
     *
     * @param description the value for t_houseimg.description
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.createdate
     *
     * @return the value of t_houseimg.createdate
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.createdate
     *
     * @param createdate the value for t_houseimg.createdate
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_houseimg.status
     *
     * @return the value of t_houseimg.status
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_houseimg.status
     *
     * @param status the value for t_houseimg.status
     *
     * @mbg.generated Mon Nov 18 20:16:27 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}