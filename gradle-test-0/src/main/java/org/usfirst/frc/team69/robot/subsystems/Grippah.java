package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grippah extends Subsystem {
	private Solenoid solenoid = new Solenoid(RobotMap.Grippah.SOLENOID);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(openGrippah());		
	}
	
	public Command openGrippah() {
		return QuickCommand.continuous(this, () -> solenoid.set(true));
	}
	
	public Command closeGrippah() {
		return QuickCommand.continuous(this, () -> solenoid.set(false));
	}
}
