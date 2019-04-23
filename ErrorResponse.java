import java.io.Serializable;
import java.util.ArrayList;

public class ErrorResponse implements Serializable {
	private int errorCode;
	private ArrayList<Tenant> list;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public ArrayList<Tenant> getList() {
		return list;
	}
	public void setList(ArrayList<Tenant> list) {
		this.list = list;
	}
}
