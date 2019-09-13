/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Core;
import boardFinder.demo.service.CoreService;
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
@RequestMapping("/core")
@CrossOrigin(origins = "http://localhost:4200")
public class CoreController {

    private CoreService cService;

    @Autowired
    public CoreController(CoreService cService) {
        this.cService = cService;
    }

    @GetMapping
    public List<Core> getAllCores() {
        return cService.getAllCores();
    }

}
