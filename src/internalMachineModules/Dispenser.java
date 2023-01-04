package internalMachineModules;

public interface Dispenser extends Pluggable{
	
	public Provider prepareContainer(String conName,Consumer conRef);
	
	public void addContainer(Container container);
	
	public Container removeContainer(String conName);
	
	public int getCurrentQuanity(String contName);

}
