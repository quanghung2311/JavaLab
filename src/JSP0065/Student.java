
package JSP0065;

/**
 *
 * @author Quang Hung
 */
public class Student {
    private String name;
    private String classes;
    private double math;
    private double physical;
    private double chemistry;
    private double average;
    private String type;

    public Student() {
    }

    public Student(String name, String classes, double math, double physical, double chemistry, double average, String type) {
        this.name = name;
        this.classes = classes;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.average = average;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", classes=" + classes + ", math=" + math + ", physical=" + physical + ", chemistry=" + chemistry + ", average=" + String.format("%.2f", average) + ", type=" + type + '}';
    }
    
    
}
