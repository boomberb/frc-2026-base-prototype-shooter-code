// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Constants.FeederConstants;
import frc.robot.Constants.QuickTuning;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // controllers
  private final Joystick weapons = new Joystick(QuickTuning.weaponControllerID);

  // weapon controls
  private final JoystickButton score = new JoystickButton(weapons, XboxController.Button.kA.value);
  private final JoystickButton feed = new JoystickButton(weapons, XboxController.Button.kX.value); 
  
  // Subsystems
  private final Shooter s_Shooter = new Shooter();
  private final Feeder f_Feeder = new Feeder();

  /* Robot Container */
  public RobotContainer() {


    // Configure the trigger bindings
    configureBindings();
  }

  // button bindings
  private void configureBindings() {

    score.whileTrue(new TeleopShooter(s_Shooter));
    feed.whileTrue(new TeleopFeeder(f_Feeder, 1.0));
    feed.onFalse(
      Commands.runEnd(
        () -> {
          f_Feeder.setKickerMotorSpeed(-FeederConstants.reversalVoltagePercentage);
          f_Feeder.setConveyorMotorSpeed(-FeederConstants.reversalVoltagePercentage);
        },
        () -> f_Feeder.brake(),
        f_Feeder
      ).withTimeout(FeederConstants.reversalTimeout)
    );

  }

  public Command getAutonomousCommand() {

    // no auto, so leave as null
    return null;

  }
}
