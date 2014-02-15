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

import org.northwestrobotics.frc2014.utils.MessageWindow;

/**
 * Test command
 * 
 * Used for testing robot functionality. NOT FOR PRODUCTION USE.
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 */
public class TestCommand extends CommandBase
{
    public TestCommand() {
        MessageWindow.write("2 - Test cmd");
        requires(launcher);
        
    }

    /**
     * Initializes the command.
     */
    protected void initialize() {}

    /**
     * Executes the command.
     */
    protected void execute() {
        MessageWindow.write("3 - Test exec");
        launcher.retractDoorLatches();
    }

    /**
     * Ends the command.
     */
    protected void end() {}

    /**
     * Called when the command is interrupted by another command.
     */
    protected void interrupted() {}
    
    /**
     * Checks if the command is finished
     * 
     * @return If the command is finished
     */
    protected boolean isFinished() {
        return false;
    }
}
