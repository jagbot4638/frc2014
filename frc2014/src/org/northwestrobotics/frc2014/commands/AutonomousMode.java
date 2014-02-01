
package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;


public class AutonomousMode extends CommandBase {

    private static final int LEFT_MODE = 0;
    private static final int RIGHT_MODE = 1;
    private static final int FORWARD_MODE = 2;
    private static final int STATIONARY_MODE = 3;
    
    private static final double SLOW_WHEEL_TURN = 0.3;
    private static final double FAST_WHEEL = 1.0;
    private static final double FAST_WHEEL_TURN = 0.5;
    
    private static final double TURN_TIME = 1;
    private static final double LR_TIME = 1;
    private static final double FORWARD_TIME = 1;
    
    
    private final RobotDrive robotDriver;
    
    private final Timer timer;
    private double commandLength;
    
    public AutonomousMode(final RobotDrive robotDriver) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
        this.robotDriver = robotDriver;
        this.timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        int mode = 3;
        
        switch (mode) {
            
            case LEFT_MODE : {
                commandLength = LR_TIME;
                if (timer.get() <= TURN_TIME)
                    robotDriver.tankDrive(SLOW_WHEEL_TURN, FAST_WHEEL_TURN);
                else 
                    robotDriver.tankDrive(FAST_WHEEL, FAST_WHEEL);
                break;
            }
            
            case RIGHT_MODE : {
                commandLength = LR_TIME;
                if (timer.get() <= TURN_TIME)
                    robotDriver.tankDrive(FAST_WHEEL_TURN, SLOW_WHEEL_TURN);
                else 
                    robotDriver.tankDrive(FAST_WHEEL, FAST_WHEEL);
                break;
            }
            
            case FORWARD_MODE : {
                commandLength = FORWARD_TIME;
                robotDriver.tankDrive(FAST_WHEEL, FAST_WHEEL);
                break;
            }
            
            //if the signal is anything unreadable, don't move
            case STATIONARY_MODE : default : {
                commandLength = 0;
                robotDriver.tankDrive(0, 0);
                break;
            }
            
        }
        
    }

    // returns true when the time is greater than the commmandLength
    protected boolean isFinished() {
        //nonochangethe ones thats already there
        return timer.get() >= commandLength;
    }

    // Called once after isFinished returns true
    protected void end() {
        robotDriver.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
