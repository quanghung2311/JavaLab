
package JSP0052;

/**
 *
 * @author Quang Hung
 */
public class EastAsiaCountries {
    protected String id;
    protected String name;
    protected double area;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String id, String name, double area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    public void display(){
        
    }
}
