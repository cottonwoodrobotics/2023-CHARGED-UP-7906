// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;


public class RobotContainer {

    //&& Define subsystems and commands here
    private final DriveTrain m_driveTrainSubsystem = new DriveTrain();


    XboxController primaryController = new XboxController(0);

    private final DriveCommand m_driveCommand = new DriveCommand(m_driveTrainSubsystem, primaryController);

    //&& Actual container for the robot. Contains subsystems, commands, etc.
    public RobotContainer() {
        //&& Configuers the button bindings. Obviously.
        configureButtonBindings();

        m_driveTrainSubsystem.setDefaultCommand(m_driveCommand);
    }

    //&& This method defines the button-to-command mappings.
    private void configureButtonBindings() {}
    
}