
public class GhostRecorder {
  private String instructions="";
  private int updatesSinceValueChanged=0;
  private StickValues stickValues=new StickValues();
  private ButtonValues buttonValues=new ButtonValues();
  
  public GhostRecorder() {
  }
  
  public void recordLeftStickY(double lsticky) {
    stickValues.setValue(StickValues.leftStickY,lsticky);
  }
    
  public void recordRightStickY(double rsticky) {
    stickValues.setValue(StickValues.rightStickY,rsticky);
  }
  
  public void recordLeftStickX(double lstickx) {
    stickValues.setValue(StickValues.leftStickX,lstickx);
  }
    
  public void recordRightStickX(double rstickx) {
    stickValues.setValue(StickValues.rightStickX,rstickx);
  }
  
  public void recordButtonX(boolean val) {
    buttonValues.setValue(ButtonValues.buttonX,val);
  }
  
  public void recordButtonY(boolean val) {
    buttonValues.setValue(ButtonValues.buttonY,val);
  }
  public void recordButtonA(boolean val) {
    buttonValues.setValue(ButtonValues.buttonA,val);
  }
  public void recordButtonB(boolean val) {
    buttonValues.setValue(ButtonValues.buttonB,val);
  }
  public void recordDpadUp(boolean val) {
    buttonValues.setValue(ButtonValues.dpadUp,val);
  }
  public void recordDpadDown(boolean val) {
    buttonValues.setValue(ButtonValues.dpadDown,val);
  }
  public void recordDpadLeft(boolean val) {
    buttonValues.setValue(ButtonValues.dpadLeft,val);
  }
  public void recordDpadRight(boolean val) {
    buttonValues.setValue(ButtonValues.dpadRight,val);
  }
  
  public String getStringOfChangedVals(ControllerValues vals)
  {
    String line="";
    @SuppressWarnings("unchecked")
    ArrayList<String> syms=vals.getSymbolsOfChanged();
    for(int i=0;i<syms.size();i++)
    {
      line+=syms.get(i)+":"+vals.getValue(syms.get(i));
      line+=" ";
    }
    return line;
  }
  
  public void update() {
    
    String line=getStringOfChangedVals(stickValues)+getStringOfChangedVals(buttonValues);
    if(!line.equals(""))
    {
      if(updatesSinceValueChanged>0)
      {
        instructions+=String.valueOf(updatesSinceValueChanged)+" ";
      }
      instructions+=line;
      updatesSinceValueChanged=0;
    }
    
    updatesSinceValueChanged+=1;
    
  }
    
  
  public String getString() {
    return instructions+String.valueOf(updatesSinceValueChanged);
  }
}


