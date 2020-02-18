package com.longgroup.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

  private static final long serialVersionUID = 1L;

  private long id;
  private String username;
  private String password;
  private String createtime;
  private long status;

}
