package org.usfirst.frc.team3620.robot.subsystems;


import org.usfirst.frc.team3620.robot.*;
import org.usfirst.frc.team3620.robot.commands.DriveCommand;


import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
	SpeedController speedController1 = RobotMap.driveSpeedController1;
	SpeedController speedController0 = RobotMap.driveSpeedController1;
	
	RobotDrive robotDrive = RobotMap.robotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void driveControl(double move, double rotate){
		if(Math.abs(move) <= .2){
			move = 0;
		}
		
		if(Math.abs(rotate) <= .2){
			rotate = 0;
		}
		
		robotDrive.arcadeDrive(move, rotate);
	}
	
	public void stopDrivingNow(){
		robotDrive.stopMotor();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveCommand());
    }
}
