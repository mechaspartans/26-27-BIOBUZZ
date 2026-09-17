package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Util {

    public HardwareMap hwMap;

    public DcMotorEx frontRight;
    public DcMotorEx backRight;
    public DcMotorEx frontLeft;
    public DcMotorEx backLeft;
    public Limelight3A limelight;

    // Takes 3 inputs that sets the speed for each of the
    // wheels to drive forward, strafe, and turn.
    public void drive(double forward, double strafe, double turn) {
        double fR = forward - strafe - turn;
        double bR = -forward - strafe + turn;
        double fL = forward + strafe + turn;
        double bL = -forward + strafe - turn;

        frontRight.setPower(fR);
        backRight.setPower(bR);
        frontLeft.setPower(fL);
        backLeft.setPower(bL);
    }


    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;
        initMotors();
        initServos();
        initSensors();
        initLimelight();
    }

    public void initMotors() {
        frontRight = hwMap.get(DcMotorEx.class, "fR");
        backRight = hwMap.get(DcMotorEx.class, "bR");
        frontLeft = hwMap.get(DcMotorEx.class, "fL");
        backLeft = hwMap.get(DcMotorEx.class, "bL");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initServos() {

    }

    public void initSensors() {

    }

    public void initLimelight() {
        limelight = hwMap.get(Limelight3A.class, "limelight");
        limelight.start();
        // 0 = april, 1 = blue, 2 = red, 3 = yellow
        limelight.pipelineSwitch(0);
    }

}
