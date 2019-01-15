package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shoulder extends Subsystem {
	private VictorSP shold = new VictorSP(RobotMap.Shoulder.SHOULDER);

	private static final float UP_SHOLD = 0.5f;
	private static final float DOWN_SHOLD = -0.5f;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand (stop());
	}
	
	public Command stop () {
		return QuickCommand.continuous (this, () -> shold.set (0));
	}
	
	public Command upShold () {
		return QuickCommand.continuous(this,  () -> shold.set (UP_SHOLD));
	}
	
	public Command downShold () {
		return QuickCommand.continuous(this, () -> shold.set (DOWN_SHOLD));
	}
	
	
	

}
