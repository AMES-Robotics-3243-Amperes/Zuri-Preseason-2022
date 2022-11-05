// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPivot;
import frc.robot.Constants;


public class TeleopArmPivot extends CommandBase {

  private final ArmPivot m_armPivotSubsystem;
  private final XboxController m_controller;

  /** Creates a new TeleopArmPivot. */
  public TeleopArmPivot(ArmPivot armPivot, XboxController controller) {
    m_armPivotSubsystem = armPivot;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // H! set to one of 3 positions based on the button pressed (increasing order: A, X, Y)
    if ( m_controller.getAButtonPressed() ) {
      m_armPivotSubsystem.setSetpoint( Constants.armPos0 );
    } else if ( m_controller.getXButtonPressed() ) {
      m_armPivotSubsystem.setSetpoint( Constants.armPos1 );
    } else if ( m_controller.getYButtonPressed() ) {
      m_armPivotSubsystem.setSetpoint( Constants.armPos2 );
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_armPivotSubsystem.spinAtSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
