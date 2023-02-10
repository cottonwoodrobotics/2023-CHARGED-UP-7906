// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FieldPositionManager extends SubsystemBase {
  private PhotonVisionSubsystem photonVisionSubsystem;
  private DriveTrainSubsystem driveTrain;

  /** Creates a new FieldPositionManager. */
  public FieldPositionManager(PhotonVisionSubsystem photonVisionSubsystem, DriveTrainSubsystem driveTrain) {
    this.photonVisionSubsystem = photonVisionSubsystem;
    this.driveTrain = driveTrain;
  }

  /** H! Gets the robot's current position using photon vision and odometry
   * 
   * @return The robot's current position according to photon vision, or odometry if that's not available
   */
  public Pose3d getRobotPosition() {
    // H! Get where photon vision thinks the robot is
    Pose3d photonVisionPosition = photonVisionSubsystem.checkRobotPosition();
    // H! If photon vision dosen't know, ask the odometry
    if (photonVisionPosition == null) {
      // H! Get the odometry pose and convert it to a Pose3d
      Pose2d odometryPosistion = driveTrain.getPose();
      return new Pose3d(odometryPosistion);
    }
    return photonVisionPosition;
  }

  // H! MAY OR MAY NOT BE A GOOD IDEA
  // H! Makes sure the periodic methods of photon vision and the drivetrain are running
  @Override
  public void register() {
    super.register();
    photonVisionSubsystem.register();
    driveTrain.register();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
