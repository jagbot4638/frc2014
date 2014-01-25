/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;

/**
 *
 * @author Saagar
 */
public class Grabber extends Subsystem {
    private final SpeedController leftDoor = new Talon(RobotMap.Launcher.LEFT_DOOR_CHANNEL);
    private final SpeedController rightDoor = new Talon(RobotMap.Launcher.RIGHT_DOOR_CHANNEL);
    private final Solenoid hardStop = new Solenoid(RobotMap.Launcher.HARD_STOP_CHANNEL);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void activateHardStop() {
        hardStop.set(true);
    }
    
    /**
     * Closes doors. Pushing/launching out the ball
     */
    public void closeDoors() {
        leftDoor.set(RobotMap.Grabber.DOOR_CLOSE_SPEED);
        rightDoor.set(RobotMap.Grabber.DOOR_CLOSE_SPEED);
    }
    
    /**
     * Opens doors
     */
    public void openDoors() {
        leftDoor.set(0);
        rightDoor.set(0);
    }
    
    /**
     * Returns true if launcher doors are closed
     * 
     * @return true if launcher doors are closed
     */
    public boolean isClosed() {
        return leftDoor.get() > 0 && rightDoor.get() > 0;
    }
}
