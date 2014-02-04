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
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addSequential(new Rotate(direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_WALL));
        addSequential(new Rotate(-direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_GOAL));
        addSequential(getOI().getPushBallCommand());
    }
}
