/*
The MIT License (MIT)

Copyright (c) 2014 Northwest Jagbotics 4638

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/


package org.northwestrobotics.frc2014.commands.autonomous;

import org.northwestrobotics.frc2014.RobotMap;

/**
 * Drives the robot in the given direction.
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 * @author Joshua Fleming <josofl12@gmail.com>
 */
public class DriveStraight extends DirectionalCommand {
    /**
     * Constructs a command that makes the robot move in the given direction for the amount of time
     * specified.
     * @param direction The direction to move in.
     * @param timeRequired The amount of time to move in the given direction for 
     */
    public DriveStraight(int direction, int timeRequired) {
        super(direction, timeRequired);
    }
    
    /**
     * Constructs a command that makes the robot move in the given direction for a default time span.
     * @param direction The direction to move in.
     */
    public DriveStraight(int direction) {
        this(direction, RobotMap.Autonomous.TIME_TO_DRIVE_STRAIGHT);
    }

    protected void commence() {
        drivetrain.tankMove(getDirection(), getDirection());
    }
    
    
}
