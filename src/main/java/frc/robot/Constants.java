// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // H! Pivot subsystem
    public static final int pivotIDMotor = 1; // H! #TODO Insert motor IDs

    // H! Drive train subsystem
    public static final int driveTrainIDFrontRight =  5;
    public static final int driveTrainIDFrontLeft = 4;
    public static final int driveTrainIDBackRight = 2;
    public static final int driveTrainIDBackLeft = 3;



    // H! Arm positions (in num rotations)
    public static final double armPos0 = 0;
    public static final double armPos1 = 30./360;
    public static final double armPos2 = 60./360;


    // H! Drive speed multiplier
    public static final double driveSpeedMultiplier = 0.25;


    // H! Manual arm rotation speed multiplier
    public static final double manualArmSpeedMultiplier = 0.1;




}
