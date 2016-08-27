
package org.usfirst.frc.team3620.robot.subsystems;

public class BarrelPrototype {
	boolean fillRequested(int buttonNumber){
		return false;
	} // Look at Driver Station for button number
	boolean fireRequested(int buttonNumber){
		return false;
	}
	boolean isFilling(){
		return false;
	}
	abstract class BarrelState {
		void enter () { 
		}
		abstract BarrelState running();
		void exit () { 
		}
	}
	
	/* The state 'Idle', is the first state to be run. Entry conditions are either entering for the first time or after
	 * the Firing state.
	 * No code is run by the running() method except for possibly State related jargon.
	 * Exit conditions are either automatic exit to the 'Waiting to Fill' state or user input.
	 */
	
	class IdleState extends BarrelState {

		@Override
		BarrelState running() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	/* The state 'WaitFill', is the second state to be run. Entry conditions is either automatic from 'Idle' or accomplished
	 * with user input.
	 * The running() method will verify that no Barrel is currently filling.
	 * Exit condition is that no other Barrel is filling.
	 */
	
	class WaitFillState extends BarrelState {
		
		@Override
		void enter(){
			
		}
		
		@Override
		BarrelState running() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		void exit(){
			
		}
	}
	/* The state 'Filling', is the third state to be run. Entry condition is exit from the 'WaitFill' state
	 * The running() method runs code to fill the Shot Valve for a Barrel
	 * Exit condition is automatic exit to the 'WaitFire' state once filling is complete.
	 */
	
class FillingState extends BarrelState {
		
		@Override
		void enter(){
			
		}
		
		@Override
		BarrelState running() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		void exit(){
			
		}
	}

/* The state 'WaitFire', is the fourth state to be run. Entry condition is that the Filling state is complete.
 * The running() method will run code that waits for user input.
 * Exit condition is specific user input.
 */

class WaitFireState extends BarrelState {
	
	@Override
	void enter(){
		
	}
	
	@Override
	BarrelState running() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	void exit(){
		
	}
}

/* The state 'Firing', is the last state to be run. Entry condition is exit from the 'WaitFire' state
 * The running() method runs code to fire the specified Barrel
 * Exit condition is automatic exit to the 'Idle' state once firing is complete.
 */

class FiringState extends BarrelState {
	
	@Override
	void enter(){
		
	}
	
	@Override
	BarrelState running() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	void exit(){
		
	}
}



}
