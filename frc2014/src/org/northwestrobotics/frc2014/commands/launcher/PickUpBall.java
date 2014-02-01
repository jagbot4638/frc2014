/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Launcher;

/**
 * Closes the doors with an activated hard stop, and thus grabs the ball.  
 * @author Joshua
 */
public class PickUpBall extends CommandBase {
    
    public PickUpBall() {
        requires(launcher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.activateHardStop();
        launcher.openDoors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //launcher.launchBall();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return launcher.isClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
