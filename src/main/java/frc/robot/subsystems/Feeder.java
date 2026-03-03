package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FeederConstants;

public class Feeder extends SubsystemBase {
    
    private final TalonFX kickerMotor;
    private final TalonFX conveyorMotor;

    public Feeder() {
        kickerMotor = new TalonFX(FeederConstants.kickerMotorID);
        conveyorMotor = new TalonFX(FeederConstants.conveyorMotorID);
    }

    public void setKickerMotorSpeed(double speed) {

        kickerMotor.setVoltage(FeederConstants.maxVoltage * speed);

    }

    public void setConveyorMotorSpeed(double speed) {

        conveyorMotor.setVoltage(-FeederConstants.maxVoltage * speed);

    }

    public void brake() {
        kickerMotor.setVoltage(0);
        conveyorMotor.setVoltage(0);
    }
}
