
package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;

public class SpinSubsystem extends SubsystemBase {
    SpeedController spinRelay = new Spark(Constants.SPINNER_RELAY);
    ColorSensorV3 colorSensor = new ColorSensorV3(Constants.COLOR_SENSOR_V3);
    Solenoid spinnerArmSolenoid = new Solenoid(Constants.SPINNER_ARM_WHEEL_SOLENOID);

    String currentColor = "";
    String gameDataColor = "";

    String rotateToColor = "";
    String previousColor = "";
    Integer rotationTimes = 8; // 3.5 rotations * 2 for color wheel configuration
    Integer numRotations = 0;

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
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (gameData.length() > 0) {
            gameDataColor = Constants.SPINNER_COLOR_ORDER[getColorIndex("" + gameData.charAt(0)) + 1];
        }
    }

    public void setCurrentColor() {
        String tempCurrentColor = getColorValue(colorSensor.getColor().toString());
        if (tempCurrentColor != "") {
            currentColor = tempCurrentColor;
        }
    }

    public boolean atGameColor() {
        return currentColor == gameDataColor;
    }

    public void setRotationColorValues() {
        String initialSpinnerColor = getColorValue(colorSensor.getColor().toString());
        rotateToColor = Constants.SPINNER_COLOR_ORDER[getColorIndex(initialSpinnerColor)];
        previousColor = "";
    }

    public void incrementNumberRotations() {
        if (rotateToColor != "") {
            if (currentColor == rotateToColor && (previousColor != currentColor)) {
                numRotations++;
            }
            if (currentColor != previousColor || previousColor != "") {
                previousColor = currentColor;
            }
        }
    }

    public void resetRotationControl() {
        rotateToColor = "";
        numRotations = 0;
    }

    public boolean hasCompletedRotation() {
        return numRotations >= rotationTimes;
    }

    public String getColorValue(String rawColorValue) {
        // Get first character of hash
        String parsedHashValue = rawColorValue.substring(37, 38);

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

    private int getColorIndex(String inputColor) {
        for (int i = 0; i < Constants.SPINNER_COLOR_ORDER.length; i++) {
            if (Constants.SPINNER_COLOR_ORDER[i] == inputColor) {
                return i;
            }
        }
        return 0;
    }

    public void stop() {
        spinRelay.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        setCurrentColor();

        SmartDashboard.putString("game data color", gameDataColor);
        SmartDashboard.putString("current color", currentColor);
        SmartDashboard.putString("ROTATION CONTROL numRotations", numRotations.toString());
        SmartDashboard.putString("ROTATION CONTROL previousColor", previousColor);
        SmartDashboard.putString("ROTATION CONTROL rotateToColor", rotateToColor);
        SmartDashboard.putBoolean("ROTATION CONTROL is finished rotating", numRotations >= rotationTimes);
        SmartDashboard.putBoolean("POSITION CONTROL is finished rotating", currentColor == gameDataColor);

    }
}
