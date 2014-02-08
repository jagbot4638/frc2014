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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.northwestrobotics.frc2014.RobotMap;

/**
 *
 * @author Saagar
 */
public class Launcher extends Subsystem {
    private final SpeedController leftDoor = new Talon(RobotMap.Launcher.LEFT_DOOR_CHANNEL);
    private final SpeedController rightDoor = new Talon(RobotMap.Launcher.RIGHT_DOOR_CHANNEL);    
    private final Solenoid hardStop = new Solenoid(RobotMap.Launcher.HARD_STOP_CHANNEL);
    
    public void initDefaultCommand() {
        activateHardStop();
        launchBall(50);
        //setDefaultCommand(new UpdatePressure());
    }
    
    public void activateHardStop() {
        hardStop.set(true);
    }
    
    public void releaseHardStop() {
        hardStop.set(false);
    }
    
    /**
     * Closes doors. Pushing/launching out the ball
     * @param launchSpeed Force the doors close (0 - 100)
     */
    public void launchBall(int launchSpeed) {
        // Limits launchForce to max value of 100 and min value of 0
        launchSpeed = Math.min(launchSpeed, 100);
        launchSpeed = Math.max(launchSpeed, 0);
        
        if(launchSpeed > 0) {
            leftDoor.set(launchSpeed / 100.0);
            rightDoor.set(launchSpeed / 100.0);
        } else {
            SmartDashboard.putString("Error", "Door close force cannot be less than 0");
        }
    }
    
    /**
     * Opens doors.
     */
    public void openDoors() {
        leftDoor.set(0);
        rightDoor.set(0);
    }
    
    
    public void startClosingDoors(){
        //close the doors halfway
        //may need to use a sensor
       leftDoor.set(RobotMap.Launcher.DOOR_CLOSE_SPEED);
       rightDoor.set(RobotMap.Launcher.DOOR_CLOSE_SPEED);
    }
    
    public void stopClosingDoors(){
        //close the doors halfway
        //may need to use a sensor
       leftDoor.set(0);
       rightDoor.set(0);
    }
    
    /**
     * Returns true if launcher doors are closed
     * @return true if launcher doors are closed
     */
    public boolean isClosed() {
        return leftDoor.get() > 0 && rightDoor.get() > 0;
    }
}
