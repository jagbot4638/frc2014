/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.northwestrobotics.frc2014.OI;
import org.northwestrobotics.frc2014.subsystems.Launcher;
import org.northwestrobotics.frc2014.subsystems.Drivetrain;

/**
 *
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class CommandGroupBase extends CommandGroup
{
    
    public CommandGroupBase() {
        
    }
    
    protected OI getOI() {
        return CommandBase.oi;
    }
    
    protected Drivetrain getDrivetrain() {
        return CommandBase.drivetrain;
    }
    
    protected Launcher getLauncher() {
        return CommandBase.launcher;
    }
}
