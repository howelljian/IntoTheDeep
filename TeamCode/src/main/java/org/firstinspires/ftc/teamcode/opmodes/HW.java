package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DriveHW extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {


        public class Robot {
            public PriorityMotor fl, fr, bl, br;
            public Sensors sensors;
            public Deposit deposit;
            public Intake intake;

        DcMotorEx frontLeft = (DcMotorEx) hw.get(DcMotor.class, "frontLeft");
        DcMotorEx frontRight = (DcMotorEx) hw.get(DcMotor.class, "frontRight");
        DcMotorEx backLeft = (DcMotorEx) hw.get(DcMotor.class, "backLeft");
        DcMotorEx backRight = (DcMotorEx) hw.get(DcMotor.class, "backRight");

        fl = new PriorityMotor(frontLeft, "fl", 1, 1, sensors);
        fr = new PriorityMotor(frontRight, "fr", 1, 1, sensors);
        bl = new PriorityMotor(backLeft, "bl", 1, 1, sensors);
        br = new PriorityMotor(backRight, "br", 1, 1, sensors);

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        waitForStart();

        while(opModeIsActive()) {

            double frontLeftPower = (y + x + rx);
            double backLeftPower = (y - x + rx);
            double frontRightPower = (y - x - rx);
            double backRightPower = (y + x - rx);

            double max = Math.max(Math.abs(frontLeftPower),
                    Math.max(Math.abs(backLeftPower),
                            Math.max(Math.abs(frontRightPower),
                                    Math.abs(backRightPower))));

            if (max > 1.0) {
                frontLeftPower /= max;
                backLeftPower /= max;
                frontRightPower /= max;
                backRightPower /= max;
            }


            fl.setPower(frontLeftPower);
            bl.setPower(backLeftPower);
            fr.setPower(frontRightPower);
            br.setPower(backRightPower);



        }
    }
}