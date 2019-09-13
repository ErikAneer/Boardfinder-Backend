/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.service.SnowboardService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:4200")
public class SnowboardController {

    private SnowboardService sbService;

    @Autowired
    public SnowboardController(SnowboardService sbService) {
        this.sbService = sbService;
    }

    @GetMapping
    public List<Snowboard> getAllSnowboards() {

        return sbService.getAllSnowboards();

    }

    @GetMapping("/{id}")
    public Snowboard getSnowboardById(@PathVariable long id) {
        return sbService.filterById(id);
    }

    @PostMapping("/filter")
    public List<Snowboard> filterSnowboards(@RequestBody Map<String, Object> map) {
        return sbService.filter(map);
    }

    @PostMapping("/filteralternative")
    public List<Snowboard> filterSnowboardsWithAlternativeBendAndShape(@RequestBody Map<String, Object> map) {
        return sbService.filterWithAlternativeBendAndShape(map);
    }

    @PostMapping("/recommendedlength")
    public List<String> getRecommendedBoardLengths(@RequestBody Map<String, Object> map) {
        return sbService.getRecommendedBoardLengths(map);
    }

}
