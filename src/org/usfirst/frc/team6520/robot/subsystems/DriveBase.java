package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.OI;
import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static final double distanceSpeed = 0.5;
	public static final double angleSpeed = 0.5;
	public static final double angleTime = 1;
	public static double intakeMode = 0;
	
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
    
    public void teleUpdate(OI m_oi) {
    	RobotMap.mDrive.tankDrive(-m_oi.mJoystick.getRawAxis(1) * 0.6, -m_oi.mJoystick.getRawAxis(3) * 0.6);
    	RobotMap.motor3.set(intakeMode);
    }
    
    public void boost() {
    	RobotMap.mDrive.tankDrive(1, 1);
    }
    
    public void releaseBoost() {
    	RobotMap.mDrive.tankDrive(0, 0);
    }
    
    public void switchMode(double mode) {
    	intakeMode = mode;
    }
    
}

