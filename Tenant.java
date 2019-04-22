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
    private LocalDate rentalPaid;
    private String email;

    public Tenant(String idNumber, String firstName, String lastName, String cellphone, LocalDate rentalPaid, String email) {
        this.setIdNumber(idNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCellphone(cellphone);
        this.setRentalPaid(rentalPaid);
        this.setEmail(email);
    }

    public LocalDate getRentalPaid() {
        return rentalPaid;
    }

    public void setRentalPaid(LocalDate rentalPaid) {
        this.rentalPaid = rentalPaid;
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
}
