/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.Bend;
import boardFinder.demo.domain.Snowboard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface BendRepository extends JpaRepository<Bend, Long> {

    Bend findById(long id);

    Bend findByName(String name);
}
