
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    Relay pickupRelay = new Relay(Constants.PICKUP_RELAY);
    SpeedController shooterMotor = new Jaguar(Constants.SHOOTER_MOTOR);
    double shooterSpeed = Constants.SHOOTER_LOW;

    // Feeder methods
    public void startFeeder() {
        pickupRelay.set(Relay.Value.kForward);
    }

    public void reverseFeeder() {
        pickupRelay.set(Relay.Value.kReverse);
    }

    public void stopFeeder() {
        pickupRelay.set(Relay.Value.kOff);
    }

    // Shooter motor methods
    public void setShooterSpeed(double speed) {
        shooterSpeed = speed;
    }

    public void runShooter() {
        shooterMotor.set(shooterSpeed);
    }

    // Shared methods
    public void stop() {
        stopFeeder();
        shooterMotor.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
