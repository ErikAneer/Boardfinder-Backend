package boardFinder.demo.repository;

import boardFinder.demo.domain.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {

}
