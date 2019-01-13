package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.HYPERRobot;
import org.hyperonline.hyperlib.oi.OI;
import org.usfirst.frc.team69.robot.subsystems.DriveSubsystem;

public class Robot extends HYPERRobot {
	
	public static OI oi;
	
	public static DriveSubsystem driveSubsystem;
	
	@Override
	protected void initOI() {
		oi = new OI(OIMap.class, true);

	}

	@Override
	protected void initSubsystems() {
		driveSubsystem = new DriveSubsystem();
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
