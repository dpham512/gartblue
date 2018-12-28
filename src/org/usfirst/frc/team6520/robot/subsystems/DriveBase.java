package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.OI;
import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Motors controller
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	// Autonomous
	public static final double distanceSpeed = 0.6;	
	public static final double angleSpeed = 0.4;
	public static final double angleTime = 0.737;	//0.74
	public static double intakeMode = 0;	//Velocity
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Controll the robot to go straight in atonomous mode
     * 
     * @param timer: Time to move to the destination.
     * @param direction: -1.0 (backward) or 1.0 (forward).
     */
    public void atonomousStraight(double timer, double direction) {
    	double t = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() <= t + timer) {
    		RobotMap.spLeft.set(distanceSpeed * direction);
    		RobotMap.spRight.set(-distanceSpeed * direction);
    	}
    	RobotMap.spLeft.stopMotor();
    	RobotMap.spRight.stopMotor();
    }
    
    /**
     * Controll the robot to turn in atonomous mode
     * 
     * @param direction: -1.0 (left) or 1.0 (right).
     */
    public void atonomousTurn(double direction) {
    	double t = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() <= t + angleTime) {
    		RobotMap.spLeft.set(angleSpeed * direction);
    		RobotMap.spRight.set(angleSpeed * direction);
    	}
    	RobotMap.spLeft.stopMotor();
    	RobotMap.spRight.stopMotor();
    }
    
    /**
     * Execute in teleop mode
     * @param m_oi: Operator interface
     */
    public void teleUpdate(OI m_oi) {
    	RobotMap.mDrive.tankDrive(-m_oi.mJoystick.getRawAxis(1), -m_oi.mJoystick.getRawAxis(3));
    	RobotMap.motor3.set(intakeMode);
    }
    
    /**
     * Boost
     * @param multi: 1 (forward) or -1 (backward)
     */
    public void boost(int multi) {
    	RobotMap.mDrive.tankDrive(1 * multi, 1 * multi);
    }
    
    /**
     * Release boost
     */
    public void releaseBoost() {
    	RobotMap.mDrive.tankDrive(0, 0);
    }
    
    /**
     * Change velocity
     * @param mode: new velocity
     */
    public void switchMode(double mode) {
    	intakeMode = mode;
    }
    
}

