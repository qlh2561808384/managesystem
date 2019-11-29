package com.longgroup.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information implements Serializable {

  private static final long serialVersionUID = 1L;

  private long id;
  private String address;
  private String hobby;
  private long idUsers;
  private String sex;

}
