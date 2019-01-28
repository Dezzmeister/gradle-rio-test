package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.CommandBuilder;
import org.hyperonline.hyperlib.PeriodicScheduler;
import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//246
public class Shoulder extends Subsystem {
	private Talon motor = new Talon(RobotMap.Shoulder.MOTOR);
	private AnalogPotentiometer potentiometer = new AnalogPotentiometer(RobotMap.Shoulder.POTENTIOMETER,360);
	private PIDController pid = new PIDController(0.01f, 0.0f, 0.0f, potentiometer, motor);
	
	public Shoulder() {
		super();
		
		LiveWindow.add(potentiometer);
		
		PeriodicScheduler.getInstance().addEvent(this::showInfo);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(holdTheLine());		
	}
	
	public Command hold() {
		
		return QuickCommand.pidHold(this, pid , potentiometer );
		
		
	}
	
	public Command goTo90Deg () {
		return QuickCommand.pidMove(this, pid, 246. , true);
		
		
	}
	
	public Command stop() {
		// return QuickCommand.continuous(this, () -> motor.set(0));
		return QuickCommand.oneShot(this, () -> motor.setSpeed(0));
	}
	
	public Command move() {
		return QuickCommand.continuous(this, () -> motor.setSpeed(Robot.oi.leftOperator().getY()));
	}
	
	public void showInfo() {
		SmartDashboard.putNumber("Shoulder Potentiometer", potentiometer.get());
	}
	
	public Command holdTheLine() {
		CommandBuilder anything = new CommandBuilder(); 
		anything.sequential(stop());
		anything.sequential(hold());
		return anything.build();
		

	}
	
	
	
}
