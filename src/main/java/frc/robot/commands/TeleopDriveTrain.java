// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TeleopDriveTrain extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_driveTrainSubsystem;
  private final XboxController m_controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopDriveTrain(DriveTrain subsystem, XboxController controller) {
    m_driveTrainSubsystem = subsystem;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ySpeed = m_controller.getLeftY() * Constants.driveSpeedMultiplier;
    double xSpeed = m_controller.getLeftX() * Constants.driveSpeedMultiplier;
    double zRotation = m_controller.getRightX() * Constants.turnSpeedMultiplier;

    if (m_controller.getLeftBumper()) {
      ySpeed *= Constants.slowmodeForwardDriveSpeedMultiplier;
      xSpeed *= Constants.slowmodeSideDriveSpeedMultiplier;
      zRotation *= Constants.slowmodeTurnSpeedMultiplier;//
    }

    m_driveTrainSubsystem.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrainSubsystem.driveCartesian(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
