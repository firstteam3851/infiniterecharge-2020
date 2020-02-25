
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
  DoubleSolenoid liftSolenoid = new DoubleSolenoid(Constants.LIFT_DOWN_PORT, Constants.LIFT_UP_PORT); 

  public void extendLift() {
    liftSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractLift() {
    liftSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {
    liftSolenoid.close();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
