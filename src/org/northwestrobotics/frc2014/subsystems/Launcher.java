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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.launcher.UpdatePressure;

/**
 *
 * @author Saagar
 */
public class Launcher extends Subsystem 
{
    private final SpeedController leftDoor = new Talon(RobotMap.Launcher.LEFT_DOOR_CHANNEL);
    private final SpeedController rightDoor = new Talon(RobotMap.Launcher.RIGHT_DOOR_CHANNEL);    
    private final Solenoid hardStop = new Solenoid(RobotMap.Launcher.HARD_STOP_CHANNEL);
    
    public void initDefaultCommand() {
        activateHardStop();
        launchBall(50);
        setDefaultCommand(new UpdatePressure());
    }
    
    public void activateHardStop() {
        hardStop.set(true);
    }
    
    public void releaseHardStop() {
        hardStop.set(false);
    }
    
    /**
     * Closes doors. Pushing/launching out the ball
     * @param speed Force the doors close (0 - 100)
     */
    public void launchBall(int speed) {
        // Limits speed to max value of 100 and min value of 0
        speed = Math.min(speed, 100);
        speed = Math.max(speed, 0);
        
        if(speed > 0) {
            leftDoor.set(speed / 100.0);
            rightDoor.set(speed / 100.0);
        }
    }
    
    /**
     * Opens doors.
     */
    public void openDoors() {
        leftDoor.set(RobotMap.Door.OPEN_SPEED);
        rightDoor.set(RobotMap.Door.OPEN_SPEED);
    }
    
    /**
     * Closes doors.
     */
    public void closeDoors() {
        leftDoor.set(RobotMap.Door.CLOSE_SPEED);
        rightDoor.set(RobotMap.Door.CLOSE_SPEED);
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
}