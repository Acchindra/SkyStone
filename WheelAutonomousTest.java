package org.firstinspires.ftc.teamcode;/*
//package org.firstinspires.ftc.teamcode;
//
//import com.disnodeteam.dogecv.CameraViewDisplay;
//import com.disnodeteam.dogecv.DogeCV;
//import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
//
//@Autonomous(name="Camera Demo")
//public class WheelAutonomousTest extends LinearOpMode {
//
//    private GoldAlignDetector detector;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        waitForStart();
//        if (opModeIsActive()) {
//            detector = new GoldAlignDetector();
//            detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
//            detector.useDefaults();
//
//            // Optional Tuning
//            detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
//            detector.downscale = 0.4; // How much to downscale the input frames
//
//            detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
//            detector.maxAreaScorer.weight = 0.005;
//
//            detector.ratioScorer.weight = 5;
//            detector.ratioScorer.perfectRatio = 1.0;
//
//            detector.enable();
//            sleep(15000000);
//        }
//    }
//}

*/
/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Wheel Test")
public class WheelAutonomousTest extends LinearOpMode {

    public DcMotor rightMotorFront;
    public DcMotor leftMotorFront;
    public DcMotor rightMotorBack;
    public DcMotor leftMotorBack;


    @Override
    public void runOpMode() throws InterruptedException {

        rightMotorFront = hardwareMap.dcMotor.get("rightMotorFront");
        rightMotorFront.setDirection(DcMotor.Direction.FORWARD);
        leftMotorFront = hardwareMap.dcMotor.get("leftMotorFront");
        leftMotorFront.setDirection(DcMotor.Direction.REVERSE);
        rightMotorBack = hardwareMap.dcMotor.get("rightMotorBack");
        rightMotorBack.setDirection(DcMotor.Direction.FORWARD);
        leftMotorBack = hardwareMap.dcMotor.get("leftMotorBack");
        leftMotorBack.setDirection(DcMotor.Direction.REVERSE);

        rightMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData(">", "Robot Ready.");
        telemetry.update();

        waitForStart();
        if (opModeIsActive()) {

            telemetry.addData("Status", "Good Luck Drivers");

            rightMotorFront.setTargetPosition(900000);
            leftMotorFront.setTargetPosition(900000);
            rightMotorBack.setTargetPosition(900000);
            leftMotorBack.setTargetPosition(900000);

            rightMotorFront.setPower(0.4);
            leftMotorFront.setPower(0.4);
            rightMotorBack.setPower(0.4);
            leftMotorBack.setPower(0.4);

            rightMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftMotorFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftMotorBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            while (opModeIsActive() && rightMotorFront.getCurrentPosition() < rightMotorFront.getTargetPosition() && leftMotorFront.getCurrentPosition() < leftMotorFront.getTargetPosition() && rightMotorBack.getCurrentPosition() < rightMotorBack.getTargetPosition() && leftMotorBack.getCurrentPosition() < leftMotorBack.getTargetPosition())
            {
                telemetry.addData("RIGHT FRONT Encoder Position", rightMotorFront.getCurrentPosition());
                telemetry.addData("Target Value", rightMotorFront.getTargetPosition());
                telemetry.addData("LEFT FRONT Encoder Position", leftMotorFront.getCurrentPosition());
                telemetry.addData("Target Value", leftMotorFront.getTargetPosition());
                telemetry.addData("RIGHT BACK Encoder Position", rightMotorBack.getCurrentPosition());
                telemetry.addData("Target Value", rightMotorBack.getTargetPosition());
                telemetry.addData("LEFT BACK Encoder Position", leftMotorBack.getCurrentPosition());
                telemetry.addData("Target Value", leftMotorBack.getTargetPosition());
                telemetry.update();
                idle();
            }

            while (opModeIsActive() && leftMotorBack.getCurrentPosition() < leftMotorBack.getTargetPosition()) {
                telemetry.addData("LEFT BACK Encoder Position", leftMotorBack.getCurrentPosition());
                telemetry.addData("Target Value", leftMotorBack.getTargetPosition());
                telemetry.update();
                idle();
            }

            rightMotorFront.setPower(0.4);
            leftMotorFront.setPower(0.4);
            rightMotorBack.setPower(0.4);
            leftMotorBack.setPower(0.4);

            telemetry.addData("Path", "Complete");
            telemetry.update();

        }
    }
    public void setMotorPosition(DcMotor motor, double power, int position) {
        // Ensure that the opmode is still active
        if (opModeIsActive())
        {
            // Set Target and Turn On RUN_TO_POSITION
            motor.setTargetPosition(position);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // start motion
            power = Range.clip(Math.abs(power), 0.0, 1.0);
            motor.setPower(power);

            while (opModeIsActive() && motor.getCurrentPosition() < motor.getTargetPosition()) {
                telemetry.addData("Current Value", motor.getCurrentPosition());
                telemetry.addData("Target Value", motor.getTargetPosition());
                telemetry.update();
                idle();
            }
        }
    }
}*/


/*
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Extend Test")
public class WheelAutonomousTest extends LinearOpMode {

    public DcMotor extendMotor;
    public Servo rotateServo;//black box
    public CRServo vacuumServo;//collection mechanism

    @Override
    public void runOpMode() throws InterruptedException {

        extendMotor = hardwareMap.dcMotor.get("extendMotor");
        rotateServo = hardwareMap.servo.get("rotateServo");
        vacuumServo = hardwareMap.crservo.get("vacuumServo");
        extendMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extendMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        if (opModeIsActive())
        {
            setMotorPosition(extendMotor, 1,3077);
            rotateServo.setPosition(Servo.MAX_POSITION);
            sleep(1000);
            vacuumServo.setPower(-1.0);
            sleep(500);
            vacuumServo.setPower(1.0);
            sleep(500);
            rotateServo.setPosition(0.5);
            sleep(500);
        }
    }

    public void setMotorPosition (DcMotor motor, double power, int position) {
        // Ensure that the opmode is still active
        if (opModeIsActive())
        {
            // Set Target and Turn On RUN_TO_POSITION
            motor.setTargetPosition(position);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // start motion
            power = Range.clip(Math.abs(power), 0.0, 1.0);
            motor.setPower(power);

            while (opModeIsActive() && motor.getCurrentPosition() < motor.getTargetPosition()) {
                telemetry.addData("Current Value", motor.getCurrentPosition());
                telemetry.addData("Target Value", motor.getTargetPosition());
                telemetry.update();
                idle();
            }
        }
    }
}





*/
