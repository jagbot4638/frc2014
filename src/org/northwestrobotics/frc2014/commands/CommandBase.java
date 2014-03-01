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

package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.northwestrobotics.frc2014.OI;
import org.northwestrobotics.frc2014.subsystems.LauncherSubsystem;
import org.northwestrobotics.frc2014.subsystems.DrivetrainSubsystem;

/**
 * Command base
 * 
 * Initializes commands requested by the operator interface.
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public abstract class CommandBase extends Command 
{
    // Operator interface
    protected static OI oi;
    
    // Subsystems
    protected static DrivetrainSubsystem drivetrain;
    protected static LauncherSubsystem launcher;

    /**
     * Initializes the OI and the subsystems.
     */
    public static void init() {
        drivetrain = new DrivetrainSubsystem();
        launcher = new LauncherSubsystem();
        oi = new OI();
    }
    

    /**
     * Initializes a named command.
     * 
     * @param name The name of the command
     */
    public CommandBase(String name) {
        super(name);
    }

    /**
     * Initializes an un-named command.
     */
    public CommandBase() {
        super();
    } 

    
    
    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}