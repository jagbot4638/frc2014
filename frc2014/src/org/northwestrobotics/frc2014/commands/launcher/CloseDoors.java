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
 *
 * @author Jill
 */
public class CloseDoors extends CommandBase {
    private final Timer timer = new Timer();
    
    public CloseDoors() {
        requires(launcher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.startClosingDoors();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() < RobotMap.Launcher.TIME_TO_CLOSE_DOORS;
    }

    // Called once after isFinished returns true
    protected void end() {
        timer.stop();
        launcher.stopClosingDoors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
