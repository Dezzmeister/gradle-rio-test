package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {
	private Solenoid solenoid = new Solenoid(RobotMap.Ramp.SOLENOID);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(rampMoveDown());		
	}
	
	/*public Command rampUp() {
		return QuickCommand.oneShot(this, () -> solenoid.set(true));
	}
	
	public Command rampDown() {
		return QuickCommand.oneShot(this, () -> solenoid.set(false));
	}
	
	public Command rampMiddle() {
		return QuickCommand.oneShot(this, () -> solenoid.set(false));
	}*/
	
	public Command rampMoveUp () {
		return QuickCommand.continuous (this, () -> solenoid.set(true));
	}
	
	public Command rampMoveDown () {
		return QuickCommand.continuous (this, () -> solenoid.set(false));
	}
}
