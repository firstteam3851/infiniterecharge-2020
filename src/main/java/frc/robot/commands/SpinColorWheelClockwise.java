/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.SpinSubsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinColorWheelClockwise extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final SpinSubsystem spinSubsystem;

    public SpinColorWheelClockwise(SpinSubsystem subsystem) {
        spinSubsystem = subsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        DriverStation.reportWarning("Rotating Spinner Clockwise", false);
        spinSubsystem.rotateClockwise();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DriverStation.reportWarning("Rotating Spinner Stop Clockwise", false);
        spinSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
