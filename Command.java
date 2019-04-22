import java.io.Serializable;

public class Command implements Serializable {
private int commnad;
private Tenant tenant;
private Property property;

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
public Property getProperty() {
	return property;
}
public void setProperty(Property prop) {
	this.property = property;
}

}
