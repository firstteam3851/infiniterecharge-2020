/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class TankDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveSubsystem driveSubsystem;
  private final Joystick logitechJoystick;

  /**
   * Creates a new TankDrive.
   * 
   * @param leftJoystickValues  The control input for left motor
   * @param rightJoystickValues The control input for right motor.
   * @param subsystem           The subsystem used by this command.
   */
  public TankDrive(Joystick joystick, DriveSubsystem subsystem) {
    driveSubsystem = subsystem;
    logitechJoystick = joystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.tankDrive(logitechJoystick.getRawAxis(Constants.JOYSTICK_LEFT_Y_AXIS),
        logitechJoystick.getRawAxis(Constants.JOYSTICK_RIGHT_Y_AXIS));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
