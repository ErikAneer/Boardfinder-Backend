/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Flex;
import boardFinder.demo.service.FlexService;
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
@RequestMapping("/flex")
@CrossOrigin(origins = "http://localhost:4200")
public class FlexController {
    
     private FlexService fService;

    @Autowired
    public FlexController(FlexService fService) {
        this.fService = fService;
    }
    
    @GetMapping
    public List<Flex> getAllFlexes(){
        return fService.getAllFlexes();
    }

}

