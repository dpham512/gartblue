package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class C_Keys extends Command {

    public C_Keys() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	double speed = 0.4;
    	double time = 0.5;
    	if (!RobotMap.keyActivated) {
    		speed = -0.4;
    		RobotMap.keyActivated = true;
    	} else {
    		RobotMap.keyActivated = false;
    	}
    	double t = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() <= t + time) {
    		RobotMap.key.set(speed);
    	}
    	RobotMap.key.stopMotor();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
