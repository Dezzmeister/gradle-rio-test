package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.HYPERRobot;
import org.hyperonline.hyperlib.oi.OI;
import org.usfirst.frc.team69.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team69.robot.subsystems.Grippah;

public class Robot extends HYPERRobot {
	
	public static OI oi;
	
	public static DriveSubsystem driveSubsystem;
	public static Grippah grippah;
	
	@Override
	protected void initOI() {
		oi = new OI(OIMap.class, true);

	}

	@Override
	protected void initSubsystems() {
		driveSubsystem = new DriveSubsystem();
		grippah = new Grippah();
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
