package com.longgroup.managesystem.domain;


public class Information {

  private long id;
  private String address;
  private String hobby;
  private long idUsers;
  private String sex;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }


  public long getIdUsers() {
    return idUsers;
  }

  public void setIdUsers(long idUsers) {
    this.idUsers = idUsers;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

}
