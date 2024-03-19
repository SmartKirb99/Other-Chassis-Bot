package frc.robot;

import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.ForwardAndTurn;
import frc.robot.commands.PullFromShuffleboard;
import frc.robot.commands.ShortDrive;
import frc.robot.commands.TestDualCommand;
import frc.robot.commands.TurningTime;
import frc.robot.commands.blank;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArcadeDriveCMD;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
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
  private final PS5Controller joystick2 = new PS5Controller(OIConstants.kDriverJoystickPort); //Constant Added :)
  private final Joystick leOperator = new Joystick(OIConstants.kOperatorController);
  double Timing;
  
  
  
  //Attempting to add buttons...
  
  public RobotContainer() {
    configureButtonBindings();

    m_Chooser.setDefaultOption("Forward and Turning Command", m_MovingForwardandTurningCommand);
    m_Chooser.addOption("Short Driving Command", m_ShortDrivingCommand);
    SmartDashboard.putData(m_Chooser);
    SmartDashboard.putNumber("Input Value", 12);
    SmartDashboard.putNumber("CMD Run Time", 1);
    

    driveSubsystem.setDefaultCommand(new ArcadeDriveCMD(driveSubsystem, () -> joystick1.getLeftY(), () -> joystick1.getLeftX()));  //Replace joystick_ with joystick1 for Xbox Controllers, as for PS5, use joystick2 instead.

    //driveSubsystem.setDefaultCommand(new ArcadeDriveCMD(driveSubsystem, () -> joystick2.getLeftY(), () -> joystick2.getLeftX(), () -> Limelight.getRotationalRate()));
  }

  
  private void configureButtonBindings() {
    Timing = SmartDashboard.getNumber("CMD Run Time", 1);
    //new JoystickButton(joystick1, XboxController.Button.kA.value).onTrue(new DriveForwardTimed(driveSubsystem, 2));
    new JoystickButton(joystick2, PS5Controller.Button.kCross.value).onTrue(new DriveForwardTimed(driveSubsystem, 1)); //X Button
    new JoystickButton(joystick2, PS5Controller.Button.kCircle.value).onTrue(new TurningTime(driveSubsystem, 5)); // O Button
    new JoystickButton(joystick2, PS5Controller.Button.kSquare.value).onTrue(new blank(1));
    new JoystickButton(joystick1, XboxController.Button.kA.value).onTrue(new DriveForwardTimed(driveSubsystem, 1)); //Compatability thingy
    new JoystickButton(joystick1, XboxController.Button.kB.value).onTrue(new TurningTime(driveSubsystem, 5));
    new JoystickButton(joystick1, XboxController.Button.kX.value).onTrue(new blank(1));
    new JoystickButton(joystick1, XboxController.Button.kY.value).onTrue(new TestDualCommand(driveSubsystem));
    new JoystickButton(joystick2, PS5Controller.Button.kTriangle.value).onTrue(new TestDualCommand(driveSubsystem));
    new JoystickButton(leOperator, 21).onTrue(new PullFromShuffleboard());
    new JoystickButton(leOperator, 17).onTrue(new TestDualCommand(driveSubsystem));
    new JoystickButton(leOperator, 1).onTrue(new DriveForwardTimed(driveSubsystem, 1));
    new JoystickButton(leOperator, 2).onTrue(new TurningTime(driveSubsystem, 1));
    new JoystickButton(leOperator, 3).onTrue(new ForwardAndTurn(driveSubsystem));
    
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