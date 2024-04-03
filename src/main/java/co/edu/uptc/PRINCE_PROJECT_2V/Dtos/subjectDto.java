package co.edu.uptc.PRINCE_PROJECT_2V.Dtos;


import java.util.List;



import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.subject;
import lombok.Data;

@Data
public class subjectDto {
    private String name;
    private String code;



   public static subjectDto fromSubject(subject subject) {
        subjectDto subjectDto = new subjectDto();
        subjectDto.setName(subject.getName());
        subjectDto.setCode(subject.getCode());
        return subjectDto;
    }

    public static List<subjectDto> fromSubjects(List<subject> subjects) {
        List<subjectDto> subjectDtos = new UptcList<subjectDto>();
        for (subject subject : subjects) {
            subjectDtos.add(subjectDto.fromSubject(subject));
        }
        return subjectDtos;
    }

    public static subject fromsubjectdto(subjectDto subjectDto) {
        subject subject = new subject();
        subject.setName(subjectDto.getName());
        subject.setCode(subjectDto.getCode());
        return subject;
    }



    public static void validSubject(subjectDto subDt) throws ProjectExeption { 
        if (subDt.getName() == null || 
        subDt.getCode() == null) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        }
        
    }

}
