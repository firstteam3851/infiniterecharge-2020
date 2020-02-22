
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    SpeedController spinRelay = new Spark(Constants.SPINNER_RELAY);
    ColorSensorV3 colorSensor = new ColorSensorV3(Constants.COLOR_SENSOR_V3);
    Solenoid spinnerArmSolenoid = new Solenoid(Constants.SPINNER_ARM_WHEEL_SOLENOID);
    
    String currentColor = "";
    String gameDataColor = "";

    String initialSpinnerColor = "";
    String rotateToColor = "";
    Integer rotationTimes = 7;


    // Mechanical related methods
    public void rotateCounterClockwise() {
        spinRelay.set(1.0);
    }

    public void rotateClockwise() {
        spinRelay.set(-1.0);
    }

    public void extendSpinnerArm() {
        spinnerArmSolenoid.set(true);
        // If true does not work try reverse direction
        // spinnerArmSolenoid.set(false);
    }

    // Color related methods
    public void setGameColor() {
        gameDataColor = DriverStation.getInstance().getGameSpecificMessage();
    }

    public void setRotationColorValues() {
        initialSpinnerColor = getColorValue(colorSensor.getColor().toString());
    }

    public String getColorValue(String rawColorValue) {
        // Get first character of hash
        String parsedHashValue = rawColorValue.substring(37, 38);
        SmartDashboard.putString("ParsedHashValue", parsedHashValue);
    
        // match with ranges
        if (Constants.VINYL_RED_RANGE.contains(parsedHashValue)) {
            return "R";
        }
        if (Constants.VINYL_GREEN_RANGE.contains(parsedHashValue)) {
            return "G";
        }
        if (Constants.VINYL_BLUE_RANGE.contains(parsedHashValue)) {
            return "B";
        }
        if (Constants.VINYL_YELLOW_RANGE.contains(parsedHashValue)) {
            return "Y";
        }

        return "";
    }

    public void stop() {
        spinRelay.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        String tempcurrentColor = getColorValue(colorSensor.getColor().toString());
        if (tempcurrentColor != "") {
            currentColor = tempcurrentColor;
        }
        SmartDashboard.putString("current color", currentColor);
        
    }
}
