package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    private TalonFX motorOne;
    private TalonFX motorTwo;
    private Follower motorTwoFollowRequest;

    public Shooter() {
        
        motorOne = new TalonFX(ShooterConstants.motorOneID);
        motorOne.getConfigurator().apply(Robot.ctreConfigs.motorOneConfig);
        motorTwo = new TalonFX(ShooterConstants.motorTwoID);
        motorTwo.getConfigurator().apply(Robot.ctreConfigs.motorTwoConfig);
        MotorAlignmentValue motorTwoAlignment;
        if (ShooterConstants.motorTwoOpposeLeader) {
            motorTwoAlignment = MotorAlignmentValue.Opposed;
        } else {
            motorTwoAlignment = MotorAlignmentValue.Aligned;
        }
        motorTwoFollowRequest = new Follower(ShooterConstants.motorOneID, motorTwoAlignment);
        motorTwo.setControl(motorTwoFollowRequest); //hello i am mike

    }

    public void setMotorOneSpeed(double speedPID) {

        motorOne.setVoltage(ShooterConstants.maxVoltage * speedPID);

    }

    public double getMotorOneVelocityInRPS() {
        
        return motorOne.getVelocity().getValueAsDouble();

    }

    public double getMotorTwoVelocityInRPS() {

        return motorTwo.getVelocity().getValueAsDouble();

    }

    public double getMotorOnePosition() {

        return motorOne.getPosition().getValueAsDouble();

    }

    public double getMotorTwoPosition() {

        return motorTwo.getPosition().getValueAsDouble();

    }

    public void brake() {

        motorOne.setVoltage(0);
        motorTwo.setControl(motorTwoFollowRequest);

    }

    @Override
    public void periodic() {
    }
}
