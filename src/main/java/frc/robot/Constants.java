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
  
}



 