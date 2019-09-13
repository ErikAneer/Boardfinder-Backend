package boardFinder.demo.repository;

import boardFinder.demo.domain.Flex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface FlexRepository extends JpaRepository<Flex, Long> {

    Flex findById(long id);

    Flex findByFlex(String name);
}
