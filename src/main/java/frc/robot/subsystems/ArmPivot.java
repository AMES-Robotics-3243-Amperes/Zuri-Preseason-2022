// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class ArmPivot extends PIDSubsystem {
  /** Creates a new ArmPivot. */
  public ArmPivot() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0)); // H! #TODO Calibrate PID
  }


  // H! Create the motor controller object
  CANSparkMax pivotMotor = new CANSparkMax( Constants.pivotIDMotor, CANSparkMax.MotorType.kBrushless );
  // Create the encoder object
  RelativeEncoder pivotEncoder = pivotMotor.getEncoder();

  // H! It spins the motor at a speed.
  public void spinAtSpeed(double speed) {
    pivotMotor.set(speed);
  }



  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    // H! output clamped to 25% power
    pivotMotor.set(MathUtil.clamp(output, -.25, .25));
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return pivotEncoder.getPosition();
  }
}
