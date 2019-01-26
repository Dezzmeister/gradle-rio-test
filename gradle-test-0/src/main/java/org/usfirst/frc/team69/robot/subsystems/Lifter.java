package org.usfirst.frc.team69.robot.subsystems;

import java.util.function.DoubleSupplier;

import org.hyperonline.hyperlib.CommandBuilder;
import org.hyperonline.hyperlib.PeriodicScheduler;
import org.hyperonline.hyperlib.QuickCommand;
import org.hyperonline.hyperlib.pid.PrefPIDController;
import org.hyperonline.hyperlib.pref.DoublePreference;
import org.hyperonline.hyperlib.pref.PreferencesSet;
import org.usfirst.frc.team69.robot.RobotMap;
import org.usfirst.frc.team69.robot.units.DistanceUnit;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lifter extends Subsystem {
	private Talon motor;
	private Encoder encoder;
	private PrefPIDController pid;
	
	private PreferencesSet preferences;
	
	public DoublePreference position0;
	public DoublePreference position1;
	
	private static final float ENCODER_TO_INCHES_SCALE_FACTOR = -65.624f;
	
	public Lifter() {
		
		motor = new Talon(RobotMap.Lifter.MOTOR);
		encoder = new Encoder(RobotMap.Lifter.ENCODER_A, RobotMap.Lifter.ENCODER_B);
		pid = new PrefPIDController(getName(), 0.01f, 0.0f, 0.0f, encoder, motor);
		preferences = new PreferencesSet(getName());
		
		position0 = preferences.addDouble("Lifter Position 0", 6);
		position1 = preferences.addDouble("Lifter Position 1", 12);
		
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
		setDefaultCommand(stopAndHold());
	}
	
	public Command stop() {
		return QuickCommand.oneShot(this, () -> motor.set(0));
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
	
	public Command pidHold() {
		return QuickCommand.pidHold(this, pid, encoder);
	}
	
	public Command stopAndHold() {
		return new CommandBuilder()
					.parallel(stop())
					.sequential(pidHold())
					.build();
	}
	
	public Command moveToPreference(DoublePreference preference, DistanceUnit unit) {
		return moveTo(preference.get(), unit);
	}
	
	public Command resetEncoder() {
		return QuickCommand.oneShot(this, () -> encoder.reset());
	}
	
	public void showInfo() {
		SmartDashboard.putNumber(getName() + " Encoder Distance", encoder.getDistance());
		SmartDashboard.putNumber(getName() + " Encoder Rate", encoder.getRate());
	}
}
