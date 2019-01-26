package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.PeriodicScheduler;
import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoulder extends Subsystem {
	private Talon motor = new Talon(RobotMap.Shoulder.MOTOR);
	private AnalogPotentiometer potentiometer = new AnalogPotentiometer(RobotMap.Shoulder.POTENTIOMETER,3600);
	
	public Shoulder() {
		super();
		
		LiveWindow.add(potentiometer);
		
		PeriodicScheduler.getInstance().addEvent(this::showInfo);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(stop());		
	}
		
	public Command stop() {
		// return QuickCommand.continuous(this, () -> motor.set(0));
		return QuickCommand.continuous(this, () -> motor.setSpeed(0));
	}
	
	public Command move() {
		return QuickCommand.continuous(this, () -> motor.setSpeed(Robot.oi.leftOperator().getY()));
	}
	
	public void showInfo() {
		SmartDashboard.putNumber("Shoulder Potentiometer", potentiometer.get());
	}
}
