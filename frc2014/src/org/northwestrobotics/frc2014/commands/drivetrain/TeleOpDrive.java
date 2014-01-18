/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Drivetrain;

/**
 *
 * @author Saagar
 */
public class TeleOpDrive extends CommandBase {
    private final Drivetrain drivetrain;
    
    public TeleOpDrive(Drivetrain drivetrain) {
        requires(drivetrain);
        this.drivetrain = drivetrain;
    }

    /**
     * Called just before this Command runs the first time.
     * @author Saagar
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     * @author Saagar
     */
    protected void execute() {
        drivetrain.takeJoystickInput(oi.getGamepad());
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * Returns true when this Command no longer needs to run execute()
     * @return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true.
     */
    protected void end() {
        drivetrain.stop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     */
    protected void interrupted() {
        end();
    }
}
