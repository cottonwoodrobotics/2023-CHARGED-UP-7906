// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.GrabberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

/** An example command that uses an example subsystem. */
public class GrabberCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  // H! Define property for the susystem this uses 
  private final GrabberSubsystem m_subsystem;
  // H! Define property for the controller this uses
  private final XboxController m_controller;

  /** H!
   * Creates a new GrabberCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param controller The controller that should control this command.
   */
  public GrabberCommand(GrabberSubsystem subsystem, XboxController controller) {
    m_subsystem = subsystem;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // H! If the A button is pressed, tell the grabber to close
    if (m_controller.getAButton()) {
      m_subsystem.closeGrabberPID();
    }
    // H! If the B button is pressed, tell the grabber to open
    if (m_controller.getBButton()) {
      m_subsystem.openGrabberPID();
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
