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

package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Timer;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.commands.TimeElapsedCommand;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 * Pick up ball command
 * 
 * Makes the robot pick up a ball within range of the doors.
 * 
 * @author Joshua Fleming <js.fleming@outlook.com>
 */
public class GrabBall extends CommandBase //extends TimedCommand 
{   
    
    private Timer timer;
    private boolean timerStarted = false;
    
    public GrabBall() {
        requires(launcher);
        
        timer = new Timer();
    }

    /**
     * Closes the doors slowly.
     */
    protected void initialize() {
        super.initialize();
        //launcher.closeDoors(RobotMap.Force.GRAB_FORCE);
    }

    protected void execute(){
        if (oi.isBallInRobot()){
            launcher.haltDoors();
        }
        else {
            launcher.closeDoors(RobotMap.Force.GRAB_FORCE);
        }
    }
    
    /**
     * command is finished when the grab ball button is no longer pressed
     */
    protected boolean isFinished(){
        if (!oi.isGrabButtonDown()){
            System.out.println("Grab Ball Should Finish");
        }
        return !oi.isGrabButtonDown();
    }
    
    
}