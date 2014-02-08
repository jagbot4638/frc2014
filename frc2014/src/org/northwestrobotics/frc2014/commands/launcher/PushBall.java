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
 * @author Joshua Fleming
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class PushBall extends TimedCommand
{   
    private final int launchForce;
    public PushBall(int launchForce) {
        super(RobotMap.Launcher.TIME_TO_LAUNCH_BALL);
        requires(launcher);
        this.launchForce = launchForce;
    }
    
    public PushBall() {
        this(100);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void commence() {
        // Release hard stop
        launcher.releaseHardStop();
        
        // Launch ball
        launcher.launchBall(launchForce);
        
    }

    /** 
     * Called once after isFinished returns true
     */
    protected void cease() {
       launcher.openDoors();
       launcher.activateHardStop();
    }
}
