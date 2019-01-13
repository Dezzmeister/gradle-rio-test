package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.oi.MapJoystick;
import org.hyperonline.hyperlib.oi.MapJoystick.Role;
import org.hyperonline.hyperlib.oi.MapJoystick.Type;
import org.hyperonline.hyperlib.oi.WhileHeld;

import edu.wpi.first.wpilibj.command.Command;

public class OIMap {
	@MapJoystick(port = 0, role = Role.LEFT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class LeftDriver {
		
    }

    @MapJoystick(port = 1, role = Role.RIGHT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class RightDriver {
    }
}
