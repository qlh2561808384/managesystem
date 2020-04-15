package com.longgroup.managesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Upload implements Serializable {

  private static final long serialVersionUID = 1L;

  private long id;
  private String upuser;
  private String uptime;
  private String imgpath;


}
