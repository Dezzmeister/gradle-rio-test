package org.usfirst.frc.team69.robot.subsystems;

import static org.usfirst.frc.team69.robot.RobotMap.Grippah.SOLENOID_FORWARD;
import static org.usfirst.frc.team69.robot.RobotMap.Grippah.SOLENOID_REVERSE;

import org.hyperonline.hyperlib.QuickCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grippah extends Subsystem {
	private DoubleSolenoid solenoid = new DoubleSolenoid(SOLENOID_FORWARD, SOLENOID_REVERSE);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(openGrippah());		
	}
	
	public Command openGrippah() {
		return QuickCommand.continuous(this, () -> solenoid.set(Value.kForward));
	}
	
	public Command closeGrippah() {
		return QuickCommand.continuous(this, () -> solenoid.set(Value.kReverse));
	}
}
