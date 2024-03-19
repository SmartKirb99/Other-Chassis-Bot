// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.TurningTime;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.networktables.*;
import frc.robot.commands.PullFromShuffleboard;

public class TestDualCommand extends Command {
  double Ocarina;
  double Timing;

  private DriveForwardTimed ForwardCommand;
  /** Creates a new TestDualCommand. */
  
  private final DriveSubsystem m_drive;
  private final ShuffleboardTab m_tab = Shuffleboard.getTab("Main");
  
  public TestDualCommand(DriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    //addRequirements(m_drive);
    //ForwardCommand = new DriveForwardTimed(drive, 1);
    //m_tab.add("Value Input", Ocarina);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("'Ight here we go");
    ForwardCommand =
       new DriveForwardTimed(m_drive, Timing);
       
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Ocarina = SmartDashboard.getNumber("Input Value", 12);
    Timing = SmartDashboard.getNumber("CMD Run Time", 1);
    System.out.println(Ocarina);
    if(Ocarina == 1987.0) {
      new DriveForwardTimed(m_drive, Timing);
       
       System.out.println("Is this working?");
    } else if (Ocarina == 1984.0){
      new TurningTime(m_drive, 1);

      System.out.println("This is the response for 1984");
    } else {
      System.out.println("Else Statement");
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
