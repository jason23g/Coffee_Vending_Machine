package softwareMachine;

import internalMachineModules.ConsumableDispenser;
import internalMachineModules.DosingContainer;
import internalMachineModules.FlowContainer;
import internalMachineModules.IngredientProcessor;
import internalMachineModules.MaterialContainer;
import machine.Module;
import tuc.ece.cs201.vm.hw.device.*;
import externalMachinesModules.*;
import internalMachineModules.*;

public class ModuleFactory {
	
	public static Module createModule(Device device) {
		Module  m = null;
		
		switch(device.getType()) {
		
		case ChangeCase:
			m = new ChangeCase((ChangeCaseDevice)device);
			System.out.println("Change Case Module Created");
			break;
		case CoinReader:
			m = new CoinReader((CoinAcceptorDevice)device);
			System.out.println("Coin Reader Module Created");
			break;
		case Display:
			m = new DisplayPanel((DisplayDevice)device);
			System.out.println("Display Panel Module Created");
			break;
		case NumPad:
			m = new NumPad((NumPadDevice)device);
			System.out.println("Num Pad Module Created");
			break;
		case ProductCase:
			m = new ProductCase((ProductCaseDevice)device);
			System.out.println("Product Case Module Created");
			break;
		case DosingContainer:
			m = new DosingContainer((DosingContainerDevice)device);
			System.out.println("Dosing Container Module Created");
			break;
		case FlowContainer:
			m = new FlowContainer((FlowContainerDevice)device);
			System.out.println("Flow Container Module Created");
			break;
		case DosingDispenser:
			m = new ConsumableDispenser((DispenserDevice)device);
			System.out.println("Dosing Dispenser Module Created");
			 for (Device cont: ((DispenserDevice)device).listConnectedDevices()) {
				((ConsumableDispenser)m).addContainer((DosingContainer)createModule(cont));
				System.out.println("Container Added to Dispenser");
			}
			break;
		case FlowDispenser:
			m = new ConsumableDispenser((DispenserDevice)device);
			System.out.println("Flow Dispenser Module Created");
			
			for (Device cont: ((DispenserDevice)device).listConnectedDevices()) {
				((ConsumableDispenser)m).addContainer((FlowContainer)createModule(cont));
				System.out.println("Container Added to Dispenser");
			}
			break;
		case MaterialContainer:
			m = new MaterialContainer((MaterialContainerDevice)device);
			System.out.println("Material Container Module created");
			break;
		case MaterialDispenser:
			m = new ConsumableDispenser((DispenserDevice)device);
			System.out.println("Material Dispenser Module Created");
			
			for (Device cont: ((DispenserDevice)device).listConnectedDevices()) {
				((ConsumableDispenser)m).addContainer((MaterialContainer)createModule(cont));
				System.out.println("Container Added to Dispenser");
			}
			break;
		case Processor:
			m = new IngredientProcessor((ProcessorDevice)device);
			System.out.println("Processor Module Created");
			break;
		default:
			System.out.println("Error.....Look again your code ");
			break;
			
		}
		return m;
		
	}

}
