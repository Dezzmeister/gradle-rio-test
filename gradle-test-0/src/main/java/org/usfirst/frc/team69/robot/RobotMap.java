package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.port.Port;
import org.hyperonline.hyperlib.port.Port.Type;

public class RobotMap {
	public static class Drive {
        @Port(type = Type.PWM) public static final int LEFT_FRONT_MOTOR = 0;
        @Port(type = Type.PWM) public static final int LEFT_REAR_MOTOR = 1;
        @Port(type = Type.PWM) public static final int RIGHT_FRONT_MOTOR = 2;
        @Port(type = Type.PWM) public static final int RIGHT_REAR_MOTOR = 3;
    }
}
