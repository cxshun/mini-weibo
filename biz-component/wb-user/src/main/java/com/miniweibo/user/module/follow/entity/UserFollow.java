package com.miniweibo.user.module.follow.entity;

import java.util.Date;

public class UserFollow {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.target_user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Long targetUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.create_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.update_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_follow.is_deleted
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    private Byte isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.id
     *
     * @return the value of user_follow.id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.id
     *
     * @param id the value for user_follow.id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.user_id
     *
     * @return the value of user_follow.user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.user_id
     *
     * @param userId the value for user_follow.user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.target_user_id
     *
     * @return the value of user_follow.target_user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Long getTargetUserId() {
        return targetUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.target_user_id
     *
     * @param targetUserId the value for user_follow.target_user_id
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.create_time
     *
     * @return the value of user_follow.create_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.create_time
     *
     * @param createTime the value for user_follow.create_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.update_time
     *
     * @return the value of user_follow.update_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.update_time
     *
     * @param updateTime the value for user_follow.update_time
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_follow.is_deleted
     *
     * @return the value of user_follow.is_deleted
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_follow.is_deleted
     *
     * @param isDeleted the value for user_follow.is_deleted
     *
     * @mbg.generated Sat Sep 05 23:17:16 CST 2020
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}