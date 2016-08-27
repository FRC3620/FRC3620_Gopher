
package org.usfirst.frc.team3620.robot.subsystems;

import org.usfirst.frc.team3620.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class BarrelPrototype {
	
	DoubleSolenoid fillValve;
	DoubleSolenoid shotValve;
	AnalogInput pressureSensor;
	
	boolean fillRequested = false;
	boolean shotRequested = false;
	
	BarrelState idleState = new IdleState();
	BarrelState waitFillState = new WaitFillState();
	BarrelState fillingState = new FillingState();
	BarrelState waitFireState = new WaitFireState();
	BarrelState firingState = new FiringState();
	
	BarrelState currentBarrelState;
	
	public void startup() {
		currentBarrelState = idleState;
		currentBarrelState.enter();
	}
	
	public void makeTheBarrelWork() {
		BarrelState newState = currentBarrelState.running();
		if (newState != null && newState != currentBarrelState) {
			System.out.println("moving to state " + newState + ", from " + currentBarrelState);;
			currentBarrelState.exit();
			newState.enter();
			currentBarrelState = newState;
		}
	}
	
	public BarrelPrototype (DoubleSolenoid _fillValve, DoubleSolenoid _shotValve, AnalogInput _pressureSensor) {
		super();
		this.fillValve = _fillValve;
		this.shotValve = _shotValve;
		this.pressureSensor = _pressureSensor;
	}
	
	public void requestFill() {
		fillRequested = true;
	}
	
	public void requestShot() {
		shotRequested = true;
	}
	/*
		return false;
	} // Look at Driver Station for button numbers
	boolean fireRequested(int buttonNumber2){
		return false;
	}
	
	
	boolean isFilling(BarrelPrototype barrel){
		
		return false;
	}
	*/
	
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
		
		void enter() {
			fillRequested = false;
		}

		@Override
		BarrelState running() {
			if (fillRequested) {
				 return waitFillState;
			} 
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
			return fillingState;
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
	Timer timer = new Timer();
		
		@Override
		void enter(){
			fillValve.set(Value.kForward);
			timer.reset();
			timer.start();
		}
		
		@Override
		BarrelState running() {
			if (timer.hasPeriodPassed(3.0)) {
				return waitFireState;
			}
			if (pressureSensor.getVoltage() > 2.5) {
				return waitFireState;
			}
			return null;
		}
		
		@Override
		void exit(){
			fillValve.set(Value.kOff);
		}
	}

/* The state 'WaitFire', is the fourth state to be run. Entry condition is that the Filling state is complete.
 * The running() method will run code that waits for user input.
 * Exit condition is specific user input.
 */

class WaitFireState extends BarrelState {
	
	void enter() {
		shotRequested = false;
	}

	@Override
	BarrelState running() {
		if (shotRequested) {
			 return firingState;
		} 
		return null;
	}
}

/* The state 'Firing', is the last state to be run. Entry condition is exit from the 'WaitFire' state
 * The running() method runs code to fire the specified Barrel
 * Exit condition is automatic exit to the 'Idle' state once firing is complete.
 */

class FiringState extends BarrelState {
	Timer timer = new Timer();
	
	@Override
	void enter(){
		shotValve.set(Value.kForward);
		timer.reset();
		timer.start();
	}
	
	@Override
	BarrelState running() {
		if (timer.hasPeriodPassed(0.5)) {
			return idleState;
		}
		return null;
	}
	
	@Override
	void exit(){
		shotValve.set(Value.kOff);
	}
}



}

