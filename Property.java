import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * An object representing a rental property in our property management software. Basically holds the data related to
 * any given property.
 *
 * @author Marcus Trujillo
 * @version 2/7/19
 */
public class Property implements Serializable {
    String propertyID;
    String address;
    int bedrooms;
    int bathrooms;
    String info;
    float cost;
    String terms;
    String available;
    LocalDate dateAvailable;
    String tenantID;
    String description;

    //A big ol' block of getters
    public String getPropertyID() {
        return propertyID;
    }

    public String getTerms() {
        return terms;
    }

    public String getAvailable() {
        return available;
    }

    public float getCost() {
        return cost;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return info;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public String getDescription() {
        return description;
    }

    public String getTenantID() {
        return tenantID;
    }

    public LocalDate getDateAvailable() {
        return dateAvailable;
    }

    public String getFullDescription(){ return description; }

    //All our setters

    public void setPropertyID(String propertyID) { this.propertyID = propertyID; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setDateAvailable(LocalDate dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //set up some kind of default property
    public void setToDefault(){
        setPropertyID("SABQ333");
        setAddress("805 Superstition");
        setBedrooms(3);
        setBathrooms(2);
        setInfo("W/D included");
        setCost((float)1000.00);
        setTerms("Monthly");
        setAvailable("yes");
        setDateAvailable(LocalDate.now());
        setTenantID("111");
        setDescription("Great place near a golf course");
    }

}
