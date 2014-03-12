/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 FRC Team #4638 (Northwest Jagbotics)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.northwestrobotics.frc2014.commands.autonomous;

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.commands.CommandGroupBase;
import org.northwestrobotics.frc2014.commands.launcher.HaltDoors;
import org.northwestrobotics.frc2014.commands.launcher.LaunchBall;

/**
 * Turn and score command
 * 
 * Makes the robot turn and score the ball in the low goal.
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class TurnAndScore extends CommandGroupBase
{
    /**
     * Makes the robot turn and score in the low goal.
     * 
     * @param direction The direction to turn in
     */
    public TurnAndScore(int direction) {
        addSequential(new Rotate(direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_WALL));
        addSequential(new Rotate(-direction));
        addSequential(new DriveStraight(RobotMap.Direction.FORWARD, RobotMap.Autonomous.TIME_TO_REACH_GOAL));
        addSequential(new LaunchBall(RobotMap.LauncherGamepad.SHOOT_BALL_COMMAND));
        addSequential(
                new CommandBase() {{setTimeout(RobotMap.Time.TIME_TO_SHOOT_BALL);}});
        addSequential(new HaltDoors());
    }
}
