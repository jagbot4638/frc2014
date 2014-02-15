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
 * Writes messages to the message window, and updates it periodically.
 * 
 * @author Jamison Bryant <jbryant@outlook.com>
 */
public class MessageWindow
{
    private static final DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    /**
     * Writes a message to the message window.
     * 
     * @param line    The line to write the message on (1-6)
     * @param message The message to write (20 chars max)
     */
    public static void write(int line, String message) {
        switch(line) {
            default:
            case 1:
                lcd.println(Line.kUser1, 1, message);
                break;
            case 2:
                lcd.println(Line.kUser2, 1, message);
                break;
            case 3:
                lcd.println(Line.kUser3, 1, message);
                break;
            case 4:
                lcd.println(Line.kUser4, 1, message);
                break;
            case 5:
                lcd.println(Line.kUser5, 1, message);
                break;
            case 6:
                lcd.println(Line.kUser6, 1, message);
                break;
        }
        
        // Update display
        lcd.updateLCD();
    }
}