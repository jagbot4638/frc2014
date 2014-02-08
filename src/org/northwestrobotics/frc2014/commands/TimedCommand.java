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

import edu.wpi.first.wpilibj.Timer;

/**
 * Timed command
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public abstract class TimedCommand extends CommandBase
{
    private final Timer stopwatch = new Timer();
    private final int time;
    
    /**
     * Constructs a command that occurs for a certain period of time.
     * 
     * @param time The time to run the command for
     */
    public TimedCommand(int time) {
        this.time = time;
    }
    
    /**
     * Initializes a command.
     */
    protected final void initialize() {
        // Commences command
        commence();
        
        // Start stopwatch
        stopwatch.start();
    }
    
    /**
     * Commences command (overridden by child classes).
     */
    protected void commence() {}

    /**
     * Executes command (overridden by child classes).
     */
    protected final void execute() {}
    
    /**
     * Ends a command.
     */
    protected final void end() {
        stopwatch.stop();
        stopwatch.reset();
        cease();
    }
    
    /**
     * Is run after command time has expired (overridden by child classes).
     */
    protected void cease() {}
    
    /**
     * Is run if a command is interrupted by another command (overridden by child classes).
     */
    protected final void interrupted() {}
    
    /**
     * Returns whether a command has completed or not.
     * 
     * @return If the command is finished
     */
    protected final boolean isFinished() {
        return stopwatch.get() < time;
    }
}