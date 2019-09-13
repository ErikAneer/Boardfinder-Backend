/*

 */
package boardFinder.demo.service;

import boardFinder.demo.domain.Core;
import boardFinder.demo.repository.CoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class CoreService {

    private CoreRepository cR;

    @Autowired
    public CoreService(CoreRepository cR) {
        this.cR = cR;
    }

    public List<Core> getAllCores() {
        return cR.findAll();
    }

    public Optional<Core> getCoreById(Long id) {
        return cR.findById(id);
    }

    public Core getCoreByName(String name) {
        return cR.findByName(name);
    }

    public Core save(Core core) {
        return cR.save(core);
    }

}
