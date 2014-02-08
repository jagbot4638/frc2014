/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 FRC Team #4638 (Northwest Jagbotics)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.northwestrobotics.frc2014.commands.launcher.PickUpBall;
import org.northwestrobotics.frc2014.commands.launcher.PushBall;

/**
 * Operator interface class
 * 
 * Binds controller buttons to commands and command groups.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class OI 
{
    // Gamepad objects
    private final Joystick driverGamepad = new Joystick(RobotMap.Gamepad.DRIVER_GAMEPAD);
    private final Joystick actuatorGamepad = new Joystick(RobotMap.Gamepad.ACTUATOR_GAMEPAD);
    
    // Actuator's gamepad button bindings
    private final Button shootTrigger = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.SHOOT_TRIGGER);
    private final Button passButton = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.PASS_BUTTON);
    private final Button retrieveButton = new JoystickButton(actuatorGamepad, RobotMap.Gamepad.RETRIEVE_BUTTON);
    
    // ???
    private final Command shootBallCommand;
    
    /**
     * Creates the operator interface and binds controller buttons.
     */
    public OI() {
        shootTrigger.whenReleased(shootBallCommand = new PushBall(RobotMap.Launcher.SHOOT_FORCE));
        passButton.whenReleased(new PushBall(RobotMap.Launcher.PASS_FORCE));
        retrieveButton.whenReleased(new PickUpBall());
    }
    
    /**
     * Returns the command that instructs the robot to shoot the ball.
     * 
     * @return The command
     */
    public Command getShootBallCommand() {
        return shootBallCommand;
    }
    
    /**
     * Gets the value of the left stick on the gamepad.
     * 
     * @return Left stick value
     */
    public double getLeftSpeed() {
        return -driverGamepad.getRawAxis(RobotMap.Gamepad.LEFT_AXIS);
    }
    
    /**
     * Gets the value of the right stick on the gamepad.
     * 
     * @return Right stick value
     */
    public double getRightSpeed() {
        return -driverGamepad.getRawAxis(RobotMap.Gamepad.RIGHT_AXIS);
    }
}