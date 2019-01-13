package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.oi.MapJoystick;
import org.hyperonline.hyperlib.oi.MapJoystick.Role;
import org.hyperonline.hyperlib.oi.MapJoystick.Type;
import org.hyperonline.hyperlib.oi.WhenPressed;

import edu.wpi.first.wpilibj.command.Command;

public class OIMap {
	@MapJoystick(port = 0, role = Role.LEFT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class LeftDriver {
		@WhenPressed(1) public final Command openGrippah = Robot.grippah.openGrippah();
    }

    @MapJoystick(port = 1, role = Role.RIGHT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class RightDriver {
    	@WhenPressed(1) public final Command closeGrippah = Robot.grippah.closeGrippah();
    }
    
    public static class LeftOperator {
    	
    }
    
    public static class RightOperator {
    	
    }
}
