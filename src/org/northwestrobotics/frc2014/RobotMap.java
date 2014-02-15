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
    /**
     * Button constants.
     */
    public static class Button 
    {
        private Button() {}
        
        // @todo Define missing button bindings
        public static final int RIGHT_TRIGGER = 8;
        public static final int LEFT_TRIGGER = 7;
        public static final int RIGHT_BUMPER = 6;
        public static final int LEFT_BUMPER = 5;
        public static final int D_PAD = 0;
        public static final int LEFT_STICK = 0;
        public static final int RIGHT_STICK = 0;
        public static final int X_BUTTON = 1;
        public static final int Y_BUTTON = 4;
        public static final int A_BUTTON = 2;
        public static final int B_BUTTON = 3;
        public static final int BACK_BUTTON = 9;
        public static final int START_BUTTON = 10;
    }
    
    /**
     * Gamepad constants.
     */
    public static class Gamepad 
    {
        private Gamepad() {}
        
        public static final int DRIVER_GAMEPAD = 1;
        public static final int ACTUATOR_GAMEPAD = 2;
    }
    
    /**
     * Motor constants.
     */
    public static class Motor 
    {
        private Motor() {}
        
        // Front left motor controller
        public static final int FRONT_LEFT_MOTOR = 1;
        
        // Front right motor controller
        public static final int FRONT_RIGHT_MOTOR = 4;
        
        // Rear left motor controller
        public static final int REAR_LEFT_MOTOR = 2;
        
        // Rear right motor controller
        public static final int REAR_RIGHT_MOTOR = 3;
        
        // Winch motors
        public static final int LEFT_WINCH_MOTOR = 5;
        public static final int RIGHT_WINCH_MOTOR = 6;
    }
    
    /**
     * Pneumatic constants.
     */
    public static class Pneumatic 
    {
        private Pneumatic() {}
    
        public static final int PRESSURE_SWITCH = 1;
        public static final int COMPRESSOR = 1;
        public static final int HARD_STOP = 1;
    }
    
    /**
     * Relay constants.
     */
    public static class Relay
    {
        private Relay() {}
        
        public static final int LATCH_RELAY = 1;
        public static final int COMPRESSOR_RELAY = 2;
    }
    
    /**
     * Force constants.
     */
    public static class Force 
    {
        private Force() {}
        
        // Shoot force constants
        public static final int SHOOT_FORCE_LOW = 25;
        public static final int SHOOT_FORCE_MED = 50;
        public static final int SHOOT_FORCE_HIGH = 75;
        public static final int SHOOT_FORCE_MAX = 100;
        
        // Pass force constants
        public static final int PASS_FORCE_LOW = 15;
        public static final int PASS_FORCE_MED = 30;
        public static final int PASS_FORCE_HIGH = 45;
        public static final int PASS_FORCE_MAX = 60;
        
        // Winch force constants
        public static final int GRAB_FORCE = 75;
    }
    
    /**
     * Time constants.
     */
    public static class Time 
    {
        private Time() {}
        
        public static final int TIME_TO_SHOOT_BALL = 1000000;
        public static final int TIME_TO_PASS_BALL = 1000000;
        public static final int TIME_TO_GRAB_BALL = 2000000;
    }
    
    /**
     * Defines autonomous constants.
     */
    public static class Autonomous 
    {
        private Autonomous() {}
        
        // Time constants (in msec)
        public static final int TIME_TO_TURN = 1000000;
        public static final int TIME_TO_DRIVE_STRAIGHT = 1000000;
        public static final int TIME_TO_REACH_WALL = 1500000;
        public static final int TIME_TO_REACH_GOAL = 1000000;
    }

    /**
     * Direction constants.
     */
    public static class Direction
    {
        private Direction() {}
        
        public static final int FORWARD = 1;
        public static final int BACKWARD = -1;
    }
}