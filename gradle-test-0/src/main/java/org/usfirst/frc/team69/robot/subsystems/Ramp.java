package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {
	private Solenoid rSolenoid = new Solenoid(RobotMap.Ramp.SOLENOID);
	private DoubleSolenoid rDoubleSolenoid = new DoubleSolenoid (RobotMap.Ramp.DOUBLE_SOLENOID);
	private Solenoid lSolenoid = new Solenoid(RobotMap.Ramp.SOLENOID);
	private DoubleSolenoid lDoubleSolenoid = new DoubleSolenoid (RobotMap.Ramp.DOUBLESOLENOID);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(rampMoveDown());		
	}
	
	public Command leftRampRelease () {
		return QuickCommand.oneShot (this, () -> lSolenoid.set(true));
	}
	
	public Command rightRampRelease () {
		return QuickCommand.oneShot (this, () -> rSolenoid.set(true));
	}
	
	public Command leftRampRise () {
		return QuickCommand.continuous (this, () -> lDoubleSolenoid.set(reverse));
	}
	
	public Command rightRampRise () {
		return QuickCommand.continuous (this, () -> rDoubleSolenoid.set(reverse));
	}
}
