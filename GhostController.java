
public class GhostController {
  StickValues stickValues=new StickValues();
  ButtonValues buttonValues=new ButtonValues();
  private String instructions;
  private int pos=0;
  private int waitFor=0;
  public GhostController(String str) {
    instructions=str;
  }
  
  private String getNextValue() {
    String value="";
    while(pos<instructions.length())
    {
      if(instructions.charAt(pos)==' ')
      {
        pos+=1;
        return value; 
      }
      else if(pos==instructions.length()-1)
      {
        value+=instructions.charAt(pos);
        pos+=1;
        return value;
      }
      else
      {
        value+=instructions.charAt(pos);
      }
      
      pos+=1;
    }
    

    return "";
  }
  
  public boolean areInstructionsLeft() {
    return pos<instructions.length();
  }
  
  
  public void update() {
    if(areInstructionsLeft())
    {
      if(waitFor==0)
      {
        String val=getNextValue();
        String beforeColon="";
        String afterColon="";
        boolean foundColon=false;
        for(int i=0;i<val.length();i++)
        {
          if(!foundColon)
          {
      	    if(val.charAt(i)==':')
      	    {
              foundColon=true;
      	    }
        
      	    else
      	    {
        	  beforeColon+=val.charAt(i);
      	    }
        
          }
          else
          {
            afterColon+=val.charAt(i);
          }
        }
    
        if(foundColon)
        {
          if(afterColon.equals("true"))
          {
            buttonValues.setValue(beforeColon,true);
          }
          else if(afterColon.equals("false"))
          {
            buttonValues.setValue(beforeColon,false);
          }
          else
          {
            stickValues.setValue(beforeColon,Double.parseDouble(afterColon));
          }
          
          update();
        }
        else
        {
          waitFor=Integer.parseInt(beforeColon)-1;
        }
    
      } 
    
      else
      {
        waitFor-=1;
      }
    }
    else 
    {
      if(waitFor>0)
      {
        waitFor-=1;
      }
      else
      {
        buttonValues.reset();
        stickValues.reset();
      }
    }
    
   }
  

  
  public double leftStickY() {
    return stickValues.getValue(StickValues.leftStickY);
  }
  
  public double leftStickX() {
    return stickValues.getValue(StickValues.leftStickX);
  }
  
  public double rightStickY() {
    return stickValues.getValue(StickValues.rightStickY);
  }
  
  public double rightStickX() {
    return stickValues.getValue(StickValues.rightStickX);
  }
  
  public boolean buttonA() {
    return buttonValues.getValue(ButtonValues.buttonA);
  }
  
  public boolean buttonB() {
    return buttonValues.getValue(ButtonValues.buttonB);
  }
  
  public boolean buttonX() {
    return buttonValues.getValue(ButtonValues.buttonX);
  }
  
  public boolean buttonY() {
    return buttonValues.getValue(ButtonValues.buttonY);
  }
  
  public boolean dpadUp() {
    return buttonValues.getValue(ButtonValues.dpadUp);
  }
  
  public boolean dpadDown() {
    return buttonValues.getValue(ButtonValues.dpadDown);
  }
  
  public boolean dpadLeft() {
    return buttonValues.getValue(ButtonValues.dpadLeft);
  }
  
  public boolean dpadRight() {
    return buttonValues.getValue(ButtonValues.dpadRight);
  }
  
}
