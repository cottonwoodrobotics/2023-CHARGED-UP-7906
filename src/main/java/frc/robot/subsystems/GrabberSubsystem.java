// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class GrabberSubsystem extends SubsystemBase {

  private CANSparkMax grabber = new CANSparkMax(Constants.Grabber.grabberMotorID, MotorType.kBrushless);

  private SparkMaxAbsoluteEncoder grabberEncoder = grabber.getAbsoluteEncoder(Type.kDutyCycle);

  /** Creates a new ExampleSubsystem. */
  public GrabberSubsystem() {}


  public void closeGrabber() {
    // ££ Grabs an object. Makes sure the grabber arms don't get too close together
    if (grabberEncoder.getPosition() > Constants.Grabber.kPositiveEncoderRotationLimit) {
      grabber.set(0);
    } else {
      grabber.set(Constants.Grabber.grabberCloseSpeed);
    }
  }

  public void openGrabber() {
    // ££ Releases an object. Makes sure the grabber arms don't get too far apart
    if (grabberEncoder.getPosition() < Constants.Grabber.kNegativeEncoderRotationLimit) {
      grabber.set(0);
    } else {
      grabber.set(-1 * Constants.Grabber.grabberOpenSpeed);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
