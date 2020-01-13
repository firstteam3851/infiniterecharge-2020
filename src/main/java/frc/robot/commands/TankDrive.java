/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem driveSubsystem;
  private final DoubleSupplier leftJoystickValues;
  private final DoubleSupplier rightJoystickValues;

  

  /**
   * Creates a new TankDrive.
   * @param leftJoystickValues The control input for left motor
   * @param rightJoystickValues The control input for right motor.
   * @param subsystem The subsystem used by this command.
   */
  public TankDrive(DoubleSupplier left, DoubleSupplier right, DriveSubsystem subsystem) {
    driveSubsystem = subsystem;
    leftJoystickValues = left;
    rightJoystickValues = right;

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
    driveSubsystem.tankDrive(leftJoystickValues.getAsDouble(), rightJoystickValues.getAsDouble());

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
