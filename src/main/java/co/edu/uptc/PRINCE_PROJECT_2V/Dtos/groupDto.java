package co.edu.uptc.PRINCE_PROJECT_2V.Dtos;

import java.util.List;

import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.group;
import lombok.Data;

@Data
public class groupDto {
    private String id;
    private String subjectCode;
    private String placeId;
    private UptcList<String> schedules;


    public static groupDto fromGroup(group group) {
        groupDto groupDto = new groupDto();
        groupDto.setId(group.getId());
        groupDto.setSubjectCode(group.getSubjectCode());
        groupDto.setPlaceId(group.getPlaceId());
        groupDto.setSchedules(group.getSchedules());
        return groupDto;
    }

    public static List<groupDto> fromGroups(List<group> groups) {
        List<groupDto> groupDtos = new UptcList<>();
        for (group group : groups) {
            groupDtos.add(groupDto.fromGroup(group));
        }
        return groupDtos;
    }

    public static group formGroupDto(groupDto groupDto) {
        group group = new group();
        group.setId(groupDto.getId());
        group.setSubjectCode(groupDto.getSubjectCode());
        group.setPlaceId(groupDto.getPlaceId());
        group.setSchedules(groupDto.getSchedules());
        return group;
    }

    public static void validateGroup(groupDto groupDto) throws ProjectExeption {
        if (groupDto.getId() == null || 
            groupDto.getSubjectCode() == null || 
            groupDto.getPlaceId() == null || 
            groupDto.getSchedules() == null || 
            groupDto.getSchedules().isEmpty()) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        }
    }
}
