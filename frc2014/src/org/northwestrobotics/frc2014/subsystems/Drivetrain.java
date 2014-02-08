/*
The MIT License (MIT)

Copyright (c) 2014 Northwest Jagbotics 4638

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.drivetrain.TeleOpDrive;

/**
 * Represents the driving aspect of the robot.
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // Motors
    private final SpeedController frontLeftMotor = new Talon(RobotMap.Drivetrain.FRONT_LEFT_MOTOR_CONTROLLER);
    private final SpeedController frontRightMotor = new Talon(RobotMap.Drivetrain.FRONT_RIGHT_MOTOR_CONTROLLER);
    
    private final SpeedController rearLeftMotor = new Talon(RobotMap.Drivetrain.REAR_LEFT_MOTOR_CONTROLLER);
    private final SpeedController rearRightMotor = new Talon(RobotMap.Drivetrain.REAR_RIGHT_MOTOR_CONTROLLER);
    
    
    private final RobotDrive driver = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    /**
     * Moves the robot using tank-like input scheme.
     * @param left The speed for the left side of the robot to move at.
     * @param right The speed for the right side of the robot to move at.
     */
    public void tankMove(double left, double right) {
        driver.tankDrive(left, right);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new TeleOpDrive());
        
        // Invert right motor
        driver.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);    
    }
    
    public void stop() {
        driver.arcadeDrive(0, 0, true);
    }
    
}