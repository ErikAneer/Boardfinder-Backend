package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Erik
 */
@Entity
public class ShoeSize implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "shoe_size_s_generator", sequenceName = "shoe_size_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoe_size_s_generator")
    private long id;
    private double euSize;
    private double jpSize;
    private double ukSize;
    private double usMensSize;
    private double usWomensSize;
    private int waistWidthMin;
    private int waistWidthMax;
    private int waistWidthIdeal;

    public ShoeSize(double euSize, double jpSize, double ukSize, double usMensSize, double usWomensSize, int waistWidthMin, int waistWidthMax, int waistWidthIdeal) {
        this.euSize = euSize;
        this.jpSize = jpSize;
        this.ukSize = ukSize;
        this.usMensSize = usMensSize;
        this.usWomensSize = usWomensSize;
        this.waistWidthMin = waistWidthMin;
        this.waistWidthMax = waistWidthMax;
        this.waistWidthIdeal = waistWidthIdeal;
    }

    public ShoeSize() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getEuSize() {
        return euSize;
    }

    public void setEuSize(double euSize) {
        this.euSize = euSize;
    }

    public double getJpSize() {
        return jpSize;
    }

    public void setJpSize(double jpSize) {
        this.jpSize = jpSize;
    }

    public double getUkSize() {
        return ukSize;
    }

    public void setUkSize(double ukSize) {
        this.ukSize = ukSize;
    }

    public double getUsMensSize() {
        return usMensSize;
    }

    public void setUsMensSize(double usMensSize) {
        this.usMensSize = usMensSize;
    }

    public double getUsWomensSize() {
        return usWomensSize;
    }

    public void setUsWomensSize(double usWomensSize) {
        this.usWomensSize = usWomensSize;
    }

    public int getWaistWidthMax() {
        return waistWidthMax;
    }

    public void setWaistWidthMax(int waistWidthMax) {
        this.waistWidthMax = waistWidthMax;
    }

    public int getWaistWidthMin() {
        return waistWidthMin;
    }

    public void setWaistWidthMin(int waistWidthMin) {
        this.waistWidthMin = waistWidthMin;
    }

    public int getWaistWidthIdeal() {
        return waistWidthIdeal;
    }

    public void setWaistWidthIdeal(int waistWidthIdeal) {
        this.waistWidthIdeal = waistWidthIdeal;
    }

}
