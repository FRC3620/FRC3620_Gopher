
package org.usfirst.frc.team3620.robot.subsystems;

public class BarrelPrototype {
	
	abstract class BarrelState {
		void enter () { 
		}
		abstract BarrelState running();
		void exit () { 
		}
	}
	
	class IdleState extends BarrelState {

		@Override
		BarrelState running() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
}
