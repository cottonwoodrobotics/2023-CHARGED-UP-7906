package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    //&& Creates DriveTrainSubsystem
    public DriveTrain() {}

    CANSparkMax frontLeftMotor = new CANSparkMax(Constants.driveTrainIDFrontLeft, MotorType.kBrushless);
    CANSparkMax frontRightMotor = new CANSparkMax(Constants.driveTrainIDFrontRight, MotorType.kBrushless);
    CANSparkMax backLeftMotor = new CANSparkMax(Constants.driveTrainIDBackLeft, MotorType.kBrushless);
    CANSparkMax backRightMotor = new CANSparkMax(Constants.driveTrainIDBackRight, MotorType.kBrushless);

    public void driveCartesian(double ySpeed, double xSpeed, double zRotation) {
        
        WheelSpeeds wheelSpeeds = MecanumDrive.driveCartesianIK(ySpeed, xSpeed, zRotation);

        frontLeftMotor.set(wheelSpeeds.frontLeft);
        frontRightMotor.set(wheelSpeeds.frontRight);
        backLeftMotor.set(wheelSpeeds.rearLeft);
        backRightMotor.set(wheelSpeeds.rearRight);

    }

    @Override
    public void periodic() {
        //&& This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        //&& This method will be called once per scheduler run DURING SIMULATION
    }
}



