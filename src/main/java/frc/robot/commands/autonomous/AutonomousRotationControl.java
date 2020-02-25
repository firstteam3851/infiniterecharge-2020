/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.spinner.ExtendSpinnerArm;
import frc.robot.commands.spinner.SetRotationColorValues;
import frc.robot.commands.spinner.SpinColorWheelForPosition;
import frc.robot.subsystems.SpinSubsystem;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Autonomous command to rotate spinner.
 */
public class AutonomousRotationControl extends SequentialCommandGroup {
  /**
   * Create a new autonomous command.
   */
  public AutonomousRotationControl(SpinSubsystem spinner, DriveSubsystem driver) {
    addCommands(
        new ExtendSpinnerArm(spinner, driver),
        new SetRotationColorValues(spinner),
        new SpinColorWheelForPosition(spinner)
    );
  }
}