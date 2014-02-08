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
