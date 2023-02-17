// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.GrabberSubsystem;
import frc.robot.commands.GrabberCommand;
import frc.robot.commands.TeleopArm;
import frc.robot.subsystems.ArmSubsystem;

import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants.Drivetrain;
import frc.robot.commands.DriveTrainCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // H! Create the controller objects and store them
  private final XboxController primaryController = new XboxController(Constants.Joysticks.primaryControllerPort);
  private final XboxController secondaryController = new XboxController(Constants.Joysticks.secondaryControllerPort);

  /* H! SUBSYSTEMS ----------------------------------------------------------------- */
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final GrabberSubsystem m_grabberSubsystem = new GrabberSubsystem();
  private final DriveTrainSubsystem m_drivetrainSubsystem = new DriveTrainSubsystem();
  /* H! COMMANDS   ----------------------------------------------------------------- */
  private final TeleopArm m_teleopArmCommand = new TeleopArm(m_armSubsystem, secondaryController);
  private final GrabberCommand m_grabberCommand = new GrabberCommand(m_grabberSubsystem, secondaryController);
  private final DriveTrainCommand m_drivetrainCommand = new DriveTrainCommand(m_drivetrainSubsystem, primaryController);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    // ss set GrabberCommand as the default command for GrabberSubsystem - makes GrabberCommand actually run
    m_grabberSubsystem.setDefaultCommand(m_grabberCommand);

    //&& set DriveTrainCommand as default for DriveTrainSubsystem
    m_drivetrainSubsystem.setDefaultCommand(m_drivetrainCommand);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
