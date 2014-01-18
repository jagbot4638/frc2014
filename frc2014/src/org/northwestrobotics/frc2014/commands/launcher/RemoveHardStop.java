/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Solenoid;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Launcher;

/**
 * Removes the hard stop inside the robot to allow ball movement.
 * @author Joshua
 */
public class RemoveHardStop extends CommandBase {
    private final Launcher launcher;
    
    public RemoveHardStop(Launcher launcher) {
        this.launcher = launcher;
        requires(launcher);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        //Sets the piston to a "retracted" position.
        launcher.getHardStop().set(false);
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        //End the RemoveHardStop command when the piston is retracted.
        return !launcher.getHardStop().get();
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same 
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
