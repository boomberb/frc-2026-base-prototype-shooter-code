// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Constants.QuickTuning;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // controllers
  private final Joystick weapons = new Joystick(QuickTuning.weaponControllerID);

  // weapon controls
  private final JoystickButton score = new JoystickButton(weapons, XboxController.Button.kA.value);
  
  // Subsystems
  private final Shooter s_Shooter = new Shooter();

  /* Robot Container */
  public RobotContainer() {


    // Configure the trigger bindings
    configureBindings();
  }

  // button bindings
  private void configureBindings() {
    score.whileTrue(new TeleopShooter(s_Shooter));
  }

  public Command getAutonomousCommand() {

    // no auto, so leave as null
    return null;

  }
}
