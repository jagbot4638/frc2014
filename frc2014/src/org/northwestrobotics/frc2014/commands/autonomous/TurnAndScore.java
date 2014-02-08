/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandGroupBase;

/**
 *
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class TurnAndScore extends CommandGroupBase
{
    
    public TurnAndScore(int direction) {
        addSequential(new Rotate(direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_WALL));
        addSequential(new Rotate(-direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_GOAL));
        addSequential(getOI().getShootBallCommand());
    }
}
