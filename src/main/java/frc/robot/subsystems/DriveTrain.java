package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//Odometry & kinematics imports
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.MecanumDriveOdometry;
import edu.wpi.first.math.kinematics.MecanumDriveWheelPositions;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;

public class DriveTrain extends SubsystemBase {
    //&& Creates DriveTrainSubsystem
    public DriveTrain() {
        resetOdometry(new Pose2d());
    }

    //&& Motor objects
    CANSparkMax frontLeftMotor = new CANSparkMax(Constants.driveTrainIDFrontLeft, MotorType.kBrushless);
    CANSparkMax frontRightMotor = new CANSparkMax(Constants.driveTrainIDFrontRight, MotorType.kBrushless);
    CANSparkMax backLeftMotor = new CANSparkMax(Constants.driveTrainIDBackLeft, MotorType.kBrushless);
    CANSparkMax backRightMotor = new CANSparkMax(Constants.driveTrainIDBackRight, MotorType.kBrushless);

    //&& Motor encoder objects
    RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
    RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
    RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();
    RelativeEncoder backRightEncoder = backRightMotor.getEncoder();

    //&& Creates the gyro object
    private AHRS m_gyro = new AHRS();

    private MecanumDriveOdometry m_Odometry = new MecanumDriveOdometry(Constants.driveKinematics, m_gyro.getRotation2d(), gWheelPositions());

    public MecanumDriveWheelPositions gWheelPositions() {
        return new MecanumDriveWheelPositions(frontLeftEncoder.getPosition(), frontRightEncoder.getPosition(), backLeftEncoder.getPosition(), backRightEncoder.getPosition());
    }

    public void resetOdometry(Pose2d pose) {
        m_Odometry.resetPosition(m_gyro.getRotation2d(), gWheelPositions(), pose);
    }

    public void driveCartesian(double ySpeed, double xSpeed, double zRotation) {
        
        WheelSpeeds wheelSpeeds = MecanumDrive.driveCartesianIK(ySpeed, xSpeed, zRotation);

        frontLeftMotor.set(wheelSpeeds.frontLeft);
        frontRightMotor.set(wheelSpeeds.frontRight);
        backLeftMotor.set(wheelSpeeds.rearLeft);
        backRightMotor.set(wheelSpeeds.rearRight);

    }



    public Pose2d getPose() {
        return m_Odometry.getPoseMeters();
    }



    @Override
    public void periodic() {
        //&& This method will be called once per scheduler run
        //&& cool gay mer stuff
        m_Odometry.update(m_gyro.getRotation2d(), gWheelPositions());
    }

    @Override
    public void simulationPeriodic() {
        //&& This method will be called once per scheduler run DURING SIMULATION
    }



    
}



