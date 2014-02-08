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
