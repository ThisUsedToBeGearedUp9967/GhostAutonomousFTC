# GhostAutonomousFTC
This code automatically creates an autonomous program for First Tech Challenge robots by recording the values from the controller while you drive it and then turning that into code. 

## How it works
This project contains a class both for recording your drive and for simulating a gamepad based on those instructions. The recording class is called GhostRecorder and the controller simulator is called GhostController. GhostRecorder records the values from the gamepad while you are driving, and then converts it into a string in a certain format, which is then put in the constructor of GhostController.


## Getting data to computer

When the opmode stops, you need to somehow get the file to your computer to make an opmode out of it. This project contains a class, called CodeSharer, that opens up a share dialog. What you can do is download an app called Simple Notepad onto the robot controller phone, and then you can share the file to that app and it will save it to external storage where you can access it from a computer. Then, you just need to put the string in the GhostController constructor and it will exactly copy your movements. You could also share it with email, sms, or snapchat, but then you would have to turn off wifi direct.

## How to use it

To create a recording opmode:

    class DriveRecorder extends OpMode {
      
      GhostRecorder ghostRecorder=new GhostRecorder();
      CodeSharer codeSharer=new CodeSharer(hardwareMap.appContext);
      
      public void init() {
      }
      
      public void loop() {
      
        //only record values you are using to control robot
        ghostRecorder.recordLeftStickY(gamepad1.left_stick_y);
        ghostRecorder.recordRightStickY(gamepad1.right_stick_y);
        ghostRecorder.recordLeftStickX(gamepad1.left_stick_x);
        ghostRecorder.recordRightStickX(gamepad1.right_stick_x);
        
        ghostRecoreder.recordButtonA(gamepad1.x);
        //and B,X or Y
        
        ghostRecorder.recordDpadDown(gamepad1.dpad_down);
        //and Up,Left or Right
        
        //code to drive robot
        //...
        
        ghostRecorder.update(); //have to to this to actually record all of the values
      }
      
      public void stop() {
        codeSharer.share(ghostRecorder.getString());
      }
    }



To create a Autonomous opmode from the recorded data:
    
    class Autonomous extends OpMode {
      
      GhostController ghostController=new GhostController(/*put string other opmode generated here*/);
      
      public init() {
      }
      
      public loop() {
        ghostController.update(); //must include this at top
        
        //you can pretty much use ghostController as a regualar controller
        //instead of gamepad1.left_stick_x use ghostController.getLeftStickX();
        //           gamepad1.left_stick_y  == ghostController.getLeftStickY();
        //           gamepad1.right_stick_x == ghostController.getRightStickX();
        //           gamepad1.right_stick_y == ghostController.getRightStickY();
        //
        //           gamepad1.x             == ghostController.getButtonX();
        //           gamepad1.a             == ghostController.getButtonA();
        //           etc.
        //
        //           gamepad1.dpad_up       == ghostController.getDpadUp();
        //           and so on...
        
        
      }
    }
    
    
If you cant figure this out email me (ethan.hulinsky@gmail.com) or send me a smoke signal.
