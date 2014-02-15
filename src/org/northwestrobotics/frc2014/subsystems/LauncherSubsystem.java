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

package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.launcher.UpdatePressure;
import org.northwestrobotics.frc2014.utils.MessageWindow;

/**
 * LauncherSubsystem subsystem.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class LauncherSubsystem extends Subsystem 
{
    private final SpeedController leftDoor = new Talon(RobotMap.Motor.LEFT_WINCH_MOTOR);
    private final SpeedController rightDoor = new Talon(RobotMap.Motor.RIGHT_WINCH_MOTOR);    
    private final Solenoid hardStop = new Solenoid(RobotMap.Pneumatic.HARD_STOP);
    private final Compressor compressor = new Compressor(RobotMap.Pneumatic.PRESSURE_SWITCH, RobotMap.Pneumatic.COMPRESSOR);
    private final Relay doorLatch = new Relay(RobotMap.Relay.LATCH_RELAY);
    
    public void initDefaultCommand() {
        retractDoorLatches();
        extendHardStop();
        launchBall(50);
        setDefaultCommand(new UpdatePressure());
    }
    
    /**
     * Extends hard stop.
     */
    public void extendHardStop() {
        hardStop.set(true);
    }
    
    /**
     * Retracts hard stop.
     */
    public void retractHardStop() {
        hardStop.set(false);
    }
    
    /**
     * Retracts door latches.
     */
    public void retractDoorLatches() {
        MessageWindow.write(4, "Ret door latch");
        doorLatch.set(Relay.Value.kOn);
    }
    
    private void setDoorMotors(double speed) {
        leftDoor.set(speed);
        rightDoor.set(-speed);
    }
    
    /**
     * Launches ball with a force.
     * 
     * @param force Force the doors close (0 - 100)
     */
    public void launchBall(int force) {
        // Limits speed to max value of 100 and min value of 0
        force = Math.min(force, 100);
        force = Math.max(force, 0);
        
        if(force > 0) {
            setDoorMotors(force / 100.0);
        }
    }
    
    /**
     * Opens doors.
     */
    public void openDoors() {
        setDoorMotors(0);
    }
    
    /**
     * Closes doors.
     * 
     * @param force The force to close with (0-100)
     */
    public void closeDoors(int force) {
        setDoorMotors(force / 100.0);
    }
    
    /**
     * Halts doors.
     */
    public void haltDoors() {
        leftDoor.set(0);
        rightDoor.set(0);
    }
    
    /**
     * Checks if the launcher doors are closed.
     * 
     * @return boolean If launcher doors are closed
     */
    public boolean isHalted() {
        return leftDoor.get() > 0 && rightDoor.get() > 0;
    }
    
    /**
     * Returns the subsystem's compressor object.
     * 
     * @return Compressor The compressor object 
     */
    public Compressor getCompressor() {
        return compressor;
    }
}