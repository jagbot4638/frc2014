package org.northwestrobotics.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static final int GAMEPAD = 1;
    
    public static class Gamepad {
        private Gamepad() {}
        public static final int DRIVER_GAMEPAD = 1;
        public static final int ACTUATOR_GAMEPAD = 2;
        
        public static final int DRIVER_LEFT_THUMB_STICK = 3;
        public static final int DRIVER_RIGHT_THUMB_STICK = 3;
        public static final int ACTUATOR_TRIGGER = 10; // TODO: find out the button number for the trigger.
    }
    
    public static class Drivetrain {
        private Drivetrain() {}
        public static final int FRONT_LEFT_MOTOR_CONTROLLER = 1;
        public static final int FRONT_RIGHT_MOTOR_CONTROLLER = 1;
        
        public static final int BACK_LEFT_MOTOR_CONTROLLER = 1;
        public static final int BACK_RIGHT_MOTOR_CONTROLLER = 1;
    }
    
    public static class Launcher {
        private Launcher() {}
        public static final int PRESSURE_SWITCH_CHANNEL = 1;
        public static final int COMPRESSOR_RELAY_CHANNEL = 1;
        
        public static final int HARD_STOP_CHANNEL = 1;
        
        public static final int LEFT_DOOR_CHANNEL = 1;
        public static final int RIGHT_DOOR_CHANNEL = 1;
        
        public static final int TIME_TO_LAUNCH_BALL = 1000000;
        
        public static final int TIME_TO_CLOSE_DOORS = 2000000; // TODO: test to determine actual time
        
        public static final int DOOR_CLOSE_SPEED = 10;// TODO: determine actual
    }
    
    public static class Grabber {
        private Grabber() {}
        public static final int DOOR_CLOSE_SPEED = 10;
    }
}
