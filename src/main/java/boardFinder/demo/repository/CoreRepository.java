/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.Core;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface CoreRepository extends JpaRepository<Core, Long> {

    Core findById(long id);

    Core findByName(String name);
}
