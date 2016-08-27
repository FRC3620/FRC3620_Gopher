package org.usfirst.frc.team3620.robot.subsystems;

import org.usfirst.frc.team3620.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    BarrelPrototype b1 = new BarrelPrototype(RobotMap.fillValve1, RobotMap.shotValve1, RobotMap.pressureSensor1);;
    {
    	System.out.println("subsystem loaded");
    }
    
     
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startup() {
    	b1.startup();
    }
    
    public void makeTheBarrelsWork() {
    	b1.makeTheBarrelWork();
    }
    
    public void requestFill() {
    	// TODO get fancy later if we have multiple barrels
    	b1.requestFill();
    }
    public void requestShot() {
    	// TODO get fancy later if we have multiple barrels
    	b1.requestShot();
    }
}

