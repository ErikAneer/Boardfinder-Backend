package boardFinder.demo.service;

import boardFinder.demo.domain.Flex;
import boardFinder.demo.repository.FlexRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class FlexService {

    private FlexRepository flexRepository;

    @Autowired
    public FlexService(FlexRepository flexRepository) {
        this.flexRepository = flexRepository;
    }

    public List<Flex> getAllFlexes() {
        return flexRepository.findAll();
    }

    public Optional<Flex> getFlexById(Long id) {
        return flexRepository.findById(id);
    }

    public Flex getFlexByName(String name) {
        return flexRepository.findByFlex(name);
    }

    public Flex save(Flex bend) {
        return flexRepository.save(bend);
    }
}
