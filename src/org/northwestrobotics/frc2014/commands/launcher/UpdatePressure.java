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

package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.Compressor;
import org.northwestrobotics.frc2014.commands.CommandBase;

/**
 * Update pressure command.
 * 
 * Updates the pressure of the compressor if it is less than full.
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 */
public class UpdatePressure extends CommandBase
{   
    public UpdatePressure() {}

    /**
     * Initializes the command.
     */
    protected void initialize() {}

    /**
     * Executes the command.
     */
    protected void execute() {
        /*
        Compressor compressor = launcher.getCompressor();
        
        if(compressor.getPressureSwitchValue() && compressor.enabled()) {
            compressor.stop();
        } else if(!compressor.enabled() && !compressor.getPressureSwitchValue()) {
            compressor.start();
        }
        * */
    }

    /**
     * Called after the command ends.
     */
    protected void end() {}

    /**
     * Called if the command is interrupted by another command.
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