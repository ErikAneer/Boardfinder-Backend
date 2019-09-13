package boardFinder.demo.service;

import boardFinder.demo.domain.Bend;
import boardFinder.demo.repository.BendRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class BendService {

    private BendRepository bendRepository;

    @Autowired
    public BendService(BendRepository bendRepository) {
        this.bendRepository = bendRepository;
    }

    public List<Bend> getAllBends() {
        return bendRepository.findAll();
    }

    public Optional<Bend> getBendById(Long id) {
        return bendRepository.findById(id);
    }

    public Bend getBendByName(String name) {
        return bendRepository.findByName(name);
    }

    public Bend save(Bend bend) {
        return bendRepository.save(bend);
    }
}
