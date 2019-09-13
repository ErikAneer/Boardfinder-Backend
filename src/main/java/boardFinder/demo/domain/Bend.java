package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Erik
 */
@Entity
public class Bend implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "bend_s_generator", sequenceName = "bend_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bend_s_generator")
    private long id;
    private String name;

    @Length(max = 1000)
    private String description;
    private String imagePath;

    public Bend(String name, String description, String imagePath) {
        this.name = name;
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

    public Bend() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setBendName(String name) {
        this.name = name;
    }

}
