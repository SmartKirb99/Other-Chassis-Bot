// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//TODO figure out how to make this work

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.LimelightHelpers;

public class ApriltagSearcher extends PIDCommand {
  /** Creates a new ApriltagSearcher. */
  public ApriltagSearcher() {
    super(
        // The controller that the command will use
        new PIDController(0, 0, 0),
        // This should return the measurement
        () -> LimelightHelpers.getTX(""),
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
                
          
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
