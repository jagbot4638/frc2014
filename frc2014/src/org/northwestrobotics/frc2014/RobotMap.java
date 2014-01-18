package org.northwestrobotics.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static final int GAMEPAD = 1;
    
    public static class Drivetrain {
        public static final int FRONT_LEFT_MOTOR_CONTROLLER = 1;
        public static final int FRONT_RIGHT_MOTOR_CONTROLLER = 1;
        
        public static final int BACK_LEFT_MOTOR_CONTROLLER = 1;
        public static final int BACK_RIGHT_MOTOR_CONTROLLER = 1;
    }
}
