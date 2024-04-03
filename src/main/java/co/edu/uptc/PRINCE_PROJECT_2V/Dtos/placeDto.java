package co.edu.uptc.PRINCE_PROJECT_2V.Dtos;

import java.util.List;

import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.place;
import lombok.Data;

@Data
public class placeDto {
    private String id;
    private String name;
    private String location;


    public static placeDto fromPlace(place place) {
        placeDto placeDto = new placeDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setLocation(place.getLocation());
        return placeDto;
    }

    public static List<placeDto> fromPlaces(List<place> places) {
        List<placeDto> placeDtos = new UptcList<>();
        for (place place : places) {
            placeDtos.add(placeDto.fromPlace(place));
        }
        return placeDtos;
    }

    public static place fromplaceDto(placeDto placeDto) {
        place place = new place();
        place.setId(placeDto.getId());
        place.setName(placeDto.getName());
        place.setLocation(placeDto.getLocation());
        return place;
    }

    public static void validatePlace(placeDto placeDto) throws ProjectExeption {
        if (placeDto.getName() == null || 
            placeDto.getLocation() == null) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        }
    }
}
