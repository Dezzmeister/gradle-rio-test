package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.HYPERRobot;
import org.hyperonline.hyperlib.oi.OI;

public class Robot extends HYPERRobot {
	
	public static OI oi;
	
	@Override
	protected void initOI() {
		oi = new OI(OIMap.class, true);

	}

	@Override
	protected void initSubsystems() {
		// TODO Auto-generated method stub

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
