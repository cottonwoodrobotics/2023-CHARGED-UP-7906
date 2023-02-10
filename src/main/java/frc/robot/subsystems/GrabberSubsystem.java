// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class GrabberSubsystem extends SubsystemBase {

  // H! Creates an object for the motor that runs the grabber
  private CANSparkMax motor = new CANSparkMax(Constants.Grabber.grabberMotorID, MotorType.kBrushless);

  // H! Gets the encoder that is plugged into the motor controller so we can tell where the grabber is positioned
  private RelativeEncoder encoder = motor.getEncoder();

  /** Creates a new ExampleSubsystem. */
  public GrabberSubsystem() {}


  public void closeGrabber() {
    // ££ Grabs an object. Makes sure the grabber arms don't get too close together
    if (encoder.getPosition() > Constants.Grabber.kPositiveEncoderRotationLimit) {
      // H! If the arms of the grabber are too close together, this line of code makes the motor not spin
      motor.set(0);
    } else {
      // H! If the arms of the grabber are far enough apart, this line of code makes the motor spin so that the grabber will start closing
      motor.set(Constants.Grabber.grabberCloseSpeed);
    }
  }

  public void openGrabber() {
    // ££ Releases an object. Makes sure the grabber arms don't get too far apart
    if (encoder.getPosition() < Constants.Grabber.kNegativeEncoderRotationLimit) {
      // H! If the arms of the grabber are too far apart, this line of code makes the motor not spin
      motor.set(0);
    } else {
      // H! If the arms of the grabber are close enough, this line of code makes the motor spin so that the grabber will start opening
      motor.set(-1 * Constants.Grabber.grabberOpenSpeed);
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
