/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Bend;
import boardFinder.demo.service.BendService;
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
@RequestMapping("/bend")
@CrossOrigin(origins = "http://localhost:4200")
public class BendController {

    private BendService bService;

    @Autowired
    public BendController(BendService bService) {
        this.bService = bService;
    }

    @GetMapping
    public List<Bend> getAllBends() {
        return bService.getAllBends();
    }

}
