package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DriveHW extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor fl = hardwareMap.dcMotor.get("fl");
        DcMotor fr = hardwareMap.dcMotor.get("fr");
        DcMotor bl = hardwareMap.dcMotor.get("bl");
        DcMotor br = hardwareMap.dcMotor.get("br");

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