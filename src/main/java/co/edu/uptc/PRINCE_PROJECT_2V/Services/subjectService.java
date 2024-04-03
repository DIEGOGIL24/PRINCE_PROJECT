package co.edu.uptc.PRINCE_PROJECT_2V.Services;

import java.util.List;


import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.subject;


public class subjectService {

    private List<subject> subjects = new UptcList<>();

    private boolean verifyExists(String code) {
        for (subject subject : subjects) {
            if (subject.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public void addSubject(subject data) throws ProjectExeption {
        if (verifyExists(data.getCode())) {
            throw new ProjectExeption(TypeMessage.ELEMENT_ALRREADY_EXIST);
        } else {
            subjects.add(data);
        }
    }

    public List<subject> getAllSubjects() {
        for (subject subject : subjects) {
            System.out.println(subject);
        }
        return subjects;
    }


    public subject getSubjectsbyCode(String id){
        for (subject subje : subjects) {
            if (subje.getCode().equals(id)) {
                return subje;
            }
        }
        return null;
        
        
    }
    public void deleteSubject(String code) throws ProjectExeption {
        boolean found = false;
        for (subject subject : subjects) {
            if (subject.getCode().equals(code)) {
                subjects.remove(subject);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }

    public void updateSubject(String code, subject newData) throws ProjectExeption {
        boolean found = false;
        for (subject subject : subjects) {
            if (subject.getCode().equals(code)) {
                subjects.remove(subject);
                subjects.add(newData);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }
    


}
