
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    Relay spinRelay = new Relay(Constants.SPINNER_RELAY);
    ColorSensorV3 colorSensor = new ColorSensorV3(Constants.COLOR_SENSOR_V3);
    Color detectedColor = null;

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
        detectedColor = colorSensor.getColor();
        double infraredValue = colorSensor.getIR();

        DriverStation.reportWarning(detectedColor.toString(), false);

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("IR", infraredValue);
    }
}
