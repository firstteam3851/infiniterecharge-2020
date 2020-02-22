/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.spinner;

import frc.robot.subsystems.SpinSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendSpinnerArm extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final SpinSubsystem spinSubsystem;
    private final DriveSubsystem driverSubsystem;

    public ExtendSpinnerArm(SpinSubsystem inputSpinsubsystem, DriveSubsystem inputDriveSubsytem ) {
        spinSubsystem = inputSpinsubsystem;
        driverSubsystem = inputDriveSubsytem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(spinSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        spinSubsystem.extendSpinnerArm();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
