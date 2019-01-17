package org.usfirst.frc.team69.robot;

import org.hyperonline.hyperlib.oi.MapJoystick;
import org.hyperonline.hyperlib.oi.MapJoystick.Role;
import org.hyperonline.hyperlib.oi.MapJoystick.Type;
import org.hyperonline.hyperlib.oi.WhenPressed;
import org.hyperonline.hyperlib.oi.WhenReleased;
import org.hyperonline.hyperlib.oi.WhileHeld;

import edu.wpi.first.wpilibj.command.Command;

public class OIMap {
	@MapJoystick(port = 0, role = Role.LEFT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class LeftDriver {
		//@WhenPressed(1) public final Command openGrippah = Robot.grippah.openGrippah();
    }

    @MapJoystick(port = 1, role = Role.RIGHT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class RightDriver {
    	//@WhenPressed(1) public final Command closeGrippah = Robot.grippah.closeGrippah();
    }
    
    @MapJoystick(port = 2, role = Role.LEFT_OPERATOR, type = Type.LOGITECH_2_AXIS)
    public static class LeftOperator {
    	@WhileHeld(1) public final Command moveShoulder = Robot.shoulder.move();
    }
    
    @MapJoystick(port = 3, role = Role.RIGHT_OPERATOR, type = Type.LOGITECH_2_AXIS)
    public static class RightOperator {
    	@WhileHeld(1) public final Command moveLifter = Robot.lifter.move();
    }
}
