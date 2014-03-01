/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Michael
 */
public abstract class TimeElapsedCommand extends CommandBase {
    private final Timer stopwatch = new Timer();
    private double previousTotalTime = 0.0;
    
    private double timeout;
    
    public TimeElapsedCommand() {
        //stopwatch.start();
    }

    protected void initialize(){
        stopwatch.start();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected final void execute() {
        double seconds = stopwatch.get();
        execute(seconds - previousTotalTime);
        previousTotalTime = seconds;
    }
    
    protected abstract void execute(double timeElapsed);

    protected void end(){
        stopwatch.stop();
        stopwatch.reset();
    }
    
    protected final double getTotalTimeElapsed() {
        return stopwatch.get();
    }
    
    protected final double getTimeLimit() {
        return timeout;
    }
    
    protected final void setTimeLimit(double seconds) {
        timeout = seconds;
        setTimeout(seconds);
    }
}
