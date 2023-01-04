package internalMachineModules;

public interface Provider extends Pluggable{
	
	public void provide(Consumer confRef,int quantity) ;
	
	public void provide(Consumer conRef);

}
