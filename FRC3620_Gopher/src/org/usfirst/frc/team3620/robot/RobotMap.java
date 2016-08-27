package org.usfirst.frc.team3620.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static SpeedController driveSpeedController0;
	public static SpeedController driveSpeedController1;
	
	public static DoubleSolenoid  fillValve1;
	public static DoubleSolenoid  shotValve1;
	public static AnalogInput pressureSensor1;
	
	public static RobotDrive robotDrive;
	 
	
	public static void init(){
	
		 driveSpeedController0 = new Talon(0);
		 LiveWindow.addActuator("Drive", "Speed Controller 0", (Talon) driveSpeedController0);
	 
		 driveSpeedController1 = new Talon(1);
		 LiveWindow.addActuator("Drive", "Speed Controller 1", (Talon) driveSpeedController1);
		 
		 robotDrive = new RobotDrive(driveSpeedController0, driveSpeedController1);
		 
		 robotDrive.setSafetyEnabled(false);
		 robotDrive.setExpiration(0.1);
		 robotDrive.setSensitivity(0.5);
		 robotDrive.setMaxOutput(1.0);
		 //robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		 
		 // TODO - what do we need to do to get these on the dashboard?
		 fillValve1 = new DoubleSolenoid(0, 1);
		 LiveWindow.addActuator("ShooterSubsystem", "FillValve1", fillValve1);
		 
		 shotValve1 = new DoubleSolenoid(2, 3);
		 LiveWindow.addActuator("ShooterSubsystem", "ShotValve1", shotValve1);
		 
		 pressureSensor1 = new AnalogInput(0);
		 LiveWindow.addSensor("ShooterSubsystem", "PressureSensor1", pressureSensor1);
		 
		 System.out.println("done with init" +  pressureSensor1);
	 
	 }
}
