package org.usfirst.frc.team69.robot;

import static org.usfirst.frc.team69.robot.Robot.lifter;
import static org.usfirst.frc.team69.robot.Robot.shoulder;
import static org.usfirst.frc.team69.robot.units.DistanceUnit.*;

import org.hyperonline.hyperlib.oi.MapJoystick;
import org.hyperonline.hyperlib.oi.MapJoystick.Role;
import org.hyperonline.hyperlib.oi.MapJoystick.Type;
import org.hyperonline.hyperlib.oi.WhenPressed;
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
    	@WhileHeld(1) public final Command moveShoulder = shoulder.move();
    }
    
    @MapJoystick(port = 3, role = Role.RIGHT_OPERATOR, type = Type.LOGITECH_2_AXIS)
    public static class RightOperator {
    	@WhileHeld(1) public final Command moveLifter = lifter.move(Robot.oi.rightOperator());
    	@WhenPressed(8) public final Command resetLifterEncoder = lifter.resetEncoder();
    	
    	//@WhenPressed(9) public final Command pidTest = lifter.moveTo(6, INCHES);
    	@WhenPressed(4) public final Command pidTest0 = lifter.moveToPreference(lifter.position0, INCHES);
    	@WhenPressed(5) public final Command pidTest1 = lifter.moveToPreference(lifter.position1, INCHES);
    }
}
