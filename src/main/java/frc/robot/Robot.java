// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    new RobotContainer();
  }

  public void robotPeriodic() {

    //&& Runs the Scheduler for polling buttons, adding and running commands, 
    //&& and running subsystem methods. 
    //&& MUST BE CALLED FROM THE ROBOT'S PERIODIC BLOCK
    CommandScheduler.getInstance().run();
  }

  public void disabledInit() {}

  public void disabledPeriodic() {}


  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {

    CommandScheduler.getInstance().cancelAll(); 
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  //&& This function is called when the robot first starts up.
  @Override
  public void simulationInit() {}

  //&& This function is called periodically while in the simulation.
  @Override
  public void simulationPeriodic() {}
}
