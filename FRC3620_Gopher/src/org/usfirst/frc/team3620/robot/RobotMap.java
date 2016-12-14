package org.usfirst.frc.team3620.robot;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Relay.Direction;

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
    public static CANTalon subsystem1CANTalon1;

    public static SpeedController driveSpeedController0;
    public static SpeedController driveSpeedController1;

    public static RobotDrive robotDrive;

    public static Relay compressorRelay;
    public static DigitalInput compressorSwitch;

    public static AnalogInput pressureSensor1;
    public static AnalogInput pressureSensor2;
    public static AnalogInput pressureSensor3;

    public static Relay valveMaster;
    public static DigitalOutput fillValve1;
    public static DigitalOutput tankValve1;
    public static DigitalOutput shotValve1;
    public static DigitalOutput fillValve2;
    public static DigitalOutput tankValve2;
    public static DigitalOutput shotValve2;
    public static DigitalOutput fillValve3;
    public static DigitalOutput tankValve3;
    public static DigitalOutput shotValve3;

    public static edu.wpi.first.wpilibj.old.Compressor compressor;

    public static void init() {

        subsystem1CANTalon1 = new CANTalon(2);
        LiveWindow.addActuator("Subsystem 1", "CAN Talon 1", subsystem1CANTalon1);

        driveSpeedController0 = new Talon(0);
        LiveWindow.addActuator("Drive", "Speed Controller 0", (Talon) driveSpeedController0);

        driveSpeedController1 = new Talon(1);
        LiveWindow.addActuator("Drive", "Speed Controller 1", (Talon) driveSpeedController1);

        robotDrive = new RobotDrive(driveSpeedController0, driveSpeedController1);

        robotDrive.setSafetyEnabled(false);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
        // robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);

        // TODO - what do we need to do to get these on the dashboard?
        compressorRelay = new Relay(0, Direction.kForward);
        LiveWindow.addActuator("shooterSubsystem", "compressorRelay", compressorRelay);

        compressorSwitch = new DigitalInput(0);
        LiveWindow.addSensor("shooterSubsystem", "compressorSwitch", compressorSwitch);

        /*
        compressor = new edu.wpi.first.wpilibj.old.Compressor(compressorSwitch, compressorRelay);
        LiveWindow.addSensor("shooterSubsystem", "compressor", compressor);
        */

        pressureSensor1 = new AnalogInput(1);
        LiveWindow.addSensor("shooterSubsystem", "PressureSensor1", pressureSensor1);

        pressureSensor2 = new AnalogInput(2);
        LiveWindow.addSensor("shooterSubsystem", "PressureSensor2", pressureSensor2);

        pressureSensor3 = new AnalogInput(3);
        LiveWindow.addSensor("shooterSubsystem", "PressureSensor3", pressureSensor3);

        valveMaster = new Relay(1, Direction.kForward);
        LiveWindow.addActuator("shooterSubsystem", "valveMaster", valveMaster);

        fillValve1 = new DigitalOutput(1);
        LiveWindow.addActuator("shooterSubsystem", "fillValve1", fillValve1);

        tankValve1 = new DigitalOutput(2);
        LiveWindow.addActuator("shooterSubsystem", "tankValve1", tankValve1);

        shotValve1 = new DigitalOutput(3);
        LiveWindow.addActuator("shooterSubsystem", "shotValve1", shotValve1);

        fillValve2 = new DigitalOutput(4);
        LiveWindow.addActuator("shooterSubsystem", "fillValve2", fillValve2);

        tankValve2 = new DigitalOutput(5);
        LiveWindow.addActuator("shooterSubsystem", "tankValve2", tankValve2);

        shotValve2 = new DigitalOutput(6);
        LiveWindow.addActuator("shooterSubsystem", "shotValve2", shotValve2);

        fillValve3 = new DigitalOutput(7);
        LiveWindow.addActuator("shooterSubsystem", "fillValve3", fillValve3);

        tankValve3 = new DigitalOutput(8);
        LiveWindow.addActuator("shooterSubsystem", "tankValve3", tankValve3);

        shotValve3 = new DigitalOutput(9);
        LiveWindow.addActuator("shooterSubsystem", "shotValve3", shotValve3);
    }
}
