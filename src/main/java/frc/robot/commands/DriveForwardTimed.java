
package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveForwardTimed extends Command {
    private final DriveSubsystem driveSubsystem;
    private final double time;
    private final Timer timer = new Timer();

    public DriveForwardTimed(DriveSubsystem driveSubsystem, double time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("DriveForwardCmd started!");
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.ArcadeDrive(DriveConstants.kAutoDriveForwardSpeed, 0);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.ArcadeDrive(0, 0);
        System.out.println("DriveForwardCmd ended!");
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        if (timer.get() > time)
            return true;
        else
            return false;
    }   
}