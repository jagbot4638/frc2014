/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class HaltDoors extends CommandBase {
    
    public HaltDoors() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.haltDoors();
        launcher.extendHardStop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }
    
}
