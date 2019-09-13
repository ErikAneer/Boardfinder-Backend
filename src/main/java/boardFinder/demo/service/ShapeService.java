
package boardFinder.demo.service;

import boardFinder.demo.domain.Shape;
import boardFinder.demo.repository.ShapeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */

@Service
public class ShapeService {
    
    private ShapeRepository shapeRepository;

    @Autowired
    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }
    
    public List<Shape> getAllShapes(){
        return shapeRepository.findAll();
    }
    
    public Optional<Shape> getShapeById(Long id){
        return shapeRepository.findById(id);
    }
    
    /*
    public Brand getBrandByName(String name){
        return brandRepository.findByName(name);
    }
*/
    
    public Shape save(Shape shape){
        return shapeRepository.save(shape);
    }
    
}
