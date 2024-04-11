package com.demo1.demo1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersProjectsDTO {
    private UserDTO userDTO;
    private ProjectDTO projectDTO;
    private List<TimeSpentDTO> timeSpentList;
}
