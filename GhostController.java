public class GhostController {
  ControllerValues values=new ControllerValues();
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
          values.setStickValue(beforeColon,Double.parseDouble(afterColon));
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
      values.setStickValue(ControllerValues.leftStickX,0);
      values.setStickValue(ControllerValues.leftStickY,0);
      values.setStickValue(ControllerValues.rightStickX,0);
      values.setStickValue(ControllerValues.rightStickY,0);
      }
    }
    
   }
  

  
  public double getLStickY() {
    return values.getStickValue(ControllerValues.leftStickY);
  }
  
  public double getLStickX() {
    return values.getStickValue(ControllerValues.leftStickX);
  }
  
  public double getRStickY() {
    return values.getStickValue(ControllerValues.rightStickY);
  }
  
  public double getRStickX() {
    return values.getStickValue(ControllerValues.rightStickX);
  }
  
}
