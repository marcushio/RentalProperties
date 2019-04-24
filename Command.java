import java.io.Serializable;

/**
 * Class is for the client to send to the server so that the server can query the database in the appropriate manner.
 * Uses enums for better readability and more consistency. Has an object that holds all the data necessary to perform
 * the command. Also has the table name so the server knows which table this command wants the command for.
 */

enum CommandWord{
	ADD, DELETE, SEARCH, RETRIEVE, UPDATE ;
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

	/**
	 * @return the data object used in the command. For instance a Property or Tenant
	 */
	public Object getDataObject() {
		return this.dataObject;
	}

	/**
	 *
	 * @return the name of the table it will address
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * sets the data object the command will use.
	 * @param dataObject
	 */
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	/**
	 *
	 * @return the command relevant. For instance if you want to add something to DB CommandWord is ADD.
	 */
	public CommandWord getCommand() {
		return command;
	}
	public void setCommand(CommandWord command) {
		this.command = command;
	}

}
