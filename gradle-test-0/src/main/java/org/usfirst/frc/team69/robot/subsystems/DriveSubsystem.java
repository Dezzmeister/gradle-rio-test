package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends Subsystem {
	
	private SpeedController leftFrontMotor = new Talon(RobotMap.Drive.LEFT_FRONT_MOTOR);
	private SpeedController leftRearMotor = new Talon(RobotMap.Drive.LEFT_REAR_MOTOR);
	private SpeedController rightFrontMotor = new Talon(RobotMap.Drive.RIGHT_FRONT_MOTOR);
	private SpeedController rightRearMotor = new Talon(RobotMap.Drive.RIGHT_REAR_MOTOR);
	
	private SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
	private SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
	
	private DifferentialDrive robotDrive = new DifferentialDrive(leftGroup, rightGroup);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(driveCommand());
	}
	
	public Command driveCommand() {
		return QuickCommand.continuous(this, () -> robotDrive.tankDrive(Robot.oi.leftDriver().getY(), Robot.oi.rightDriver().getY()));
	}

}
