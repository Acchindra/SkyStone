package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Acchindra Thev on 12/7/2019.
 */

@TeleOp(name = "Tele-Op")
public class Teleop extends LinearOpMode {

    //Motor Count -- 6 / 8 (2 left)
    public DcMotor rightMotorFront;
    public DcMotor leftMotorFront;
    public DcMotor rightMotorBack;
    public DcMotor leftMotorBack;
    public DcMotor arm;
    public DcMotor extend;

    //Servo Count -- 4 / 12 (8 left)
    public Servo platformServo; //clear box controller
    public Servo platformServoTwo;
    public Servo cubeServoOne; // collection mechanism
    public Servo cubeServoTwo; // collection mechanism

    @Override
    public void runOpMode() throws InterruptedException {
        rightMotorFront = hardwareMap.dcMotor.get("rightMotorFront");
        leftMotorFront = hardwareMap.dcMotor.get("leftMotorFront");
        rightMotorBack = hardwareMap.dcMotor.get("rightMotorBack");
        leftMotorBack = hardwareMap.dcMotor.get("leftMotorBack");
        arm = hardwareMap.dcMotor.get("arm");
        extend = hardwareMap.dcMotor.get("extend");
        platformServo = hardwareMap.servo.get("platformServo");
        platformServoTwo = hardwareMap.servo.get("platformServoTwo");
        cubeServoOne = hardwareMap.servo.get("cubeServoOne");
        cubeServoTwo= hardwareMap.servo.get("cubeServoTwo");
        leftMotorBack.setDirection(DcMotor.Direction.FORWARD);
        leftMotorFront.setDirection(DcMotor.Direction.FORWARD);
        rightMotorFront.setDirection(DcMotor.Direction.REVERSE);
        rightMotorBack.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.FORWARD);
        extend.setDirection(DcMotor.Direction.FORWARD);
        run();
    }

    public void run(){

        //Introduce variables
        double drive;   // Power for forward and back motion
        double strafe;  // Power for left and right motion
        double rotate;  // Power for rotating the robot
        double moveArm;
        double moveExtend;

        waitForStart();
        while (opModeIsActive())
        {
            //Gamepad 1 Portion
            //-------------------------------------------------------------------------

            drive = -gamepad1.left_stick_y;  // Negative because the gamepad is weird
            strafe = gamepad1.left_stick_x;
            rotate = gamepad1.right_stick_x;

            //Set the values for the drive to be only -1 <-> 1
            drive = Range.clip(drive, -1, 1);
            strafe = Range.clip(strafe, -1, 1);
            rotate = Range.clip(rotate, -1, 1);

            //Set the variables drive component to work with our custom method
            drive = (float) scaleInput(drive);
            strafe = (float) scaleInput(strafe);
            rotate = (float) scaleInput(rotate);

            if (gamepad1.left_trigger > 0.25)
            {
                drive /= 3;
                strafe /= 3;
                rotate /= 3;
            }

            //Set the power for the wheels
            leftMotorBack.setPower(drive - strafe + rotate);
            leftMotorFront.setPower(drive + strafe + rotate);
            rightMotorBack.setPower(drive + strafe - rotate);
            rightMotorFront.setPower(drive - strafe - rotate);

            //Vacuum Control (Servo)
            if (gamepad1.b)
            {
                cubeServoOne.setPosition(0.5);
                cubeServoTwo.setPosition(0.5);
            }

            if (gamepad1.a)
            {
                cubeServoOne.setPosition(Servo.MIN_POSITION);
                cubeServoTwo.setPosition(Servo.MAX_POSITION);
            }

            if (gamepad1.right_bumper)
            {
                platformServo.setPosition(Servo.MAX_POSITION);
                platformServoTwo.setPosition(Servo.MIN_POSITION);
            }

            if (gamepad1.left_bumper)
            {
                platformServo.setPosition(Servo.MIN_POSITION);
                platformServoTwo.setPosition(Servo.MAX_POSITION);
            }

            //Gamepad 2 Portion
            //-------------------------------------------------------------------------

            //Deposit Arm Control (Motor)
            moveArm = gamepad2.left_stick_y;

            moveArm = Range.clip(moveArm, -0.9,0.9);

            moveArm = (float) scaleInput(moveArm);

            this.arm.setPower(moveArm);

            moveExtend = gamepad2.right_stick_y;

            moveExtend = Range.clip(moveExtend, -0.7,0.7);

            moveExtend = (float) scaleInput(moveExtend);

            this.extend.setPower(moveExtend);

            //Vacuum Control (Servo)
            if (gamepad2.b)
            {
                cubeServoOne.setPosition(0.5);
                cubeServoTwo.setPosition(0.5);
            }

            if (gamepad2.a)
            {
                cubeServoOne.setPosition(Servo.MIN_POSITION);
                cubeServoTwo.setPosition(Servo.MAX_POSITION);
            }

            if (gamepad2.left_trigger > 0.25)
            {
                this.extend.setPower(moveExtend/0.5);
                this.arm.setPower(moveArm/0.5);
            }
        }
    }

    double scaleInput(double dVal)
    {
        double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};
        int index = (int) (dVal * 16.0);
        if (index < 0) {
            index = -index;
        }
        if (index > 16) {
            index = 16;
        }
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }
        return dScale;
    }
}