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

package org.northwestrobotics.frc2014;

/**
 * Robot constants map
 * 
 * Maps robot port values to constants accessible in the rest of the program.
 * 
 * @todo Finalize button numbers
 */
public class RobotMap 
{    
    public static final int GAMEPAD = 1;

    /**
     * Defines gamepad constants.
     */
    public static class Gamepad {
        private Gamepad() {}

        public static final int DRIVER_GAMEPAD = 1;
        public static final int ACTUATOR_GAMEPAD = 2;
        
        public static final int LEFT_AXIS = 2;
        public static final int RIGHT_AXIS = 4;
        
        public static final int SHOOT_TRIGGER = 10;
        public static final int RETRIEVE_BUTTON = 9;
        public static final int PASS_BUTTON = 11;
    }
    
    /**
     * Defines drivetrain constants.
     */
    public static class Drivetrain {
        private Drivetrain() {}
        
        // Front left motor controller
        public static final int FRONT_LEFT_MOTOR_CONTROLLER = 1;
        
        // Front right motor controller
        public static final int FRONT_RIGHT_MOTOR_CONTROLLER = 4;
        
        // Rear left motor controller
        public static final int REAR_LEFT_MOTOR_CONTROLLER = 2;
        
        // Rear right motor controller
        public static final int REAR_RIGHT_MOTOR_CONTROLLER = 3;
    }
    
    /**
     * Defines launcher constants.
     * 
     * @todo Define actual values
     */
    public static class Launcher {
        private Launcher() {}
        
        // Pneumatic constants
        public static final int PRESSURE_SWITCH_CHANNEL = 1;
        public static final int COMPRESSOR_RELAY_CHANNEL = 1;
        public static final int HARD_STOP_CHANNEL = 1;
        
        // Door motor constants
        public static final int LEFT_DOOR_CHANNEL = 9;
        public static final int RIGHT_DOOR_CHANNEL = 10;
        
        // Time constants (in msec)
        public static final int TIME_TO_LAUNCH_BALL = 1000000;
        public static final int TIME_TO_CLOSE_DOORS = 2000000;
        public static final int DOOR_CLOSE_SPEED = 10;
        
        // Force constants
        public static final int SHOOT_FORCE = 50;
        public static final int PASS_FORCE = 25;
    }
    
    /**
     * Defines autonomous constants.
     */
    public static class Autonomous {
        private Autonomous() {}
        
        // Time constants (in msec)
        public static final int TIME_TO_TURN = 1000000;
        public static final int TIME_TO_DRIVE_STRAIGHT = 1000000;
        public static final int TIME_TO_REACH_WALL = 1500000;
        public static final int TIME_TO_REACH_GOAL = 1000000;
    }

    /**
     * Defines directional constants.
     */
    public static class Direction
    {
        private Direction() {}
        
        // Direction constants
        public static final int FORWARD = 1;
    }
}