package org.usfirst.frc.team69.robot.subsystems;

import org.hyperonline.hyperlib.QuickCommand;
import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends Subsystem {
	
	private SpeedController leftController = new VictorSP(RobotMap.Drive.LEFT_DRIVE);
	private SpeedController rightController = new VictorSP(RobotMap.Drive.RIGHT_DRIVE);
	
	private DifferentialDrive robotDrive = new DifferentialDrive(leftController, rightController);
			
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(driveCommand());		
	}
	
	public Command driveCommand() {
		return QuickCommand.continuous(this, () -> robotDrive.tankDrive(Robot.oi.leftDriver().getY(), Robot.oi.rightDriver().getY()));
	}
	
	public Command stopCommand() {
		return QuickCommand.continuous(this, () -> robotDrive.tankDrive(0, 0));
	
	}
	public Command cartdrive() {
		return QuickCommand.continuous(this, ()-> robotDrive.ca)
	}

	
	//Joe is god
}
