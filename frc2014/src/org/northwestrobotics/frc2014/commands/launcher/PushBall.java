/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Timer;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 * Pushes the ball from inside of the robot through the other side.
 * 
 * @author Joshua
 */
public class PushBall extends TimedCommand
{   
    public PushBall() {
        super(RobotMap.Launcher.TIME_TO_LAUNCH_BALL);
        requires(launcher);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void commence() {
        // Release hard stop
        launcher.releaseHardStop();
        
        // Launch ball
        launcher.launchBall(100);
        
    }

    /** 
     * Called once after isFinished returns true
     */
    protected void cease() {
       launcher.openDoors();
       launcher.activateHardStop();
    }
}
