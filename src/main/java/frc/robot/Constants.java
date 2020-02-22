/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Set;

import edu.wpi.first.wpilibj.I2C;

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
  // OI Logitech
  public static int LEFT_JOYSTICK_PORT = 0;
  public static int JOYSTICK_LEFT_Y_AXIS = 1;
  public static int JOYSTICK_RIGHT_Y_AXIS = 3;

  public static int JOYSTICK_BUTTON_TWO = 2;
  public static int JOYSTICK_BUTTON_THREE = 3;

  // OI Control Board - buttons follow label name on board
  public static int CONTROL_BOARD_PORT = 1;

  public static int CONTROL_BOARD_SHOOTER_HIGH = 9;
  public static int CONTROL_BOARD_SHOOTER_LOW = 8;
  public static int CONTROL_BOARD_FEED_BTN = 3;
  public static int CONTROL_BOARD_REV_FEED_BTN = 4;


  // Drive Subsystem
  public static int DRIVE_TRAIN_LEFT_MOTOR = 0;
  public static int DRIVE_TRAIN_RIGHT_MOTOR = 1;

  // Spin Subsystem
  public static int SPINNER_RELAY = 3;
  public static int SPINNER_ARM_WHEEL_SOLENOID = 0;
  public static I2C.Port COLOR_SENSOR_V3 = I2C.Port.kOnboard;
  public static Set<String> VINYL_RED_RANGE = Set.of("b", "c");
  public static Set<String> VINYL_GREEN_RANGE = Set.of("6", "7");
  public static Set<String> VINYL_BLUE_RANGE = Set.of("4", "5");
  public static Set<String> VINYL_YELLOW_RANGE = Set.of("9");
  public static String[] SPINNER_COLOR_ORDER = ['B', 'G', 'R', 'Y'];

  // Shooter subsystem
  public static int PICKUP_RELAY = 2;
  public static int SHOOTER_MOTOR = 2;
  public static double SHOOTER_HIGH = 0.90;
  public static double SHOOTER_MID = 0.75;
  public static double SHOOTER_LOW = 0.60;

  // Lift Subsystem
  public static int LIFT_DOWN_PORT = 0;
  public static int LIFT_UP_PORT = 1;

}
