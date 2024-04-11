package com.demo1.demo1.mapper;

import com.demo1.demo1.dto.TimeSpentDTO;
import com.demo1.demo1.entity.TimeSpent;

import java.util.ArrayList;
import java.util.List;

public class TimeSpentMapper {
    public static TimeSpentDTO convert(TimeSpent timeSpent) {
        return TimeSpentDTO.builder()
                .times(timeSpent.getTimes())
                .date(timeSpent.getDate())
                .usersProjectsDTO(UsersProjectsMapper.convert(timeSpent.getUsers_projects()))
                .build();
    }

    public static List<TimeSpentDTO> convertList(List<TimeSpent> timeSpentList ){
        List<TimeSpentDTO> timeSpentDTOList = new ArrayList<>();
        for (TimeSpent timeSpent : timeSpentList){
            timeSpentDTOList.add(convert(timeSpent));
        }
        return timeSpentDTOList;
    }

    public static TimeSpentDTO convertWithoutProjects(TimeSpent timeSpent) {
        return TimeSpentDTO.builder()
                .times(timeSpent.getTimes())
                .date(timeSpent.getDate())
                .build();
    }

    public static List<TimeSpentDTO> convertListWithoutProjects(List<TimeSpent> timeSpentList ){
        List<TimeSpentDTO> timeSpentDTOList = new ArrayList<>();
        for (TimeSpent timeSpent : timeSpentList){
            timeSpentDTOList.add(convertWithoutProjects(timeSpent));
        }
        return timeSpentDTOList;
    }
}
