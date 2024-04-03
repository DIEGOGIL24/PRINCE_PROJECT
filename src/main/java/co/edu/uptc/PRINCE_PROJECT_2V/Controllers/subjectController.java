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


import co.edu.uptc.PRINCE_PROJECT_2V.Dtos.subjectDto;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.subject;
import co.edu.uptc.PRINCE_PROJECT_2V.Services.subjectService;

@RestController
@RequestMapping("/subjects")
public class subjectController {
    private subjectService subjectService=new subjectService();

    

    @PostMapping("/add")
    public ResponseEntity<Object> addSubject(@RequestBody subjectDto subDt) {
        try {
            subjectDto.validSubject(subDt);
            subjectService.addSubject(subjectDto.fromsubjectdto(subDt));
            return ResponseEntity.status(HttpStatus.OK).body(subDt);
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllSubjects() {
        List<subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(subjects);
    }


    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Object> deleteSubject(@PathVariable String code) {
        try {
            subjectService.deleteSubject(code);
            return ResponseEntity.status(HttpStatus.OK).body("Subject with code " + code + " deleted successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<Object> updateSubject(@PathVariable String code, @RequestBody subjectDto newData) {
        try {
            subjectService.updateSubject(code, subjectDto.fromsubjectdto(newData));
            return ResponseEntity.status(HttpStatus.OK).body("Subject with code " + code + " updated successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }
}

