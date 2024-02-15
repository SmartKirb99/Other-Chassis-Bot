package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
//Grabbed the code here from 

public class Limelight extends SubsystemBase {
  
  //public Limelight() {

  //}

  public double getRotationalRate() {
    if (!this.isGamePieceFound()) {
      return 0;
    }
  }  
  
  double answer = 0;
  double offset = -Math.toradians(m_LL_Gamepiece.getEntry("tx").getDouble(0));

  double deadzone = 0.05;
  double kP = 1.5;
  double kS = 0.1;

  if (offset < 0.0) {
    kS = kS * -1;
  }

  answer = (offset * kP) + kS;

  if (Math.abs(offset) < deadzone) {
    answer = 0;
  }
  
  //public boolean exampleCondition() {
    
  //  return false;
  //}

  //@Override
  //public void periodic() {
    
  //}


}



//Currently I do not know if this current code is compatible with Arcade Drive





//Old Code

/*package frc.robot.Vision;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.CommandSwerveDriveTrain;
//import frc.robot.Util.RectanglePoseArea;

public class Limelight extends SubsystemBase {
  Alliance alliance;
  private String Eleven = "limelight";
  private Boolean enable = false;
  private Boolean trust = false;
  private int fieldError = 0;
  private int distanceError = 0;
  private Pose2d botpose;
  //private static final RectanglePoseArea field = new RectanglePoseArea(new Translation2d(0.0, 0.0), new Translation2d(16.54, 8.02));

  //public Limelight(CommandSwerveDrivetrain drivetrain) {
    this.drivetrain = drivetrain;
    SmartDashboard.putNumber("Field Error", fieldError);
    SmartDashboard.putNumber("Limelight Error", distanceError);
  }

  //@Override
  //public void periodic(){
    //if (enable) {
      Double targetDistance = LimelightHelpers.getTargetPose3d_CameraSpace(Eleven).getTranslation().getDistance(new Translation3d());
      Double confidence = 1 - ((targetDistance - 1) / 6);
      //LimelightHelpers.getLatestResults(Eleven).targetingResults;
      if (result.valid){
        botpose = LimelightHelpers.getBotPose2d_wpiBlue(Eleven);
        if (field.isPoseWithinArea(botpose)) {
          if (drivetrain.getState().Pose.getTranslation().getDistance(botpose.getTranslation()) < 0.5
        || trust
        || result.targets_Fiducials.length > 1) {
          drivetrain.addVisionMeasurement(
            botpose,
            Timer.getFPGATimestamp()
            - (result.latency_capture / 1000.0)
            - (result.latency_pipeline / 1000.0),
            VecBuilder.fill(confidence, confidence, .01));
        }else{
          distanceError++;
          SmartDashboard.putNumber("Limelight Error", distanceError);
        }
      }else{
        fieldError++;
        SmartDashboard.putNumber("Field Error", fieldError);
      }
    }
  }
}
public void setAlliance(Alliance alliance) {
  this.alliance = alliance;
}

public void useLimelight(boolean enable) {
  this.enable = enable;
}

public void trustLL(boolean trust) {
  this.trust = trust;
}
          
}
*/
