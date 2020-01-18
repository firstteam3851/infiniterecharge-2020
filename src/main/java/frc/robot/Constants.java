/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  // OI
  public static int LEFT_JOYSTICK_PORT = 0;
  public static int JOYSTICK_LEFT_Y_AXIS = 1;
  public static int JOYSTICK_RIGHT_Y_AXIS = 3;

  public static int JOYSTICK_BUTTON_TWO = 2;
  public static int JOYSTICK_BUTTON_THREE = 3;


  // Drive Subsystem
  public static int DRIVE_TRAIN_LEFT_MOTOR = 0;
  public static int DRIVE_TRAIN_RIGHT_MOTOR = 1;

  // Spin Subsystem
  public static int SPINNER_RELAY = 0;
}
