/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Launcher;

/**
 * Activates a pneumatic piston that stops the ball from moving through the 
 * robot.
 * @author Joshua
 */
public class ActivateHardStop extends CommandBase {
        private final Launcher launcher;

    public ActivateHardStop(Launcher launcher) {
        this.launcher = launcher;
        requires(launcher);

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    /**
     * Called just before this Command runs the first time.
     */
    protected void initialize() {
    }

    /** 
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        //Sets the position of the piston to "extended."
        launcher.getHardStop().set(true);
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        //Stops the ActivateHardStop command when the piston is extended.
        return launcher.getHardStop().get();
    }

    /** Called once after isFinished returns true */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
