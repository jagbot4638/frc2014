/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.drivetrain;

import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.subsystems.Drivetrain;

/**
 *
 * @author Saagar
 */
public class TeleOpDrive extends CommandBase {
    public TeleOpDrive() {
        requires(drivetrain);
    }

    /**
     * Called just before this Command runs the first time.
     * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
     */
    protected void initialize() {
        
    }

    /**
     * Called repeatedly when this Command is scheduled to run.
     * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
     */
    protected void execute() {
        drivetrain.tankMove(oi.getLeftSpeed(), oi.getRightSpeed());
        
        
    }

    /**
     * Returns true when this Command no longer needs to run execute()
     * @return true when this Command no longer needs to run execute()
     * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true.
     * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
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
