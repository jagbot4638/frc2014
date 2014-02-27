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

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.northwestrobotics.frc2014.commands.launcher.GrabBall;
import org.northwestrobotics.frc2014.commands.launcher.PassBall;
import org.northwestrobotics.frc2014.commands.launcher.LaunchBall;

/**
 * Operator interface class
 * 
 * Binds controller buttons to commands and command groups.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class OI 
{
    // Button objects
    private final Joystick driverGamepad =
            new Joystick(RobotMap.DriverGamepad.PORT_NUMBER);
    private final Joystick launcherGamepad =
            new Joystick(RobotMap.LauncherGamepad.PORT_NUMBER);
    
    // Actuator's buttons
    private final Button shootButton = new JoystickButton(launcherGamepad,
            RobotMap.LauncherGamepad.RIGHT_TRIGGER);
    private final Button passButton = new JoystickButton(launcherGamepad,
            RobotMap.LauncherGamepad.B_BUTTON);
    private final Button grabButton = new JoystickButton(launcherGamepad,
            RobotMap.LauncherGamepad.A_BUTTON);
    
    // Driver's buttons
    // ???
    
    // Commands
    private final Command shootCommand;
    private final Command passCommand;
    private final Command grabCommand;
    
    



    
    /**
     * Creates the operator interface and binds controller buttons.
     */
    public OI() {
        // Actuator's bindings
        shootButton.whenReleased(shootCommand = new LaunchBall(RobotMap.LauncherGamepad.SHOOT_BALL_COMMAND));
        passButton.whenReleased(passCommand = new LaunchBall(RobotMap.LauncherGamepad.PASS_BALL_COMMAND));
        grabButton.whenReleased(grabCommand = new GrabBall());
        
        // Driver's bindings
        // ???
    }
    
    public final double getMoveValue() {       
        double value = -driverGamepad.getZ();
        return value;
//        if (driverGamepad.getRawButton(RobotMap.Button.RIGHT_TRIGGER))
//            return 1;
//        else if (driverGamepad.getRawButton(RobotMap.Button.RIGHT_BUMPER))
//            return 0.5;
//        else if (driverGamepad.getRawButton(RobotMap.Button.LEFT_BUMPER))
//            return -0.5;
//        else if (driverGamepad.getRawButton(RobotMap.Button.LEFT_TRIGGER))
//            return -1;
//        else return 0;
    }
    
    public final double getRotateValue() {
        if (driverGamepad.getX() != 0)
            System.out.println("getX: " + driverGamepad.getX());
        return driverGamepad.getX(); //driverGamepad.getRawAxis(RobotMap.Button.LEFT_STICK_X);
    }
    
    /**
     * Returns the force of the pressed shoot speed modifier.
     * 
     * @return int Force of the command (0-100)
     */
    public int getShootForce() {
       int force;

       if(isDpadSouthPressed(launcherGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_LOW;
       } else if(isDpadEastPressed(launcherGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_MED;
       } else if(isDpadNorthPressed(launcherGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_HIGH;
       } else if(isDpadWestPressed(launcherGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_MAX;
       } else {
           force = 0;
       }

       return force;
    }
    
    /**
     * Returns the force of the pressed pass speed modifier.
     * 
     * @return int Force of the command (0-100)
     */
    public int getPassForce() {
       int force;

       System.out.println("DPad X: " + getDpadXValue(launcherGamepad) + " Dpad Y: " + getDpadYValue(launcherGamepad));
       
       if(isDpadSouthPressed(launcherGamepad)) {
           force = RobotMap.Force.PASS_FORCE_LOW;
       } else if(isDpadEastPressed(launcherGamepad)) {
           force = RobotMap.Force.PASS_FORCE_MED;
       } else if(isDpadNorthPressed(launcherGamepad)) {
           force = RobotMap.Force.PASS_FORCE_HIGH;
       } else if(isDpadWestPressed(launcherGamepad)) {
           force = RobotMap.Force.PASS_FORCE_MAX;
       } else {
           force = 0;
       }

       return force;
    }
    
    /**
     * Returns the command that shoots the ball.
     * 
     * @return The command
     */
    public Command getShootCommand() {
        return shootCommand;
    }

    /**
     * Returns the command that passes the ball.
     * 
     * @return The command
     */
    public Command getPassCommand() {
        return passCommand;
    }

    /**
     * Returns the command that grabs the ball.
     * 
     * @return The command
     */
    public Command getGrabCommand() {
        return grabCommand;
    }
    
    /**
     * Gets the value of the left stick from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return Left stick value
     */
    public double getLeftStickValue(Joystick gamepad) {
        return -gamepad.getRawAxis(RobotMap.DriverGamepad.LEFT_STICK);
    }
    
    /**
     * Gets the value of the right stick from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return Right stick value
     */
    public double getRightStickValue(Joystick gamepad) {
        return -gamepad.getRawAxis(RobotMap.DriverGamepad.RIGHT_STICK);
    }
    
    
    /**
     * Gets the value of the D-pad X direction from a gamepad
     * 
     * @param gamepad The gamepad to get the value from
     * @return  the value of the D-pad in the X direction
     */
    public double getDpadXValue(Joystick gamepad) {
        return gamepad.getRawAxis(RobotMap.LauncherGamepad.D_PAD_X);
    }
    
    /**
     * Gets the value of the D-Pad Y direction from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return The value of the D-Pad in the Y direction
     */
    public double getDpadYValue(Joystick gamepad) {
        return gamepad.getRawAxis(RobotMap.LauncherGamepad.D_PAD_Y);
    }

    /**
     * Checks if the D-Pad north button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadNorthPressed(Joystick gamepad) {
        double dpadVal = getDpadYValue(gamepad);
        return (dpadVal == -1);
    }
    
    /**
     * Checks if the D-Pad south button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadSouthPressed(Joystick gamepad) {
        double dpadVal = getDpadYValue(gamepad);
        return (dpadVal == 1);
    }
    
    /**
     * Checks if the D-Pad east button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadEastPressed(Joystick gamepad) {
        double dpadVal = getDpadXValue(gamepad);
        return (dpadVal == 1);
    }
    
    /**
     * Checks if the D-Pad north button is pressed.
     * 
     * @param gamepad The west to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadWestPressed(Joystick gamepad) {
        double dpadVal = getDpadXValue(gamepad);
        return (dpadVal == 1);
    }
}