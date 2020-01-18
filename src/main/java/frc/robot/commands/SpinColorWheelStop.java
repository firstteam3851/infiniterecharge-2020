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

public class SpinColorWheelStop extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final SpinSubsystem spinSubsystem;

    public SpinColorWheelStop(SpinSubsystem subsystem) {
        spinSubsystem = subsystem;
        addRequirements(spinSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        spinSubsystem.stop();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        DriverStation.reportWarning("Rotating Spinner Stop", false);
        spinSubsystem.stop();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DriverStation.reportWarning("Rotating Spinner Stop Counter Clockwise", false);
        spinSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
