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
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // controllers
  private final Joystick weapons = new Joystick(QuickTuning.weaponControllerID);

  // weapon controls
  private final int motorSpeedAxis = XboxController.Axis.kLeftY.value;
  // private final JoystickButton otherCommand = new JoystickButton(weapons, XboxController.Button.kA.value);
  
  // subsystems
  private final ShooterSubsys m_Motor = new ShooterSubsys();

  /* Robot Container */
  public RobotContainer() {

    m_Motor.setDefaultCommand(new Shooter(m_Motor, () -> -weapons.getRawAxis(motorSpeedAxis)));
    
    // Configure the trigger bindings
    configureBindings();
  }

  // button bindings
  private void configureBindings() {

  }

  public Command getAutonomousCommand() {

    // no auto, so leave as null
    return null;

  }
}
