package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Erik
 */
@Entity
public class Shape implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "shape_s_generator", sequenceName = "shape_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shape_s_generator")
    private long id;
    private String shapeName;
    @Length(max = 1000)
    private String description;
    private String imagePath;

    public Shape(String shapeName, String description, String imagePath) {
        this.shapeName = shapeName;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Shape() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

}
