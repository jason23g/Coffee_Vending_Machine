package internalMachineModules;

public interface Pluggable {
	
	public void plug(Consumer consumer);
	
	public void unPlug(Consumer consumer);
	
	public void unPlugAll();
	
	public boolean isPlugged();

}
