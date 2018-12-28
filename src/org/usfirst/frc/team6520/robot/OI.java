/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6520.robot;

import org.usfirst.frc.team6520.robot.commands.C_Boost;
import org.usfirst.frc.team6520.robot.commands.C_Key1;
import org.usfirst.frc.team6520.robot.commands.C_Key2;
import org.usfirst.frc.team6520.robot.commands.C_ReleaseBoost;
import org.usfirst.frc.team6520.robot.commands.C_intakeOff;
import org.usfirst.frc.team6520.robot.commands.C_intakeReverse;
import org.usfirst.frc.team6520.robot.commands.C_motor3;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	// Joystick
	public Joystick mJoystick = new Joystick(0);
	
	// Intake Button
	public Button motor3Controller = new JoystickButton(mJoystick, 6);
	public Button intakeOff = new JoystickButton(mJoystick, 7);
	public Button intakeReverse = new JoystickButton(mJoystick, 1);
	
	// Key button
	public Button key1 = new JoystickButton(mJoystick, 10);
	public Button key2 = new JoystickButton(mJoystick, 11);
	
	// Boost button
	public Button boost = new JoystickButton(mJoystick, 4);
	
	public OI() {
		motor3Controller.whenPressed(new C_motor3());
		intakeOff.whenPressed(new C_intakeOff());
		intakeReverse.whenPressed(new C_intakeReverse());
		key1.whileHeld(new C_Key1());
		key2.whileHeld(new C_Key2());
		boost.whileHeld(new C_Boost());
		boost.whenReleased(new C_ReleaseBoost());
	}
	
}
