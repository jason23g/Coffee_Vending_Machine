package devices;



import consumables.Ingredient;
import consumables.LiquidIngredient;
import consumables.ProcessedIngredient;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.ProcessorDevice;

public class ProcessorDevices extends FlowContainerDevices implements ProcessorDevice{

	private boolean isOperating = true;
	
	private ProcessedIngredient processedIngredient;
	
	public ProcessorDevices(String name, DeviceType type) {
		super(name, type);
		
	}

	
	public ProcessorDevices(String name, DeviceType type,Ingredient ing) {
		super(name, type,ing);
		this.processedIngredient = (ProcessedIngredient)ing;
	}

	
	


	
	public String getProcessingLabel() {
		String str = type.name();
		
		return str;
	}

	
	public void operateStart() {
		
		isOperating = true;
		System.out.println("The process has been started....");
		
	}

	
	public void operateStop() {
		
		isOperating = false;
		System.out.println("The process has been finished...");
	}

	
	public void streamIn() {
		
		
	}





	public ProcessedIngredient getProcessedIngredient() {
		return processedIngredient;
	}


	public void setProcessedIngredient(ProcessedIngredient processedIngredient) {
		this.processedIngredient = processedIngredient;
	}


	
	
	
	

}
