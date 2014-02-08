/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 *
 * @author Joshua Fleming <js.fleming@outlook.com>
 */
public class PickUpBall extends TimedCommand 
{    
    public PickUpBall() {
        super(RobotMap.Launcher.TIME_TO_CLOSE_DOORS);
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void commence() {
        launcher.startClosingDoors();
    }

    // Called once after isFinished returns true
    protected void cease() {
        launcher.stopClosingDoors();
    }
}
