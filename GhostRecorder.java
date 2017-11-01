public class GhostRecorder {
  private String instructions="";
  private int updatesSinceValueChanged=0;
  private ControllerValues values=new ControllerValues();
  
  public GhostRecorder() {
  }
  
  public void recordLStickY(double lsticky) {
    values.setStickValue(ControllerValues.leftStickY,lsticky);
  }
    
  public void recordRStickY(double rsticky) {
    values.setStickValue(ControllerValues.rightStickY,rsticky);
  }
  
  public void recordLStickX(double lstickx) {
    values.setStickValue(ControllerValues.leftStickX,lstickx);
  }
    
  public void recordRStickX(double rstickx) {
    values.setStickValue(ControllerValues.rightStickX,rstickx);
  }
  
  public void update() {
    
    boolean foundChange=false;
    String line="";
    ArrayList<String> syms=values.getSymbolsOfChanged();
    for(int i=0;i<syms.size();i++)
    {
      line+=syms.get(i)+":"+values.getStickValue(syms.get(i));
      if(i<syms.size()-1)
      {
        line+=" ";
      }
    }
    
    if(syms.size()>0)
    {
      if(updatesSinceValueChanged>0)
      {
        instructions+=" "+String.valueOf(updatesSinceValueChanged)+" ";
      }
      instructions+=line;
      updatesSinceValueChanged=0;
    }
    
    updatesSinceValueChanged+=1;
    
  }
    
  
  public String getString() {
    return instructions+" "+String.valueOf(updatesSinceValueChanged);
  }
}

