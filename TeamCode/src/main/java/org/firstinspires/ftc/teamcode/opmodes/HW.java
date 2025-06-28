package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DriveHW extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor = hardwareMap.dcMotor.get("fl");
        DcMotor motor = hardwareMap.dcMotor.get("fr");
        DcMotor motor = hardwareMap.dcMotor.get("bl");
        DcMotor motor = hardwareMap.dcMotor.get("br");

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        waitForStart();

        while(opModeIsActive()) {

            double frontLeftPower = (y + x + rx);
            double backLeftPower = (y - x + rx);
            double frontRightPower = (y - x - rx);
            double backRightPower = (y + x - rx);


            fl.setPower(frontLeftPower);
            bl.setPower(backLeftPower);
            fr.setPower(frontRightPower);
            br.setPower(backRightPower);



        }
    }
}