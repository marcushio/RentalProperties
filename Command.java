import java.io.Serializable;

enum CommandWord{
	ADD, DELETE, SEARCH, RETRIEVE ;
}
public class Command implements Serializable {
	private CommandWord command;
	private Object dataObject;
	private String tableName;

	public Command(String tableName, Object dataObject, CommandWord command){
		this.tableName = tableName;
		this.dataObject = dataObject;
		this.command = command;
	}
	/**
	 * @return this classes object that holds data relevant to our command
	 * in this case a property or a
	 */
	public Object getDataObject() {
		return this.dataObject;
	}

	public String getTableName() {
		return tableName;
	}
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	public CommandWord getCommand() {
		return command;
	}
	public void setCommand(CommandWord command) {
		this.command = command;
	}

}
