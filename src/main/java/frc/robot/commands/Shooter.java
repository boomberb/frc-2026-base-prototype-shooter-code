package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsys;

public class Shooter extends Command {

    private ShooterSubsys s_Shooter;
    private DoubleSupplier speedSup;

    public Shooter (ShooterSubsys s_Shooter, DoubleSupplier speedSup) {       
        
        this.s_Shooter = s_Shooter;
        this.speedSup = speedSup;

        addRequirements(s_Shooter);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
        s_Shooter.setMotorSpeed(MathUtil.applyDeadband(speedSup.getAsDouble(), Constants.QuickTuning.weaponAnalogDeadband));

    }

    @Override
    public boolean isFinished() {

        return false;

    }

    @Override
    public void end(boolean interrupted) {

        s_Shooter.brakeMotor();

    }
}
