import java.io.Serializable;

enum CommandWord{
	ADD, DELETE, SEARCH, RETRIEVE ;
}
public class Command implements Serializable {
	private CommandWord command;
	private Object dataObject;

	public Command(Object dataObject, CommandWord command){

	}
	/**
	 * @return this classes object that holds data relevant to our command
	 * in this case a property or a
	 */
	public Object getDataObject() {
		return this.dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	public CommandWord getCommand() {
		return command;
	}
	public void setcommand(CommandWord command) {
		this.command = command;
	}

}
