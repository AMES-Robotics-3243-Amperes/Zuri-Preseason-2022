// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TeleopArmPivot;
import frc.robot.commands.TeleopDriveTrain;
import frc.robot.subsystems.ArmPivot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrainSubsystem = new DriveTrain();
  private final ArmPivot m_armPivotSubsystem = new ArmPivot();


  XboxController primaryController = new XboxController(0);

  private final TeleopDriveTrain m_teleopDriveTrain = new TeleopDriveTrain(m_driveTrainSubsystem, primaryController);
  private final TeleopArmPivot m_teleopArmPivot = new TeleopArmPivot(m_armPivotSubsystem, primaryController);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveTrainSubsystem.setDefaultCommand( m_teleopDriveTrain );
    m_armPivotSubsystem.setDefaultCommand( m_teleopArmPivot );
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // H! IDK how you make this stop complaining
    return null;
  }
}
