package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *	Controll the robot in autonomous mode
 */
public class atonomousCommand extends Command {

	private static final double timePB = 0.6;	//Time for the robot to move 120cm
	
    public atonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	RobotMap.mDriveBase.atonomousStraight(timePB, 1);	// 120cm
    	RobotMap.mDriveBase.atonomousTurn(1);
    	RobotMap.motor3.set(-0.5);	//Start intake
    	
    	//Time for the intake to start
    	double t = Timer.getFPGATimestamp();
    	while (Timer.getFPGATimestamp() <= t + 1) {}
//    	
    	RobotMap.mDriveBase.atonomousStraight(timePB * 2.5, 1);	//300cm
    	RobotMap.mDriveBase.atonomousTurn(-1);
    	RobotMap.mDriveBase.atonomousStraight(timePB * 3, 1);	//360cm
    	
    	RobotMap.mDriveBase.atonomousStraight(timePB * 1.5, -1); //180cm
    	RobotMap.mDriveBase.atonomousTurn(-1);
    	RobotMap.motor3.stopMotor();	//Stop intake
    	
    	RobotMap.mDriveBase.atonomousStraight(timePB * 1.7, -1);	//200cm
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
