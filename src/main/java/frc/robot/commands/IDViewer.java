package frc.robot.commands;
//TODO: Get working code for this command

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LimelightHelpers.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IDViewer extends Command {
 
  public IDViewer() {
    
  }

  
  @Override
  public void initialize() {

  }

  
  @Override
  public void execute() {
    //if()
    
    //if AprilTagID = 7
      //System.out.println("ID of 7 Found!");
    

  }

  
  @Override
  public void end(boolean interrupted) {

  }

  
  @Override
  public boolean isFinished() {
    return false;
 
  }
  
}
