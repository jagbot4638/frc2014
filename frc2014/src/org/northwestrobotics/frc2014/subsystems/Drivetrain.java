
package org.northwestrobotics.frc2014.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.drivetrain.TeleOpDrive;

/**
 * 
 * @author Saagar
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // Motors
    private final SpeedController frontLeftMotor = new Talon(RobotMap.Drivetrain.FRONT_LEFT_MOTOR_CONTROLLER);
    private final SpeedController frontRightMotor = new Talon(RobotMap.Drivetrain.FRONT_RIGHT_MOTOR_CONTROLLER);
    
    private final SpeedController rearLeftMotor = new Talon(RobotMap.Drivetrain.BACK_LEFT_MOTOR_CONTROLLER);
    private final SpeedController rearRightMotor = new Talon(RobotMap.Drivetrain.BACK_RIGHT_MOTOR_CONTROLLER);
    
    
    private final RobotDrive driver = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    public void move(double left, double right) {
        driver.tankDrive(left, right);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new TeleOpDrive(this));
    }
    
    public void stop() {
        driver.arcadeDrive(0, 0, true);
    }   
}