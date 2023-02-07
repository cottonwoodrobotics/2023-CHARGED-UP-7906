// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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


  public static final class Arm {

  }


  public static final class Grabber {
    // ss TODO - insert correct values
    public static final int grabberMotorID = 9999;
    public static final double grabberCloseSpeed = 0.5;
    public static final double grabberOpenSpeed = 0.5;
    public static final double kPositiveEncoderRotationLimit = 0.5;
    public static final double kNegativeEncoderRotationLimit = 0.5;
  }


  public static final class PhotonVision {
    
  }
}
