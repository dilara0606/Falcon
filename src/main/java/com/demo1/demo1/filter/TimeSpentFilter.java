package com.demo1.demo1.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeSpentFilter {

    private Date date;
    private Integer times;
    private String userName;
    private String userSurname;
    private String projectName;
}
