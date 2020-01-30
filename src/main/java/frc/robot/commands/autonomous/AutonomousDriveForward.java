/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveForwardTime;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Autonomous command to drive forward for X seconds.
 */
public class AutonomousDriveForward extends SequentialCommandGroup {
  /**
   * Create a new autonomous command.
   */
  public AutonomousDriveForward(DriveSubsystem drive) {
    long driveForwardTimeInMS = 5 * 1000; // 5 seconds

    addCommands(
        new DriveForwardTime(drive, driveForwardTimeInMS)
    );
  }
}