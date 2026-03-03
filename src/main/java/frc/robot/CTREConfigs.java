package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public final class CTREConfigs {
    
    public TalonFXConfiguration topMotorConfig = new TalonFXConfiguration();
    public TalonFXConfiguration bottomMotorConfig = new TalonFXConfiguration();

    public CTREConfigs() {
        // motor configurator
        // invert and neutral mode
        topMotorConfig.MotorOutput.Inverted = Constants.ShooterConstants.motorInvert;
        topMotorConfig.MotorOutput.NeutralMode = Constants.ShooterConstants.motorNeutral; 

        bottomMotorConfig.MotorOutput.Inverted = Constants.ShooterConstants.motorInvert;
        bottomMotorConfig.MotorOutput.NeutralMode = Constants.ShooterConstants.motorNeutral;
        
        
    }
}
