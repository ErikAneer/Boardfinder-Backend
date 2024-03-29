
package boardFinder.demo.repository;

import boardFinder.demo.domain.RidingTerrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */

@Repository
public interface RidingTerrainRepository extends JpaRepository<RidingTerrain, Long>{
    
}
