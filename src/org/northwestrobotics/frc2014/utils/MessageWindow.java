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
    
    private static final String[] lines = new String[6];
    private static final int index = 0;
    
    /**
     * Writes a message to the message window.
     * 
     * @param message The message to write (20 chars max)
     */
    public static void write(String message) {
        // Store message in buffer
        if(index == -1) {
            String last = null;
            for(int i = lines.length - 1; i > 0; i--) {
                String temp = lines[i];
                lines[i] = last;
                last = lines[i-1];
                lines[i-1] = temp;
            }
            
            lines[lines.length - 1] = message;
        } else {
            lines[index] = message;
        }
        
        // Update display
        update();
    }
    
    /**
     * Updates message window.
     */
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