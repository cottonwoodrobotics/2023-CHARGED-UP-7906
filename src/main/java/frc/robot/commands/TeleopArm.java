// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;

public class TeleopArm extends CommandBase {

  ArmSubsystem armSubsystem;
  XboxController controller;

  /** Creates a new TeleopArm. */
  public TeleopArm(ArmSubsystem armSubsystem, XboxController controller) {
    this.armSubsystem = armSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //armSubsystem.moveByXY(controller.getRightY() * Constants.Arm.yMoveSpeed, controller.getLeftY() * Constants.Arm.xMoveSpeed);
    
    // :D Yeah this looks terrible, but I'm just intending to set up quick manual controls so the underdogs can test
    if(Math.abs(controller.getRightY())>0.1){
      armSubsystem.manualExtend(controller.getRightY()/-30);
    }
    if(Math.abs(controller.getLeftY())>0.1){
      armSubsystem.manualPivot(controller.getLeftY());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
