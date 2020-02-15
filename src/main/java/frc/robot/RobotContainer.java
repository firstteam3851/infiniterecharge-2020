/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpinSubsystem;
import frc.robot.commands.RunShooterHigh;
import frc.robot.commands.RunShooterLow;
import frc.robot.commands.RunShooterMid;
import frc.robot.commands.ShooterStop;
import frc.robot.commands.SpinColorWheelClockwise;
import frc.robot.commands.SpinColorWheelCounterClockwise;
import frc.robot.commands.SpinColorWheelStop;
import frc.robot.commands.TankDrive;
import frc.robot.commands.autonomous.AutonomousDriveForward;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem;
  private final SpinSubsystem spinSubsystem;
  private final ShooterSubsystem shooterSubsystem;

  // OI
  private final Joystick logitechJoystick;
  private final JoystickButton logitechJoystickButtonTwo;
  private final JoystickButton logitechJoystickButtonThree;

  private final Joystick controlBoard;
  private final JoystickButton controlBoardShooterLowBtn;
  private final JoystickButton controlBoardShooterMidBtn;
  private final JoystickButton controlBoardShooterHighBtn;
  private final JoystickButton controlBoardShooterStopBtn;

  // Commands
  TankDrive tankDrive;

  SpinColorWheelClockwise spinColorWheelClockwise;
  SpinColorWheelCounterClockwise spinColorWheelCounterClockwise;
  SpinColorWheelStop spinColorWheelStop;

  RunShooterLow runShooterLow;
  RunShooterMid runShooterMid;
  RunShooterHigh runShooterHigh;
  ShooterStop shooterStop;

  AutonomousDriveForward autonomousDriveForward;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    DriverStation.reportWarning("Robot Container init", false);
    // Instantiate subsystems
    driveSubsystem = new DriveSubsystem();
    spinSubsystem = new SpinSubsystem();
    shooterSubsystem = new ShooterSubsystem();

    // Instantiate IO
    logitechJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
    logitechJoystickButtonTwo = new JoystickButton(logitechJoystick, Constants.JOYSTICK_BUTTON_TWO);
    logitechJoystickButtonThree = new JoystickButton(logitechJoystick, Constants.JOYSTICK_BUTTON_THREE);

    controlBoard = new Joystick(Constants.CONTROL_BOARD_PORT);
    controlBoardShooterLowBtn = new JoystickButton(controlBoard, Constants.CONTROL_BOARD_SHOOTER_LOW);
    controlBoardShooterMidBtn = new JoystickButton(controlBoard, Constants.CONTROL_BOARD_SHOOTER_MID);
    controlBoardShooterHighBtn = new JoystickButton(controlBoard, Constants.CONTROL_BOARD_SHOOTER_HIGH);
    controlBoardShooterStopBtn = new JoystickButton(controlBoard, Constants.CONTROL_BOARD_SHOOTER_STOP);

    // Instantiate commands
    tankDrive = new TankDrive(logitechJoystick, driveSubsystem);

    spinColorWheelClockwise = new SpinColorWheelClockwise(spinSubsystem);
    spinColorWheelCounterClockwise = new SpinColorWheelCounterClockwise(spinSubsystem);
    spinColorWheelStop = new SpinColorWheelStop(spinSubsystem);

    runShooterLow = new RunShooterLow(shooterSubsystem);
    runShooterMid = new RunShooterMid(shooterSubsystem);
    runShooterHigh = new RunShooterHigh(shooterSubsystem);
    shooterStop = new ShooterStop(shooterSubsystem);

    autonomousDriveForward = new AutonomousDriveForward(driveSubsystem);

    // Assign default commands
    driveSubsystem.setDefaultCommand(tankDrive);
    spinSubsystem.setDefaultCommand(spinColorWheelStop);
    shooterSubsystem.setDefaultCommand(shooterStop);

    // Configure the button bindingse
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Logitech Bindings
    logitechJoystickButtonTwo.whenHeld(spinColorWheelClockwise);
    logitechJoystickButtonThree.whenHeld(spinColorWheelCounterClockwise);

    // Control Board Bindings
    controlBoardShooterLowBtn.whenPressed(runShooterLow);
    controlBoardShooterMidBtn.whenPressed(runShooterMid);
    controlBoardShooterHighBtn.whenPressed(runShooterHigh);
    controlBoardShooterStopBtn.whenPressed(shooterStop);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autonomousDriveForward;
  }
}
