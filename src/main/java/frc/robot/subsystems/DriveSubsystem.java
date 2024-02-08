package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

    private WPI_VictorSPX driveLeftMaster = new WPI_VictorSPX(DriveConstants.kLeftMasterPort);
    private WPI_VictorSPX driveRightMaster = new WPI_VictorSPX(DriveConstants.kRightMasterPort);
    private WPI_VictorSPX driveLeftFollower = new WPI_VictorSPX(DriveConstants.kLeftFollowerPort);
    private WPI_VictorSPX driveRightFollower = new WPI_VictorSPX(DriveConstants.kRightFollowerPort);

    private DifferentialDrive driver = new DifferentialDrive(driveLeftMaster, driveRightMaster);

    public double getEncoderMeters() {
        return (driveLeftMaster.getSelectedSensorPosition() + -(driveRightMaster.getSelectedSensorPosition()) / 2 * DriveConstants.kEncoderTick2Meter);
    }

    public DriveSubsystem() {
        driveLeftMaster.setInverted(true);
        driveRightMaster.setInverted(false);
        driveLeftFollower.setInverted(true);
        driveRightFollower.setInverted(false);

        driveLeftFollower.follow(driveLeftMaster);
        driveRightFollower.follow(driveRightMaster);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    }

    //public void setMotors(double leftSpeed, double rightSpeed) {
    //      driveLeftMotor.set(leftSpeed);
    //      driveRightMotor.set(-rightSpeed);

    // }
    
    public void ArcadeDrive(double forwardSpeed, double rotationalSpeed){
        driver.arcadeDrive(forwardSpeed, rotationalSpeed);
    
    }

}