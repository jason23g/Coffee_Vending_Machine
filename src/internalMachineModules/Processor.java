package internalMachineModules;

public interface Processor extends Consumer,Pluggable {

	public void process(int duration);
	
	
}
