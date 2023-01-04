package internalMachineModules;

import consumables.Consumable;

public interface Consumer {
	
	public void load(Consumable con);
	
	public boolean accepts(Consumable consumable);

}
