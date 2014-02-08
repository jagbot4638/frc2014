
package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.northwestrobotics.frc2014.commands.launcher.PickUpBall;
import org.northwestrobotics.frc2014.commands.launcher.PushBall;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // Driver gamepad and button bindings
    private final Joystick driverGamepad = new Joystick(RobotMap.Gamepad.DRIVER_GAMEPAD);
    private final Joystick actuatorGamepad = new Joystick(RobotMap.Gamepad.ACTUATOR_GAMEPAD);
    
    private final Button shootTrigger = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.SHOOT_TRIGGER);
    private final Button passButton = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.PASS_BUTTON);
    
    private final Button retrieveButton = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.RETRIEVE_BUTTON);
    
    private final Command shootBallCommand;
    
    /**
     * Creates an OI object. Binds the controls on the physical operator interface to the commands.
     */
    public OI() {
        shootTrigger.whenReleased(shootBallCommand = new PushBall(RobotMap.Launcher.SHOOT_FORCE));
        passButton.whenReleased(new PushBall(RobotMap.Launcher.PASS_FORCE));
        
        retrieveButton.whenReleased(new PickUpBall());
    }
    
    /**
     * Returns the command that instructs the robot to shoot the ball.
     * @return The command that instructs the robot to shoot the ball.
     */
    public Command getShootBallCommand() {
        return shootBallCommand;
    }
    
    /**
     * Gets the value of the left component for tank drive. In other words, the left stick's vertical axis.
     * @return The value of the left component for tank drive. In other words, the left stick's vertical axis.
     */
    public double getLeftSpeed() {
        return -driverGamepad.getRawAxis(RobotMap.Gamepad.LEFT_AXIS);
    }
    
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
    public double getRightSpeed() {
        return -driverGamepad.getRawAxis(RobotMap.Gamepad.RIGHT_AXIS);
    }
}

