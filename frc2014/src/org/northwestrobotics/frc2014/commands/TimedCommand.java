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

package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public abstract class TimedCommand extends CommandBase
{
    private final Timer stopwatch = new Timer();
    private final int timeRequired;
    
    /**
     * Constructs a command that occurs for a certain period of time.
     * @param timeRequired The period of time to keep this command scheduled for.
     */
    public TimedCommand(int timeRequired) {
        this.timeRequired = timeRequired;
    }
    
    protected final void initialize() {
        commence();
        stopwatch.start();
    }
    
    protected void commence() {
        
    }

    protected final void execute() {
        
    }
    
    
    
    protected final boolean isFinished() {
        return stopwatch.get() < timeRequired;
    }
    
    protected final void end() {
        stopwatch.stop();
        stopwatch.reset();
        
        cease();
    }
    
    /**
     * Occurs after time has run out.
     * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
     */
    protected void cease() {
        
    }

    protected final void interrupted() {
        
    }
    
    
}
