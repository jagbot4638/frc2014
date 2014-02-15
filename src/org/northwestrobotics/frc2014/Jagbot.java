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

package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.northwestrobotics.frc2014.commands.CommandBase;
import org.northwestrobotics.frc2014.commands.TestCommand;
import org.northwestrobotics.frc2014.commands.launcher.GrabBall;
import org.northwestrobotics.frc2014.commands.launcher.PassBall;
import org.northwestrobotics.frc2014.commands.launcher.ShootBall;

/**
 * Main robot class
 * 0
 * Initializes the subsystems, commands, and modes of the robot.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 * @author Michael Moghaddam <m.moghaddam385@gmail.com>
 */
public class Jagbot extends IterativeRobot 
{   
    private Command testCommand;
    
    /**
     * Runs robot initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        
        // Add commands to SmartDashboard
        SmartDashboard.putData("Grab", new GrabBall());
        SmartDashboard.putData("Pass", new PassBall(10));
        SmartDashboard.putData("Shoot", new ShootBall(10));
    }

    /**
     * Initializes autonomous mode code.
     */
    public void autonomousInit() {}

    /**
     * Called periodically during autonomous mode.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * Initializes tele-op mode code (ends autonomous mode).
     */
    public void teleopInit() {}

    /**
     * Called periodically during tele-op mode.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testInit() {
        testCommand = new TestCommand();
        testCommand.start();
    }
    
    /**
     * Called periodically during test mode.
     */
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}