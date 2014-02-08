/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.northwestrobotics.frc2014.commands.autonomous;

import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 * Represents a command that has a direction that can be modified to change behavior. Involves the 
 * drivetrain.
 * @author Jamison Bryant <jbryant@outlook.com>
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 * @author Joshua Fleming <josofl12@gmail.com>
 */
public class DirectionalCommand extends TimedCommand
{
    private final int direction;
    
    public DirectionalCommand(int direction, int timeRequired) {
        super(timeRequired);
        requires(drivetrain);
        this.direction = direction / Math.abs(direction); // normalize the direction
    }
    
    protected final int getDirection() {
        return direction;
    }

    protected final void cease() {
        drivetrain.stop();
    }
}
