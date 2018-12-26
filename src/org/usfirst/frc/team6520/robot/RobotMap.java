/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6520.robot;

import org.usfirst.frc.team6520.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
	
	// Subsystems
	public static DriveBase mDriveBase = new DriveBase();
	
	// Encoder
	public static Encoder encLeft = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder encRight = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	// Motors
	public static Spark spLeft = new Spark(1);
	public static Spark spRight = new Spark(0);
	public static Spark motor3 = new Spark(3);
	
	// Differential Drive
	public static DifferentialDrive mDrive = new DifferentialDrive(spLeft, spRight);
	
}
