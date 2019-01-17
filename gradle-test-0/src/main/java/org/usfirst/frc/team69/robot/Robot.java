package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.HYPERRobot;
import org.hyperonline.hyperlib.oi.OI;
import org.usfirst.frc.team69.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team69.robot.subsystems.Grippah;
import org.usfirst.frc.team69.robot.subsystems.Lifter;
import org.usfirst.frc.team69.robot.subsystems.Shoulder;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends HYPERRobot {
	
	public static OI oi;
	
	public static DriveSubsystem driveSubsystem;
	//public static Grippah grippah;
	public static Lifter lifter;
	public static Shoulder shoulder;
	
	@Override
	public void testInit() {
		LiveWindow.setEnabled(true);
	}
	
	@Override
	protected void initOI() {
		oi = new OI(OIMap.class, true);
	}

	@Override
	protected void initSubsystems() {
		driveSubsystem = new DriveSubsystem();
		//grippah = new Grippah();
		lifter = new Lifter();
		shoulder = new Shoulder();
	}

	@Override
	protected void initHelpers() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initCommands() {
		oi.initCommands();
	}

}
