package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name="DC_Center_Stage_Test")

public class DC_Center_Stage_Test extends LinearOpMode{
     DcMotor Front_Right_Wheel = null;
     DcMotor Front_Left_Wheel  = null;
     DcMotor Back_Right_Wheel  = null;
     DcMotor Back_Left_Wheel   = null;

     @Override
    public void runOpMode() {
        Front_Right_Wheel  = hardwareMap.get(DcMotor.class, "Fr_motor");
        Front_Left_Wheel  = hardwareMap.get(DcMotor .class, "Fl_motor");
        Back_Right_Wheel  = hardwareMap.get(DcMotor.class, "Br_motor");
        Back_Left_Wheel   = hardwareMap.get(DcMotor.class, "Bl_motor");

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; //reverses the y axis allowing for only forward and backwards movement
            double x = gamepad1.left_stick_x * 1.1; //This counteracts potential imperfect strafing
            double rx = gamepad1.right_stick_x; //right joystick (turning)

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y - x + rx) / denominator;

            Front_Right_Wheel.setPower(frontRightPower); //The power is the equation above and indicates how much power the motor(s) are given
            Front_Left_Wheel.setPower(frontLeftPower);
            Back_Left_Wheel.setPower(backLeftPower);
            Back_Right_Wheel.setPower(backRightPower);


        }
    }
}
