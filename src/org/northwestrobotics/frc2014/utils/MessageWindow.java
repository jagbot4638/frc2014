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
import edu.wpi.first.wpilibj.DriverStationLCD.Line;

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
    
    private static final String[] lines = new String[6];
    private static int index = 0;
    
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
    public static void write(String message) {
        if (index == -1) {
            String last = null;
            for (int i = lines.length - 1; i > 0; i--) {
                String temp = lines[i];
                lines[i] = last;
                last = lines[i-1];
                lines[i-1] = temp;
            }
            
            lines[lines.length - 1] = message;
        } else {
            lines[index] = message;
        }
        update();
    }
    
    private static void update() {
        lcd.println(Line.kUser1, 1, lines[0]);
        lcd.println(Line.kUser2, 1, lines[1]);
        lcd.println(Line.kUser3, 1, lines[2]);
        lcd.println(Line.kUser4, 1, lines[3]);
        lcd.println(Line.kUser5, 1, lines[4]);
        lcd.println(Line.kUser6, 1, lines[5]);
        lcd.updateLCD();
    }
}