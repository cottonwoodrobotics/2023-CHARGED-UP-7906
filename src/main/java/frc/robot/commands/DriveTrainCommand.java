package frc.robot.commands;
import static frc.robot.Constants.Drivetrain.*;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTrainCommand extends CommandBase {
    private final DriveTrainSubsystem m_driveTrainSubsystem;
    private final XboxController m_controller;

    //&& Creates DriveCommand
    public DriveTrainCommand(DriveTrainSubsystem subsystem, XboxController controller) {
        m_driveTrainSubsystem = subsystem;
        m_controller = controller;

        //&& Subsystem dependencies declared here
        addRequirements(subsystem);

    }

    //&& Called when the command is scheduled initially
    @Override
    public void initialize() {}

    //&& Called every time the scheduler runs while the command is scheduled
    @Override
    public void execute() {
        double ySpeed = m_controller.getLeftY() * driveSpeedMultiplier;
        double xSpeed = -m_controller.getLeftX() * driveSpeedMultiplier;
        double zRotation = m_controller.getRawAxis(2) * driveSpeedMultiplier;
    //ET changes y or x speed based based on left or right analog inputs

    // :D this appears to be broken, so I'm commenting this out for now while I test other things.    

        // if (m_controller.getLeftTriggerAxis() > 0.2) {
        //     xSpeed = (m_controller.getLeftTriggerAxis()*0.1/driveSpeedMultiplier);
        //     ySpeed = (m_controller.getLeftTriggerAxis()*0.1/driveSpeedMultiplier);
        // }
        // if ((m_controller.getRightTriggerAxis() > 0.2)) {
        //     xSpeed = (m_controller.getRightTriggerAxis()*1/driveSpeedMultiplier);
        //     ySpeed = (m_controller.getRightTriggerAxis()*1/driveSpeedMultiplier);
        // }
        
        m_driveTrainSubsystem.driveCartesian(ySpeed, xSpeed, zRotation);
    }

    //&& Called when the command ends or is interrupted
    @Override
    public void end(boolean interrupted) {
        m_driveTrainSubsystem.driveCartesian(0, 0, 0);
    }

    //&& Called when the command is actually supposed to end
    @Override
    public boolean isFinished() {
      return false;
    }
}

