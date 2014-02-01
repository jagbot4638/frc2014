/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Timer;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Launcher;

/**
 * Pushes the ball from inside of the robot through the other side.
 * @author Joshua
 */
public class PushBall extends CommandBase 
{   
    private final Timer timer = new Timer();
    
    public PushBall() {
        requires(launcher);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        // Release hard stop
        launcher.releaseHardStop();
        
        // Launch ball
        launcher.launchBall(100);
        timer.start();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * 
     * @return boolean true if the doors are closed and the time needed to shoot the ball has expired
     */
    protected boolean isFinished() {
        return launcher.isClosed() && timer.get() < RobotMap.Launcher.TIME_TO_LAUNCH_BALL;
    }

    /** 
     * Called once after isFinished returns true
     */
    protected void end() {
       launcher.openDoors();
       launcher.activateHardStop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
