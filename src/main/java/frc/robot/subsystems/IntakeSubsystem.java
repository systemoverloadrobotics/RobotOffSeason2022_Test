// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax intake = new CANSparkMax(1, MotorType.kBrushless);

    private DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

    public IntakeSubsystem() {
        intake.restoreFactoryDefaults();

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void setPower() {
        intake.set(.5);
    }

    public void retractDrop() {
        solenoid.set(false);
    }

    public void actuateDrop() {
        solenoid.set(true);
    }

    public void stop() {
        intake.set(0);
    }

    public Solenoid getDropIntake() {
        return solenoid;
    }

    public CANSparkMax getIntake() {
        return intake;
    }

    public void toggleDropIntake() {
        solenoid.toggle();
    }
}
