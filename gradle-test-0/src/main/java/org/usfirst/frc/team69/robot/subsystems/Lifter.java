package org.usfirst.frc.team69.robot.subsystems;

import java.util.function.DoubleSupplier;

import org.hyperonline.hyperlib.PeriodicScheduler;
import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.RobotMap;
import org.usfirst.frc.team69.robot.units.DistanceUnit;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifter extends Subsystem {
	private Talon motor = new Talon(RobotMap.Lifter.MOTOR);
	private Encoder encoder = new Encoder(RobotMap.Lifter.ENCODER_A, RobotMap.Lifter.ENCODER_B);
	private PIDController pid = new PIDController(0.01f, 0.0f, 0.0f, encoder, motor);
	
	private static final float ENCODER_TO_INCHES_SCALE_FACTOR = -62.89f;
	
	public Lifter() {
		
		pid.setAbsoluteTolerance(5);
		pid.setOutputRange(-0.5, 0.75);
		pid.disable();
		
		LiveWindow.add(motor);
		LiveWindow.add(encoder);
		LiveWindow.add(pid);
		
		PeriodicScheduler.getInstance().addEvent(this::showInfo);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(stop());
	}
	
	public Command stop() {
		return QuickCommand.continuous(this, () -> motor.set(0));
	}
	
	public Command move(Joystick j) {
		return QuickCommand.continuous(this, () -> motor.set(j.getY()/((j.getY() > 0) ? 3.0f : 2.0f)));
	}
	
	public Command moveTo(double value, DistanceUnit unit) {
		DoubleSupplier supplier;
		
		switch (unit) {
			default:
			case NONE:
				supplier = () -> value;
				break;
			case INCHES:
				supplier = () -> value * ENCODER_TO_INCHES_SCALE_FACTOR;
				break;
		}
		return QuickCommand.pidMoveContinuous(this, pid, supplier, true);
	}
	
	public Command stupidPIDMoveCommand(Joystick j) {
		
		return QuickCommand.pidMoveContinuous(this, pid, () -> {
			for (int i = 11; i >= 1; i--) {
				if (j.getRawButtonPressed(i)) {
					return i * ENCODER_TO_INCHES_SCALE_FACTOR;
				}
			}
			
			return 0;
		}, true);
	}
	
	public Command resetEncoder() {
		return QuickCommand.continuous(this, () -> encoder.reset());
	}
	
	public void showInfo() {
		SmartDashboard.putNumber("Lifter Encoder Distance", encoder.getDistance());
		SmartDashboard.putNumber("Lifter Encoder Rate", encoder.getRate());
	}
}
