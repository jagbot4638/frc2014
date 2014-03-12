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

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.commands.launcher.GrabBall;
import org.northwestrobotics.frc2014.commands.launcher.HaltDoors;
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
    
    private final AnalogChannel ballSensor = new AnalogChannel(
            RobotMap.AnalogInput.ANALOG_BREAKOUT_MODULE, 
            RobotMap.AnalogInput.BALL_SENSOR_CHANNEL);
    
    // Commands
    private final Command shootCommand;
    private final Command passCommand;
    private final Command grabCommand;
    
    
    private double previousMoveValue = 0;
    private final Command haltDoorsCommand;
    

    
    /**
     * Creates the operator interface and binds controller buttons.
     */
    public OI() {
        // Actuator's bindings
        shootButton.whenPressed(shootCommand = new LaunchBall(RobotMap.LauncherGamepad.SHOOT_BALL_COMMAND));
        shootButton.whenReleased(haltDoorsCommand = new HaltDoors());
        
        passButton.whenPressed(passCommand = new LaunchBall(RobotMap.LauncherGamepad.PASS_BALL_COMMAND));
        passButton.whenReleased(haltDoorsCommand);
        
        grabButton.whenPressed(grabCommand = new GrabBall());
        grabButton.whenReleased(haltDoorsCommand);
        
        
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
        
        double triggerDelta = value - previousMoveValue;
        if (triggerDelta > RobotMap.DriverGamepad.MAX_SPEED_DELTA){
            value = previousMoveValue + RobotMap.DriverGamepad.MAX_SPEED_DELTA;
            if (value > 0.05 && value < RobotMap.Force.MIN_DRIVETRAIN_VALUE){
                value = RobotMap.Force.MIN_DRIVETRAIN_VALUE;
            }
        }
        else if (triggerDelta < -RobotMap.DriverGamepad.MAX_SPEED_DELTA){
            value = previousMoveValue - RobotMap.DriverGamepad.MAX_SPEED_DELTA;
            if (value < -0.05 && value > -RobotMap.Force.MIN_DRIVETRAIN_VALUE){
                value = -RobotMap.Force.MIN_DRIVETRAIN_VALUE;
            }
        }
        
        //ensure that the value is within the acceptable range
        //-MAX_DRIVETRAIN_VALUE < value < MAX_DRIVETRAIN_VALUE
        value = Math.max(value, -RobotMap.Force.MAX_DRIVETRAIN_VALUE);
        value = Math.min(value, RobotMap.Force.MAX_DRIVETRAIN_VALUE);
        
        //System.out.println("Drivetrain Move Value: " + value + 
          //      " (FORCING DRIVETRAIN TO 0 FOR TESTING)");
        
        previousMoveValue = value;
        return value; //returning 0 for safety; check output before returning value
    }
    
    public final double getRotateValue() {
        return -driverGamepad.getX() * RobotMap.DriverGamepad.MAX_TURN_VALUE;
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
     * checks if the ball is in the robot and the arms should 
     * taper off 
     * @return true if the ball is within the robot
     */
    public boolean isBallInRobot(){
        //value is potentially between 0 and 4096 (-10V - 10V)
        //actual input limited to 0-1024 (0V - 5V)
        int sensorValue = ballSensor.getValue();
        
        System.out.println("Ball Sensor Value: " + sensorValue);
        
        if (sensorValue >= RobotMap.AnalogInput.BALL_IN_ROBOT_CUTOFF){
            return true;
        }
        
        return false;
    }
    
    /**
     * returns the state of the grab ball button
     * @return true if the button is down, false otherwise
     */
    public boolean isGrabButtonDown(){
        return grabButton.get();
    }
    
    /**
     * Returns the force of the pressed shoot speed modifier.
     * 
     * @return int Force of the command (0-100)
     */
    public int getShootForce() {
       
       //quick way to calibarte door speeds
       if (RobotMap.Force.GET_FORCE_FROM_SMART_DASHBOARD){ 
           int force = (int) SmartDashboard.getNumber(RobotMap.Force.DOOR_FORCE_KEY); 
           System.out.println("Door Force From SmartDashboard: " + force);
           return force;
       }
        
       if (Jagbot.isInAutonomousMode()){
           return RobotMap.Force.SHOOT_FORCE_MED;
       } else if(isDpadSouthPressed(launcherGamepad)) {
           return RobotMap.Force.SHOOT_FORCE_LOW;
       } else if(isDpadEastPressed(launcherGamepad)) {
           return RobotMap.Force.SHOOT_FORCE_MED;
       } else if(isDpadNorthPressed(launcherGamepad)) {
           return RobotMap.Force.SHOOT_FORCE_HIGH;
       } else if(isDpadWestPressed(launcherGamepad)) {
           return RobotMap.Force.SHOOT_FORCE_MAX;
       } else {
           return 0;
       }
    }
    
    /**
     * Returns the force of the pressed pass speed modifier.
     * @return int Force of the command (0-100)
     */
    public int getPassForce() {

       System.out.println("DPad X: " + getDpadXValue(launcherGamepad) + " Dpad Y: " + getDpadYValue(launcherGamepad));
       
       if(isDpadSouthPressed(launcherGamepad)) {
           return RobotMap.Force.PASS_FORCE_LOW;
       } else if(isDpadEastPressed(launcherGamepad)) {
           return RobotMap.Force.PASS_FORCE_MED;
       } else if(isDpadNorthPressed(launcherGamepad)) {
           return RobotMap.Force.PASS_FORCE_HIGH;
       } else if(isDpadWestPressed(launcherGamepad)) {
           return RobotMap.Force.PASS_FORCE_MAX;
       } else {
           return 0;
       }
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
    public double getDriverRightStickYValue() {
        return -driverGamepad.getRawAxis(RobotMap.DriverGamepad.RIGHT_STICK_Y);
    }
    
    /**
     * Gets the value of the right stick from the driverGamepad.
     * 
     * @return Right stick value
     */
    public double getDriverRightStickXValue() {
        return -driverGamepad.getRawAxis(RobotMap.DriverGamepad.RIGHT_STICK_X);
    }
    
    /**
     * Gets the value of the left stick from the launcherGamepad.
     * 
     * @return Left stick value
     */
    public double getLauncherLeftStickValue() {
        return -launcherGamepad.getRawAxis(RobotMap.LauncherGamepad.LEFT_STICK);
    }
    
    /**
     * Gets the value of the right stick from the launcherGamepad.
     * 
     * @return Right stick value
     */
    public double getLauncherRightStickValue() {
        return -launcherGamepad.getRawAxis(RobotMap.LauncherGamepad.RIGHT_STICK);
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
        return (dpadVal == -1);
    }

    public Command getHaltDoorsCommand() {
        return haltDoorsCommand;
    }
}