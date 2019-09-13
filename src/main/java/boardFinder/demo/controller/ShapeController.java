/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Shape;
import boardFinder.demo.service.ShapeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */
@RestController
@RequestMapping("/shape")
@CrossOrigin(origins = "http://localhost:4200")
public class ShapeController {
    
     private ShapeService sService;

    @Autowired
    public ShapeController( ShapeService sService) {
        this.sService = sService;
    }
    
    @GetMapping
    public List<Shape> getAllShapes(){
        return sService.getAllShapes();
    }

}
