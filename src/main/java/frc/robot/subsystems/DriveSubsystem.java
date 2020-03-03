
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  SpeedController rightMotor = new Jaguar(Constants.DRIVE_TRAIN_RIGHT_MOTOR);
  SpeedController leftMotor = new Jaguar(Constants.DRIVE_TRAIN_LEFT_MOTOR);
  DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

  public void tankDrive(double leftValue, double rightValue) {
    Boolean SENSITIVE_LOW_SPEED = true;
    differentialDrive.tankDrive(rightValue, leftValue, SENSITIVE_LOW_SPEED);
    SmartDashboard.putNumber("Tank Drive - Left Motor", -leftValue);
    SmartDashboard.putNumber("Tank Drive - Right Motor", -rightValue);
  }

  public void stop() {
    differentialDrive.tankDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
