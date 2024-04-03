package co.edu.uptc.PRINCE_PROJECT_2V.Services;

import java.util.List;


import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.group;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.subject;


public class groupService {

    private final UptcList<group> groups = new UptcList<>();
    subjectService subjectService=new subjectService();
    

    private boolean verifyExists(String id) {
        for (group group : groups) {
            if (group.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addGroup(group data) throws ProjectExeption {
        if (verifyExists(data.getId())) {
            throw new ProjectExeption(TypeMessage.ELEMENT_ALRREADY_EXIST);
        } else {
             groups.add(data);
        }
    }

    public List<group> getAllGroups() {
        return groups;
    }


    public void deleteGroup(String id) throws ProjectExeption {
        boolean found = false;
        for (group group : groups) {
            if (group.getId().equals(id)) {
                groups.remove(group);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }

    public void updateGroup(String id, group newData) throws ProjectExeption {
        boolean found = false;
        for (group group : groups) {
            if (group.getId().equals(id)) {
                groups.remove(group);
                groups.add(newData);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }



    
   //CONSULTAS

   public List<subject> samePlaceQuery(String placeId) {
    List<subject> subjectsWithSamePlace = new UptcList<>();

    for (group group : groups) {
        if (group.getPlaceId().equals(placeId)) {
            subject subj = subjectService.getSubjectsbyCode(group.getSubjectCode());
            if (subj != null) {
                subjectsWithSamePlace.add(subj);
            }
        }
    }

    return subjectsWithSamePlace;
}


    public List<subject> sameScheduleQuery(UptcList<String> schedule) {
    List<subject> subjectsWithSameSchedule = new UptcList<subject>();
    for (group group : groups) {
        if (hasCommonSchedule(group.getSchedules(), schedule)) {
            subject subj = subjectService.getSubjectsbyCode(group.getSubjectCode());
            if (subj != null) {
                subjectsWithSameSchedule.add(subj);
            }
        }
    }
    return subjectsWithSameSchedule;
}


 //comparr horarios.
private boolean hasCommonSchedule(UptcList<String> groupSchedules, UptcList<String> querySchedule) {
    for (String queryTime : querySchedule) {
        boolean found = false;
        for (String groupTime : groupSchedules) {
            if (queryTime.equals(groupTime)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return false;
        }
    }
    return true;
}



public List<subject> getMore1() {
    List<subject> subjectsWithMultipleGroups = new UptcList<>();

    for (group group : groups) {
        subject subject = subjectService.getSubjectsbyCode(group.getSubjectCode());
        if (subject != null) {
            
            if (!subjectsWithMultipleGroups.contains(subject)) {
            
                int groupCount = countGroupsBySubjectCode(group.getSubjectCode());
            
                if (groupCount > 1) {
                    subjectsWithMultipleGroups.add(subject);
                }
            }
        }
    }

    return subjectsWithMultipleGroups;
}

private int countGroupsBySubjectCode(String subjectCode) {
    int count = 0;
    for (group group : groups) {
        if (group.getSubjectCode().equals(subjectCode)) {
            count++;
        }
    }
    return count;
}


    

     
}
