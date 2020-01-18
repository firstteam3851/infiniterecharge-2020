
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    Relay spinRelay = new Relay(Constants.SPINNER_RELAY);
    ColorSensorV3 colorSensor = new ColorSensorV3(Constants.COLOR_SENSOR_V3);

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
        Color detectedColor = colorSensor.getColor();
        double infraredValue = colorSensor.getIR();
        RawColor rawColor = colorSensor.getRawColor();

        DriverStation.reportWarning(detectedColor.toString(), false);
        // DriverStation.reportWarning(rawColor.toString(), false);
        // DriverStation.reportWarning(Double.toString(infraredValue), false);
    }
}
