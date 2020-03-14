/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.spinner;

import frc.robot.subsystems.SpinSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinColorWheelForRotation extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final SpinSubsystem spinSubsystem;

    public SpinColorWheelForRotation(SpinSubsystem subsystem) {
        spinSubsystem = subsystem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(spinSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        spinSubsystem.setGameColor();
        spinSubsystem.rotateClockwise();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        spinSubsystem.incrementNumberRotations();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        spinSubsystem.resetRotationControl();
        spinSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return spinSubsystem.hasCompletedRotation();
    }
}