package frc.robot.commands;

import frc.robot.subsystems.Feeder;

import edu.wpi.first.wpilibj2.command.Command;

public class TeleopFeeder extends Command {
    private final Feeder f_Feeder;
    private final double speed;
    //hello

    public TeleopFeeder(Feeder f_Feeder, double speed) {

        this.f_Feeder = f_Feeder;
        addRequirements(f_Feeder);

        this.speed = speed;

    }

    @Override
    public void initialize() {
        //yo necesito usar el bano
    }

    @Override
    public void execute() {
        f_Feeder.setKickerMotorSpeed(speed);
        f_Feeder.setConveyorMotorSpeed(speed);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        f_Feeder.brake();
    }
    
}

   