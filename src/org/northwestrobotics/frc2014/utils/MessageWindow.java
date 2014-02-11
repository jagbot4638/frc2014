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

package org.northwestrobotics.frc2014.utils;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Message window utility
 * 
 * Writes messages to the message window, and updates it periodically
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 */
public class MessageWindow
{
    private static final DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    /**
     * Writes a message to the message window.
     * 
     * @param message The message to write (20 chars max)
     * @param line The line to write the message to (1-6)
     * @param column The column to start the message at (1-???)
     */
    public static void write(String message, int line, int column) {
        // Check string length
        if(message.length() > 20) {
            System.err.println("Can't write message longer than 20 chars to message window: truncating...");
            message = message.substring(0, 19);
        }
        
        // Process line number
        switch(line) {
            default:
            case 1:
                lcd.println(DriverStationLCD.Line.kUser1, column, message);
                break;
            case 2:
                lcd.println(DriverStationLCD.Line.kUser2, column, message);
                break;
            case 3:
                lcd.println(DriverStationLCD.Line.kUser3, column, message);
                break;
            case 4:
                lcd.println(DriverStationLCD.Line.kUser4, column, message);
                break;
            case 5:
                lcd.println(DriverStationLCD.Line.kUser5, column, message);
                break;
            case 6:
                lcd.println(DriverStationLCD.Line.kUser6, column, message);
                break;
        }
        
        // Update message window
        update();
    }
    
    private static void update() {
        lcd.updateLCD();
    }
}