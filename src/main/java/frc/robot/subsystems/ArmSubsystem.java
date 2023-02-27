// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

  private CANSparkMax pivotMotor = new CANSparkMax(Constants.Arm.MotorIDs.pivot, MotorType.kBrushless);
  private CANSparkMax extensionMotor = new CANSparkMax(Constants.Arm.MotorIDs.extension, MotorType.kBrushed);

  private RelativeEncoder pivotEncoder = pivotMotor.getEncoder();
  private RelativeEncoder extensionEncoder = extensionMotor.getEncoder();

  private double targetX = 0;
  private double targetY = 0;

  // H! These are the PID controllers to move to a given point
  private SparkMaxPIDController pivotPID;
  private SparkMaxPIDController extensionPID;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    pivotPID = pivotMotor.getPIDController();
    extensionPID = extensionMotor.getPIDController();

    setPIDFValues(pivotPID, 0.1, 0, 0, 0);
    setPIDFValues(extensionPID, 0.1, 0, 0, 0);
  }

  /**H! Moves the arm to a given x and y position
   * 
   * @param x The x position to move to
   * @param y The x position to move to
   */
  public void moveToXY(double x, double y) {
    targetX = x;
    targetY = y;
  }


  /**H! Moves the arm by a given x and y
   * 
   * @param x The x position to move by
   * @param y The x position to move by
   */
  public void moveByXY(double x, double y) {
    targetX += x;
    targetY += y;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // H! Find the angle and length required
    double targetPivot = Math.atan(targetX / targetY);
    double targetExtension = Math.sqrt(Math.pow(targetX, 2) + Math.pow(targetY, 2));

    // H! Set the motor speeds based on the PIDs
    pivotPID.setReference(targetPivot, ControlType.kPosition);
    extensionPID.setReference(targetExtension, ControlType.kPosition);
  }

  private static void setPIDFValues(SparkMaxPIDController pidController, double p, double i, double d, double f) {
    pidController.setP(p);
    pidController.setI(i);
    pidController.setD(d);
    pidController.setFF(f);
  }
}
