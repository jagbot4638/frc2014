/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 FRC Team #4638 (Northwest Jagbotics)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.drivetrain.TeleopDrive;

/**
 * Motor subsystem
 
 Represents the drivetrain subsystem of the robot.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class Drivetrain extends Subsystem 
{
    // Motor
    private final SpeedController frontLeftMotor = new Talon(RobotMap.Motor.FRONT_LEFT_MOTOR);
    private final SpeedController frontRightMotor = new Talon(RobotMap.Motor.FRONT_RIGHT_MOTOR);
    private final SpeedController rearLeftMotor = new Talon(RobotMap.Motor.REAR_LEFT_MOTOR);
    private final SpeedController rearRightMotor = new Talon(RobotMap.Motor.REAR_RIGHT_MOTOR);
    
    // Driver
    private final RobotDrive driver = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    /**
     * Moves the robot via a tank-drive method.
     * 
     * @param left The left-side speed
     * @param right The right-side speed
     */
    public void move(double left, double right) {
        driver.arcadeDrive(left, right);
    }
    
    /**
     * Initializes the drivetrain.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }
    
    /**
     * Stops the robot.
     */
    public void stop() {
        driver.arcadeDrive(0, 0, true);
    }
    
    public void updateDashboard() {
        
    }
}