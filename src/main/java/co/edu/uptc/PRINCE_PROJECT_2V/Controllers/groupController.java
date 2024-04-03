package co.edu.uptc.PRINCE_PROJECT_2V.Controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Dtos.groupDto;
import co.edu.uptc.PRINCE_PROJECT_2V.Dtos.subjectDto;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.group;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.subject;
import co.edu.uptc.PRINCE_PROJECT_2V.Services.groupService;


@RestController
@RequestMapping("/groups")
public class groupController {
    private groupService groupService=new groupService();

    

    @PostMapping("/add")
    public ResponseEntity<Object> addGroup(@RequestBody groupDto groupDt) {
        try {
            groupDto.validateGroup(groupDt);
            groupService.addGroup(groupDto.formGroupDto(groupDt));
            return ResponseEntity.status(HttpStatus.OK).body(groupDt);
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllGroups() {
        List<group> groups = groupService.getAllGroups();
        return ResponseEntity.status(HttpStatus.OK).body(groupDto.fromGroups(groups));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteGroup(@PathVariable String id) {
        try {
            groupService.deleteGroup(id);
            return ResponseEntity.status(HttpStatus.OK).body("Group with ID " + id + " deleted successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateGroup(@PathVariable String id, @RequestBody groupDto newData) {
        try {
            groupService.updateGroup(id, groupDto.formGroupDto(newData));
            return ResponseEntity.status(HttpStatus.OK).body("Group with ID " + id + " updated successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }


    @GetMapping("/samePlaceQuery/{placeId}")
    public ResponseEntity<Object> getSubjectsByPlaceId(@PathVariable String placeId) {
        List<subject> subjects = groupService.samePlaceQuery(placeId);
        return ResponseEntity.ok(subjectDto.fromSubjects(subjects));
    }


    @GetMapping("/sameScheduleQuery")
    public ResponseEntity<Object> getSubjectsBySchedule(@RequestBody UptcList<String> schedule) {
        List<subject> subjects=groupService.sameScheduleQuery(schedule);
        return ResponseEntity.ok(subjectDto.fromSubjects(subjects));
    }


    @GetMapping("/multipleGroups")
    public ResponseEntity<Object> getSubjectsWithMultipleGroups() {
        List<subject> subjects = groupService.getMore1();
        return ResponseEntity.ok(subjectDto.fromSubjects(subjects));
}
    
}
