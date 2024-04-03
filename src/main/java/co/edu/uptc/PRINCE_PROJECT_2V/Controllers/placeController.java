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


import co.edu.uptc.PRINCE_PROJECT_2V.Dtos.placeDto;
import co.edu.uptc.PRINCE_PROJECT_2V.Exeptions.ProjectExeption;
import co.edu.uptc.PRINCE_PROJECT_2V.Models.place;
import co.edu.uptc.PRINCE_PROJECT_2V.Services.placeService;

@RestController
@RequestMapping("/places")
public class placeController {
    private placeService placeService=new placeService();

    

    @PostMapping("/add")
    public ResponseEntity<Object> addPlace(@RequestBody placeDto placeDt) {
        try {
            placeDto.validatePlace(placeDt);
            placeService.addPlace(placeDto.fromplaceDto(placeDt));
            return ResponseEntity.status(HttpStatus.OK).body(placeDt);
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllPlaces() {
        List<place> places = placeService.getAllPlaces();
        return ResponseEntity.status(HttpStatus.OK).body(placeDto.fromPlaces(places));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePlace(@PathVariable String id) {
        try {
            placeService.deletePlace(id);
            return ResponseEntity.status(HttpStatus.OK).body("Place with ID " + id + " deleted successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePlace(@PathVariable String id, @RequestBody placeDto newData) {
        try {
            placeService.updatePlace(id, placeDto.fromplaceDto(newData));
            return ResponseEntity.status(HttpStatus.OK).body("Place with ID " + id + " updated successfully.");
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }

}
