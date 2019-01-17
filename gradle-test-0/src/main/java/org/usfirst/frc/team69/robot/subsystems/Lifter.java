package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.PeriodicScheduler;
import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifter extends Subsystem {
	private Talon motor = new Talon(RobotMap.Lifter.MOTOR);
	private Encoder encoder = new Encoder(RobotMap.Lifter.ENCODER_A, RobotMap.Lifter.ENCODER_B);
	
	public Lifter() {
		LiveWindow.add(encoder);
		
		PeriodicScheduler.getInstance().addEvent(this::showInfo);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(stop());
	}
	
	public Command stop() {
		return QuickCommand.continuous(this, () -> motor.set(0));
	}
	
	public Command move() {
		return QuickCommand.continuous(this, () -> motor.set(Robot.oi.rightOperator().getY()));
	}
	
	public void showInfo() {
		SmartDashboard.putNumber("Lifter Encoder Distance", encoder.getDistance());
		SmartDashboard.putNumber("Lifter Encoder Rate", encoder.getRate());
	}
}
