package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    private final TalonFX topMotor;
    private final TalonFX bottomMotor;
    private final Follower bottomMotorFollowRequest;

    public Shooter() {
        
        topMotor = new TalonFX(ShooterConstants.topMotorID);
        topMotor.getConfigurator().apply(Robot.ctreConfigs.topMotorConfig);
        bottomMotor = new TalonFX(ShooterConstants.bottomMotorID);
        bottomMotor.getConfigurator().apply(Robot.ctreConfigs.bottomMotorConfig);
        MotorAlignmentValue bottomMotorAlignment;
        if (ShooterConstants.bottomMotorOpposeLeader) {
            bottomMotorAlignment = MotorAlignmentValue.Opposed;
        } else {
            bottomMotorAlignment = MotorAlignmentValue.Aligned;
        }
        bottomMotorFollowRequest = new Follower(ShooterConstants.topMotorID, bottomMotorAlignment);
        bottomMotor.setControl(bottomMotorFollowRequest);

    }

    public void setTopMotorVoltage(double topMotorVolts) {

        // Keep top motor following in case any other control request interrupted follower mode.
        bottomMotor.setControl(bottomMotorFollowRequest);
        topMotor.setVoltage(MathUtil.clamp(topMotorVolts, -ShooterConstants.maxVoltage, ShooterConstants.maxVoltage));

    }

    public void setTopMotorSpeed(double speedCommand) {

        setTopMotorVoltage(ShooterConstants.maxVoltage * speedCommand);

    }

    public double getTopMotorVelocityInRPS() {
        
        return topMotor.getVelocity().getValueAsDouble();

    }

    public double getBottomMotorVelocityInRPS() {

        return bottomMotor.getVelocity().getValueAsDouble();

    }

    public double getTopMotorPosition() {

        return topMotor.getPosition().getValueAsDouble();

    }

    public double getBottomMotorPosition() {

        return bottomMotor.getPosition().getValueAsDouble();

    }

    public void brake() {

        topMotor.setVoltage(0);
        bottomMotor.setVoltage(0);

    }

    @Override
    public void periodic() {
    }
}
