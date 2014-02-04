package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Jamison Bryant <jbryant@outlook.com>
 */
public abstract class TimedCommand extends CommandBase
{
    private final Timer stopwatch = new Timer();
    private final int timeRequired;
    
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
    
    protected void cease() {
        
    }

    protected final void interrupted() {
        
    }
    
    
}
