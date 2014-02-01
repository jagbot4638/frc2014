
package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.northwestrobotics.frc2014.commands.launcher.PushBall;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Driver gamepad and button bindings
    private final Joystick driverGamepad = new Joystick(RobotMap.Gamepad.DRIVER_GAMEPAD);
    private final Joystick actuatorGamepad = new Joystick(RobotMap.Gamepad.ACTUATOR_GAMEPAD);
    
    private final Button shootTrigger = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.ACTUATOR_TRIGGER);
    
    public OI() {
        shootTrigger.whenReleased(new PushBall());
    }
    
    /**
     * Returns true if the user has pressed the button to shoot.
     * @return whether or not the user has instructed the robot to shoot.
     */
    public boolean isShootButtonPressed() {
        return actuatorGamepad.getTrigger();
    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getLeftSpeed() {
        //return driverGamepad.getY();
        return 0.0 - driverGamepad.getRawAxis(2);
    }
    
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
    public double getRightSpeed() {
        return 0.0 - driverGamepad.getRawAxis(4);
    }
}

