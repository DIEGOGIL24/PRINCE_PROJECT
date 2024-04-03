package co.edu.uptc.PRINCE_PROJECT_2V.Models;



import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import lombok.Data;


@Data
public class group {
    private String id;
    private String subjectCode;
    private String placeId;
    private UptcList<String> schedules;


    
}
