/**
 * Class Description
 *
 * @author Douglas Ubeda-Harvey
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Tenant implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7521390664523300588L;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String cellphone;
    private LocalDate rentPaid;
    private String email;
/*
    public Tenant(String idNumber, String firstName, String lastName, String cellphone, LocalDate rentalPaid, String email) {
        this.setIdNumber(idNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCellphone(cellphone);
        this.setRentalPaid(rentalPaid);
        this.setEmail(email);
    }
    */

    public LocalDate getRentPaid() {
        return rentPaid;
    }

    public void setRentalPaid(LocalDate rentalPaid) {
        this.rentPaid = rentalPaid;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToDefaults(){ // used for quick default settings to test
        this.setIdNumber("1111111");
        this.setFirstName("Trial");
        this.setLastName("Testman");
        this.setCellphone("505-555-5555");
        this.setRentalPaid(LocalDate.now());
        this.setEmail("l337codez@gmail.com");
    }
}
