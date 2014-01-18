/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;

/**
 *
 * @author Saagar
 */
public class Launcher extends Subsystem {
    private final Solenoid hardStop = new Solenoid(RobotMap.Launcher.HARD_STOP_CHANNEL);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Solenoid getHardStop(){
        return hardStop;
    }
}
