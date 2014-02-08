package org.northwestrobotics.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{    
    public static final int GAMEPAD = 1;
    
    public static class Gamepad {
        public static final int RETRIEVE_BUTTON = 9; // TODO: pick button number
        private Gamepad() {}
        
        /**
         * The input port number for the gamepad responsible for controlling the driving aspect of the robot.
         */
        public static final int DRIVER_GAMEPAD = 1;
        public static final int ACTUATOR_GAMEPAD = 2;
        
        public static final int LEFT_AXIS = 2;
        public static final int RIGHT_AXIS = 4;
        
        public static final int SHOOT_TRIGGER = 10; // TODO: find out the button number for the trigger.
        public static final int PASS_BUTTON = 11; // TODO: figure out which button to use for passing.
    }
    
    public static class Drivetrain {
        private Drivetrain() {}
        
        /**
         * The output port number for the front left motor controller.
         */
        public static final int FRONT_LEFT_MOTOR_CONTROLLER = 1;
        
        /**
         * The output port number for the front right motor controller.
         */
        public static final int FRONT_RIGHT_MOTOR_CONTROLLER = 4;
        
        
        /**
         * The output port number for the rear left motor controller.
         */
        public static final int REAR_LEFT_MOTOR_CONTROLLER = 2;
        
        /**
         * The output port number for the rear right motor controller.
         */
        public static final int REAR_RIGHT_MOTOR_CONTROLLER = 3;
    }
    
    public static class Launcher {
        private Launcher() {}
        public static final int PRESSURE_SWITCH_CHANNEL = 5;
        public static final int COMPRESSOR_RELAY_CHANNEL = 6;
        
        public static final int HARD_STOP_CHANNEL = 7;
        
        public static final int LEFT_DOOR_CHANNEL = 9;
        public static final int RIGHT_DOOR_CHANNEL = 10;
        
        public static final int TIME_TO_LAUNCH_BALL = 1000000; // TODO: put in equation with force to determine the time
        
        public static final int TIME_TO_CLOSE_DOORS = 2000000; // TODO: test to determine actual time
        
        public static final int DOOR_CLOSE_SPEED = 10;// TODO: determine actual
        
        public static final int SHOOT_FORCE = 50;
        public static final int PASS_FORCE = 25;
    }
    
    public static class Autonomous {
        
        private Autonomous() {}
        
        public static final int TIME_TO_TURN = 1000000;
        public static final int TIME_TO_DRIVE_STRAIGHT = 1000000;
        public static final int TIME_TO_REACH_WALL = 1500000;
        public static final int TIME_TO_REACH_GOAL = 1000000;
        
        
    }

    public static class Direction
    {
        public static final int FORWARD = 1;

        private Direction() {
        }
    }
}