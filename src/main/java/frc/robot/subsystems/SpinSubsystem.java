
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

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

    public String getColorValue(String rawColorValue) {
        // Get first character of hash
        String parsedHashValue = rawColorValue.substring(37, 38);
        SmartDashboard.putString("ParsedHashValue", parsedHashValue);
    
        // match with ranges
        if (Constants.VINYL_RED_RANGE.contains(parsedHashValue)) {
            return "RED";
        }
        if (Constants.VINYL_GREEN_RANGE.contains(parsedHashValue)) {
            return "GREEN";
        }
        if (Constants.VINYL_BLUE_RANGE.contains(parsedHashValue)) {
            return "BLUE";
        }
        if (Constants.VINYL_YELLOW_RANGE.contains(parsedHashValue)) {
            return "YELLOW";
        }

        return "";
    }

    public void stop() {
        spinRelay.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        detectedColor = colorSensor.getColor();
        double infraredValue = colorSensor.getIR();
        

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("IR", infraredValue);
        SmartDashboard.putString("color", detectedColor.toString());
        SmartDashboard.putString("parsed color", getColorValue(detectedColor.toString()));
        
    }
}
