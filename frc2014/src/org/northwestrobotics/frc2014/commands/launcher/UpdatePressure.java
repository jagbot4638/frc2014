/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Compressor;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;

/**
 *
 * @author Joshua
 */
public class UpdatePressure extends CommandBase {
    private final Compressor airCompressor = new Compressor(RobotMap.Launcher.PRESSURE_SWITCH_CHANNEL, RobotMap.Launcher.COMPRESSOR_RELAY_CHANNEL);
    public UpdatePressure() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (airCompressor.getPressureSwitchValue() && airCompressor.enabled()) {
            airCompressor.stop();
        }
        else if (!airCompressor.enabled() && !airCompressor.getPressureSwitchValue()) {
            airCompressor.start();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
