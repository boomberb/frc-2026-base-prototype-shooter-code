package frc.robot.commands;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Shooter;

public class TeleopShooter extends Command {

    private final Shooter s_Shooter;
    private final PIDController topMotorPIDController;
    private final SimpleMotorFeedforward topMotorFF;
    private final TrapezoidProfile velocityProfile;
    private TrapezoidProfile.State setpointState;
    private final TrapezoidProfile.State goalState;

    public TeleopShooter (Shooter s_Shooter) {       
        
        this.s_Shooter = s_Shooter;
        topMotorPIDController = new PIDController(ShooterConstants.kP1, ShooterConstants.kI1, ShooterConstants.kD1);
        topMotorFF = new SimpleMotorFeedforward(ShooterConstants.kS1, ShooterConstants.kV1, ShooterConstants.kA1);
        velocityProfile = new TrapezoidProfile(
            new TrapezoidProfile.Constraints(ShooterConstants.targetRPS, ShooterConstants.maxAccelRPS2)
        );
        setpointState = new TrapezoidProfile.State(0.0, 0.0);
        goalState = new TrapezoidProfile.State(ShooterConstants.targetRPS, 0.0);

        addRequirements(s_Shooter);

    }

    @Override
    public void initialize() {
        double initialVelocityRPS = s_Shooter.getTopMotorVelocityInRPS();
        setpointState = new TrapezoidProfile.State(initialVelocityRPS, 0.0);
        topMotorPIDController.reset();
    }

    @Override
    public void execute() {
        TrapezoidProfile.State nextSetpoint = velocityProfile.calculate(ShooterConstants.loopPeriodSecs, setpointState, goalState);
        double setpointAccelRPS2 = (nextSetpoint.velocity - setpointState.velocity) / ShooterConstants.loopPeriodSecs;
        setpointState = nextSetpoint;

        double topMotorVelocityRPS = s_Shooter.getTopMotorVelocityInRPS();

        double topMotorVoltsFF = topMotorFF.calculate(setpointState.velocity, setpointAccelRPS2);

        double topMotorVoltsPID = topMotorPIDController.calculate(topMotorVelocityRPS, setpointState.velocity);

        double topMotorVolts = MathUtil.clamp(topMotorVoltsFF + topMotorVoltsPID, -ShooterConstants.maxVoltage, ShooterConstants.maxVoltage);

        s_Shooter.setTopMotorVoltage(topMotorVolts);

    }

    @Override
    public boolean isFinished() {

        return false;

    }

    @Override
    public void end(boolean interrupted) {

        s_Shooter.brake();

    }
}
