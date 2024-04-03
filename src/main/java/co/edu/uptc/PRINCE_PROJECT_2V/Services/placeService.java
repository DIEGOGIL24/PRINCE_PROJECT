package co.edu.uptc.PRINCE_PROJECT_2V.Services;

import java.util.List;


import co.edu.uptc.LinkedList.services.dynamic.UptcList;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.TypeMessage;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.place;


public class placeService {
    
    private UptcList<place> places = new UptcList<>();

    public void addPlace(place place) throws ProjectExeption {
        if (verifyExists(place.getName())) {
            throw new ProjectExeption(TypeMessage.ELEMENT_ALRREADY_EXIST);
        } else {
            places.add(place);
        }
    }

    public List<place> getAllPlaces() {
        return places;
    }

    private boolean verifyExists(String name) {
        for (place place : places) {
            if (place.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public void deletePlace(String id) throws ProjectExeption {
        boolean found = false;
        for (place place : places) {
            if (place.getId().equals(id)) {
                places.remove(place);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }

    public void updatePlace(String id, place newData) throws ProjectExeption {
        boolean found = false;
        for (place place : places) {
            if (place.getId().equals(id)) {
                places.remove(place);
                places.add(newData);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProjectExeption(TypeMessage.NOT_FOUND);
        }
    }

}
