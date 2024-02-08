package frc.robot;

import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.ForwardAndTurn;
import frc.robot.commands.ShortDrive;
import frc.robot.commands.TurningTime;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArcadeDriveCMD;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final XboxController joystick1 = new XboxController(OIConstants.kDriverJoystickPort);
  
  public RobotContainer() {
    configureButtonBindings();

    m_Chooser.setDefaultOption("Forward and Turning Command", m_MovingForwardandTurningCommand);
    m_Chooser.addOption("Short Driving Command", m_ShortDrivingCommand);
    SmartDashboard.putData(m_Chooser);

    driveSubsystem.setDefaultCommand(new ArcadeDriveCMD(driveSubsystem, () -> joystick1.getLeftY(), () -> joystick1.getLeftX()));
  }

  
  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {
    return m_Chooser.getSelected();
  }

  private final Command m_MovingForwardandTurningCommand = new ForwardAndTurn(driveSubsystem);
  private final Command m_ShortDrivingCommand = new ShortDrive(driveSubsystem);
  
  private final SendableChooser<Command> m_Chooser = new SendableChooser<>();
  
  
}
  // A simple auto routine that drives forward a specified distance, and then stops.
  
  
  /*private final Command m_simpleAuto =
      new DriveDistance(
          AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, m_robotDrive);

  // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command m_complexAuto = new ComplexAuto(m_robotDrive, m_hatchSubsystem);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>(); **/