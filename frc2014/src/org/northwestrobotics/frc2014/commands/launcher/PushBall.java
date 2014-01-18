/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.launcher;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.CommandBase;

/**
 *
 * @author Joshua
 */
public class PushBall extends CommandBase {
    private final Timer timer = new Timer();
     private final SpeedController leftDoor = new Talon(RobotMap.Launcher.LEFT_DOOR_CHANNEL);
    private final SpeedController rightDoor = new Talon(RobotMap.Launcher.RIGHT_DOOR_CHANNEL);
    public PushBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        leftDoor.set(0); //TODO: Figure out speed of motors
        rightDoor.set(0); //TODO: Figure out speed of motors
        timer.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO: Find time it takes after the ball shoots
        return leftDoor.get() == 0 && rightDoor.get() == 0 && timer.get() > 1000000; //microseconds
    }

    // Called once after isFinished returns true
    protected void end() {
       leftDoor.set(1);
       rightDoor.set(1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
