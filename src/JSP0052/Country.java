
package JSP0052;

/**
 *
 * @author Quang Hung
 */
public class Country extends EastAsiaCountries implements Comparable<Country>{

    private String terrain;

    public Country() {
    }

    public Country(String terrain, String id, String name, double area) {
        super(id, name, area);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    
    @Override
    public int compareTo(Country c) {
        return this.getName().compareTo((c.getName()));
    }
    
     @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.id,
                this.name, this.area, this.terrain);
    }
}
