package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.port.Port;
import org.hyperonline.hyperlib.port.Port.Type;

public class RobotMap {
	
	public static class Drive {
        @Port(type = Type.PWM) public static final int LEFT_DRIVE = 0;
        @Port(type = Type.PWM) public static final int RIGHT_DRIVE = 1;
    }
	
	public static class Grippah {
		@Port(type = Type.PCM) public static final int SOLENOID_FORWARD = 2;
		@Port(type = Type.PCM) public static final int SOLENOID_REVERSE = 3;
	}
	
	public static class Lifter {
		@Port(type = Type.PWM) public static final int MOTOR = 4;
	}
	
	public static class Shoulder {
		@Port(type = Type.PWM) public static final int SHOULDER = 2;
	}
	
	public static class Ramp {
		@Port(type = Type.PCM) public static final int SOLENOID = 3;
		@Port(type = Type.PCM) public static final int SOLENOID_LEFT = 4;
		@Port(type = Type.PCM) public static final int SOLENOID_RIGHT = 5;
	}
}
