package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public final class CTREConfigs {
    
    public TalonFXConfiguration motorOneConfig = new TalonFXConfiguration();
    public TalonFXConfiguration motorTwoConfig = new TalonFXConfiguration();

    public CTREConfigs() {
        // motor configurator
        // invert and neutral mode
        motorOneConfig.MotorOutput.Inverted = Constants.ShooterConstants.motorInvert;
        motorOneConfig.MotorOutput.NeutralMode = Constants.ShooterConstants.motorNeutral; 

        motorTwoConfig.MotorOutput.Inverted = Constants.ShooterConstants.motorInvert;
        motorTwoConfig.MotorOutput.NeutralMode = Constants.ShooterConstants.motorNeutral; 
    }
}
