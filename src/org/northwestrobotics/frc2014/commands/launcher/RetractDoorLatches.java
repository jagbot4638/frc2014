/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class RetractDoorLatches extends CommandBase {
    
    public RetractDoorLatches() {
        setTimeout(RobotMap.Time.LATCH_RELEASE_TIME);
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.retractDoorLatches();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.deactivateDoorLatches();
    }
}
