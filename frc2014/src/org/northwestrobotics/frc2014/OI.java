
package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Driver gamepad and button bindings
    private final Joystick driverGamepad;
    
    public OI() {
        driverGamepad = new Joystick(RobotMap.Gamepad.DRIVER_GAMEPAD);
    }
    
    public Joystick getDriverGamepad() {
        return driverGamepad;
    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getLeftSpeed() {
        return driverGamepad.getY();
    }
    
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
    public double getRightSpeed() {
        return driverGamepad.getRawAxis(4);
    }
}

