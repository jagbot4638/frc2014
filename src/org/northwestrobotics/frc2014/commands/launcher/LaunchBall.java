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
 * Push ball command
 * 
 * Pushes the ball from inside of the robot through the other side.
 * 
 * @author Joshua Fleming <js.fleming@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class LaunchBall extends CommandBase {   
    private final int commandType;
    
    /**
     * Pushes the ball out of the robot with a given force.
     * 
     * @param commandType is the ball being pushed out with intent to shoot or pass.
     */
    public LaunchBall(int commandType) {
        requires(launcher);
        this.commandType = commandType;
    }

    /**
     * Releases the hard stop and launches the ball.
     */
    protected void initialize() {
        super.initialize();
        launcher.retractHardStop();
        switch (commandType) {
            case RobotMap.LauncherGamepad.SHOOT_BALL_COMMAND:
                launcher.launchBall(oi.getShootForce());
                break;
            case RobotMap.LauncherGamepad.PASS_BALL_COMMAND:
                launcher.launchBall(oi.getPassForce());
                break;
            default:
                System.out.println("COMMAND TYPE NOT RECOGNIZED: " + commandType);
        }
        
    }
    
    protected boolean isFinished(){
        return true;
    }

}
