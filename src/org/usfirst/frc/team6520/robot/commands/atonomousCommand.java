package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Controll the robot in atonomous mode
 */
public class atonomousCommand extends Command {

	private static final double timePB = 1;
	
    public atonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	RobotMap.mDriveBase.atonomousStraight(timePB * 1.5, 1);
    	RobotMap.mDriveBase.atonomousTurn(-1);
    	
    	RobotMap.motor3.set(0.5);
    	RobotMap.mDriveBase.atonomousStraight(timePB * 0.5, 1);
    	RobotMap.mDriveBase.atonomousTurn(1);
    	RobotMap.mDriveBase.atonomousStraight(timePB * 9.5, 1);
    	RobotMap.motor3.stopMotor();
    	
    	RobotMap.mDriveBase.atonomousStraight(timePB * 4.75, -1);
    	RobotMap.mDriveBase.atonomousTurn(1);
    	
    	RobotMap.mDriveBase.atonomousStraight(timePB * 5, -1);
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
