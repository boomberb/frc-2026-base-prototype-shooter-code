// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class QuickTuning {

    // controller constants
    public static final int weaponControllerID = 0;
    public static final double weaponAnalogDeadband = 0.1;

  }

  public static final class IntakeConstants {
    //public static final int
  }

  public static final class FeederConstants {

    public static final int kickerMotorID = 9;
    public static final int conveyorMotorID = 12;

    public static final double maxVoltage = 12;

    public static final double reversalVoltagePercentage = 0.5;
    public static final double reversalTimeout = 0.25;

  }

  public static final class ShooterConstants {

    public static final int topMotorID = 10;
    public static final int bottomMotorID = 11;
    public static final boolean bottomMotorOpposeLeader = false;

    public static final double maxVoltage = 12;
    public static final double targetRPM = 3000;
    public static final double targetRPS = targetRPM / 60;
    public static final double loopPeriodSecs = 0.02;
    public static final double maxAccelRPS2 = 250.0;
    public static final InvertedValue motorInvert = InvertedValue.Clockwise_Positive;
    public static final NeutralModeValue motorNeutral = NeutralModeValue.Brake;

    //pid😎
    public static final double kP1 = 0.06;
    public static final double kI1 = 0.0;
    public static final double kD1 = 0.0;

    public static final double kP2 = 0.06;
    public static final double kI2 = 0.0;
    public static final double kD2 = 0.0;

    public static final double kS1 = 0.0;
    public static final double kV1 = maxVoltage / targetRPS;
    public static final double kA1 = 0.0;

    public static final double kS2 = 0.0;
    public static final double kV2 = maxVoltage / targetRPS;
    public static final double kA2 = 0.0;

  }
}
