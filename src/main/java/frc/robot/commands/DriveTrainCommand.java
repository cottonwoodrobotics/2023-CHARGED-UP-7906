package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
    private final DriveTrain m_driveTrainSubsystem;
    private final XboxController m_controller;

    //&& Creates DriveCommand
    public DriveCommand(DriveTrain subsystem, XboxController controller) {
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
        double ySpeed = m_controller.getLeftY() * Constants.driveSpeedMultiplier;
        double xSpeed = m_controller.getLeftX() * Constants.driveSpeedMultiplier;
        double zRotation = m_controller.getRightX() * Constants.driveSpeedMultiplier;
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

