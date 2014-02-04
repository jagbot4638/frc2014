/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.autonomous;

import org.northwestrobotics.frc2014.RobotMap;

/**
 *
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 * @author Joshua Fleming <josofl12@gmail.com>
 */
public class DriveStraight extends DirectionalCommand {
    
    public DriveStraight(int direction, int timeRequired) {
        super(direction, timeRequired);
    }
    
    public DriveStraight(int direction) {
        this(direction, RobotMap.Autonomous.TIME_TO_DRIVE_STRAIGHT);
    }

    protected void commence() {
        drivetrain.tankMove(getDirection(), getDirection());
    }
    
    
}
