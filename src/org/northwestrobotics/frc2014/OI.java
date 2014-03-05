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
import org.northwestrobotics.frc2014.commands.CommandBase;
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
    private final Button openDoorsButton = new JoystickButton(
            launcherGamepad, RobotMap.LauncherGamepad.Y_BUTTON);
    
    // Driver's buttons
    private final Button minuteLeftTurnButton = new JoystickButton(
            driverGamepad, RobotMap.DriverGamepad.X_BUTTON);
    private final Button minuteRightTurnButton = new JoystickButton(
            driverGamepad, RobotMap.DriverGamepad.B_BUTTON);
    
    
    // Commands
    private final Command shootCommand;
    private final Command passCommand;
    private final Command grabCommand;
    
    
    private double previousDriveTrainMoveValue = 0;
    

    
    /**
     * Creates the operator interface and binds controller buttons.
     */
    public OI() {
        // Actuator's bindings
        shootButton.whenReleased(shootCommand = new LaunchBall(RobotMap.LauncherGamepad.SHOOT_BALL_COMMAND));
        passButton.whenReleased(passCommand = new LaunchBall(RobotMap.LauncherGamepad.PASS_BALL_COMMAND));
        grabButton.whenReleased(grabCommand = new GrabBall());
        openDoorsButton.whenReleased(
                new CommandBase() {
                    {
                        requires(launcher);
                    }
                    protected void initialize() {
                        launcher.openDoors();
                    }
                    
                    protected boolean isFinished() {
                        return true;
                    }
                });
        
        // Driver's bindings
        // ???
    }
    
    public final double getMoveValue() {          
        //just return value as it is now to use the
        //old way of getting trigger input
        double value = -driverGamepad.getZ();
        
        //limit the maximum power that the drivetrain that can output
        value *= RobotMap.Force.MAX_DRIVETRAIN_VALUE;
        
        double triggerDelta = value - previousDriveTrainMoveValue;
        if (triggerDelta > RobotMap.DriverGamepad.MAX_TRIGGER_DELTA){
            value = previousDriveTrainMoveValue + RobotMap.DriverGamepad.MAX_TRIGGER_DELTA;
            System.out.println("Limiting Acceleration...");
        }
        else if (triggerDelta < -RobotMap.DriverGamepad.MAX_TRIGGER_DELTA){
            value = previousDriveTrainMoveValue - RobotMap.DriverGamepad.MAX_TRIGGER_DELTA;
            System.out.println("Limiting Acceleration...");
        }
        
        //ensure that the value is within the acceptable range
        //-MAX_DRIVETRAIN_VALUE < value < MAX_DRIVETRAIN_VALUE
        value = Math.max(value, -RobotMap.Force.MAX_DRIVETRAIN_VALUE);
        value = Math.min(value, RobotMap.Force.MAX_DRIVETRAIN_VALUE);
        
        
        System.out.println("Drivetrain Move Value: " + value + 
                " (FORCING DRIVETRAIN TO 0 FOR TESTING)");
        
        previousDriveTrainMoveValue = value;
        return 0; //returning 0 for safety; check output before returning value
    }
    
    public final double getRotateValue() {
        return -driverGamepad.getX();
    }
    
    /**
     * Test if the minute turn left button is pressed
     * 
     * @return value of minute left turn button
     */
    public boolean isMinuteLeftTurnButtonDown(){
        return minuteLeftTurnButton.get();
    }
    
    /**
     * Test if the minute right turn button is pressed
     * 
     * @return value of minute right turn value
     */
    public boolean isMinuteRightTurnButtonDown(){
        return minuteRightTurnButton.get();
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
     * Gets the value of the left stick from the diverGamepad.
     * 
     * @return Left stick value
     */
    public double getDriverLeftStickValue() {
        return -driverGamepad.getRawAxis(RobotMap.DriverGamepad.LEFT_STICK);
    }
    
    /**
     * Gets the value of the right stick from the driverGamepad.
     * 
     * @return Right stick value
     */
    public double getDriverRightStickValue() {
        return -driverGamepad.getRawAxis(RobotMap.DriverGamepad.RIGHT_STICK);
    }
    
    
    /**
     * Gets the value of the left stick from the launcherGamepad.
     * 
     * @return Left stick value
     */
    public double getLauncherLeftStickValue() {
        return -launcherGamepad.getRawAxis(RobotMap.DriverGamepad.LEFT_STICK);
    }
    
    /**
     * Gets the value of the right stick from the launcherGamepad.
     * 
     * @return Right stick value
     */
    public double getLauncherRightStickValue() {
        return -launcherGamepad.getRawAxis(RobotMap.DriverGamepad.RIGHT_STICK);
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