package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.port.Port;
import org.hyperonline.hyperlib.port.Port.Type;

public class RobotMap {
	
	public static class Drive {
        @Port(type = Type.PWM) public static final int LEFT_DRIVE = 0;
        @Port(type = Type.PWM) public static final int RIGHT_DRIVE = 1;
    }
	
	public static class Grippah {
		@Port(type = Type.PCM) public static final int SOLENOID = 2;
	}
}
