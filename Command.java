import java.io.Serializable;

public class Command implements Serializable {
private int commnad;
private Tenant tenant;

public Tenant getTenant() {
	return tenant;
}
public void setTenant(Tenant tenant) {
	this.tenant = tenant;
}
public int getCommnad() {
	return commnad;
}
public void setCommnad(int commnad) {
	this.commnad = commnad;
}

}
