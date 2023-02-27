// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.util.Units;

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

    //&& Lengths of the front/back and side(s) of the chassis
    public static final double frontLength = Units.inchesToMeters(21);
    public static final double sideLength =  Units.inchesToMeters(23);
    
    public static final MecanumDriveKinematics driveKinematics = new MecanumDriveKinematics(new Translation2d(frontLength / 2, sideLength / 2),
    new Translation2d(frontLength / 2, -sideLength / 2), new Translation2d(-frontLength / 2, sideLength / 2),
    new Translation2d(-frontLength / 2, -sideLength / 2));


    //&& These are the Drivetrain motors.
    //&& TODO: Add the motor IDs
    public static final int IDFrontLeft = 1;
    public static final int IDFrontRight = 2;
    public static final int IDBackLeft = 3;
    public static final int IDBackRight = 4;

    //&& This is the Drive speed multiplier
    public static final double driveSpeedMultiplier = 0;
  


  }

  /** H! Holds the data relevant to the arm
   * 
   */
  public static final class Arm {
    public static final class MotorIDs {
      public static final int pivot = 11; // H! TODO Insert the real motor IDs
      public static final int extension = 12;
    }

    public static final double xMoveSpeed = 0.1;
    public static final double yMoveSpeed = 0.1;
  }

  //&& These are the Drivetrain motors.
  //&& TODO: Add the motor IDs
  public static final int driveTrainIDFrontLeft = 1;
  public static final int driveTrainIDFrontRight = 2;
  public static final int driveTrainIDBackLeft = 3;
  public static final int driveTrainIDBackRight = 4;

  //&& This is the Drive speed multiplier
  public static final double driveSpeedMultiplier = 2;
public static final MecanumDriveKinematics driveKinematics = null;

  
  public static final class Grabber {
    // ss TODO - insert correct values
    public static final int grabberMotorID = 13;
    public static final double grabberCloseSpeed = 0.2;
    public static final double grabberOpenSpeed = 0.2;
    public static final double kPositiveEncoderRotationLimit = 7;
    public static final double kNegativeEncoderRotationLimit = -2;
  }
}


 