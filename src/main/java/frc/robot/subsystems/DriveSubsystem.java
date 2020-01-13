
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  SpeedController rightMotor = new Jaguar(Constants.DRIVE_TRAIN_RIGHT_MOTOR);
  SpeedController leftMotor = new Jaguar(Constants.DRIVE_TRAIN_LEFT_MOTOR);
  DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

  public void tankDrive(double leftValue, double rightForward) {
    differentialDrive.tankDrive(leftValue, rightForward);
  }

  public void stop() {
    differentialDrive.tankDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
