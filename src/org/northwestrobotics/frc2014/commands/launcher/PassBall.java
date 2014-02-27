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

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 * Pass ball command
 * 
 * Pushes the ball from inside of the robot through the other side.
 * 
 * @author Joshua Fleming <js.fleming@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class PassBall extends CommandBase
{   
    private final int force;
    
    /**
     * Pushes the ball out of the robot with a given force.
     * 
     * @param force The force to push the ball with (1-100)
     */
    public PassBall(int force) {
        setTimeout(RobotMap.Time.TIME_TO_PASS_BALL);
        requires(launcher);
        this.force = force;
    }

    /**
     * Releases the hard stop and launches the ball.
     */
    protected void initialize() {
        launcher.retractHardStop();
        launcher.launchBall(force);
    }

    /** 
     * Opens the doors and activates the hard stop.
     */
    protected void end() {
       launcher.openDoors();
       launcher.extendHardStop();
    }
}
