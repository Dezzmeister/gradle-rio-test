package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shoulder extends Subsystem {
	private VictorSP motor = new VictorSP(RobotMap.Shoulder.MOTOR);
	
	private static final float UP_POWER = 0.5f;
	private static final float DOWN_POWER = -0.5f;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(stop());		
	}
	
	public Command stop() {
		return QuickCommand.continuous(this, () -> motor.set(0));
	}
	
	public Command moveUp() {
		return QuickCommand.continuous(this, () -> motor.set(UP_POWER));
	}
	
	public Command moveDown() {
		return QuickCommand.continuous(this, () -> motor.set(DOWN_POWER));
	}
}
