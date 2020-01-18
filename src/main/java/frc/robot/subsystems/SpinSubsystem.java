
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    Relay spinRelay = new Relay(Constants.SPINNER_RELAY);

    public void rotateCounterClockwise() {
        spinRelay.set(Relay.Value.kReverse);
    }

    public void rotateClockwise() {
        spinRelay.set(Relay.Value.kForward);
    }

    public void stop() {
        spinRelay.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
