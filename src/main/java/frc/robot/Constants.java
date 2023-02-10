// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static final class Joysticks {
    public static final int primaryControllerPort = 0;
    public static final int secondaryControllerPort = 1;
  }


  public static final class Drivetrain {

  }

  /** H! Holds the data relevant to the arm
   * 
   */
  public static final class Arm {
    public static final class MotorIDs {
      public static final int pivot = 1001; // H! TODO Insert the real motor IDs
      public static final int extension = 1002;
    }

    public static final double xMoveSpeed = 0.1;
    public static final double yMoveSpeed = 0.1;
  }

  //&& These are the Drivetrain motors.
  //&& TODO: Add the motor IDs
  public static final int driveTrainIDFrontLeft = 0;
  public static final int driveTrainIDFrontRight = 0;
  public static final int driveTrainIDBackLeft = 0;
  public static final int driveTrainIDBackRight = 0;

  //&& This is the Drive speed multiplier
  public static final double driveSpeedMultiplier = 0;

  //&& Lengths of the front/back and side(s) of the chassis
  //&& TODO: Measure side lengths of chassis. Do this wheel-to-wheel
  public static final double driveTrainFrontLength = 0;
  public static final double driveTrainSideLength = 0;

  public static final MecanumDriveKinematics driveKinematics = new MecanumDriveKinematics(new Translation2d(driveTrainFrontLength / 2, driveTrainSideLength / 2),
    new Translation2d(driveTrainFrontLength / 2, -driveTrainSideLength / 2), new Translation2d(-driveTrainFrontLength / 2, driveTrainSideLength / 2),
    new Translation2d(-driveTrainFrontLength / 2, -driveTrainSideLength / 2));
  

  public static final class Grabber {
    // ss TODO - insert correct values
    public static final int grabberMotorID = 9999;
    public static final double grabberCloseSpeed = 0.5;
    public static final double grabberOpenSpeed = 0.5;
    public static final double kPositiveEncoderRotationLimit = 0.5;
    public static final double kNegativeEncoderRotationLimit = 0.5;
  }
}


 