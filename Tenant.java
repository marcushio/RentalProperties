import java.io.Serializable;

public class Tenant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7521390664523300588L;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String cellphone;
	private String rentalPaid;
	private String email;
	
	public Tenant(String firstName, String lastName, String idNumber, String cellphone, String rentalPaid, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setIdNumber(idNumber);
		this.setCellphone(cellphone);
		this.setRentalPaid(rentalPaid);
		this.setEmail(email);
	}

	public String getRentalPaid() {
		return rentalPaid;
	}

	public void setRentalPaid(String rentalPaid) {
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
