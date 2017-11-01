class ControllerValues {
  
  public final static String leftStickY="ly";
  public final static String rightStickY="ry";
  public final static String leftStickX="lx";
  public final static String rightStickX="rx";
 
  private double[] values={0,0,0,0};
  private double[] previousValues={0,0,0,0};
  private String[] stickSymbols={leftStickY,rightStickY,leftStickX,rightStickX}; 
  
  public boolean isStick(String symbol) {
    for(int i=0;i<stickSymbols.length;i++)
    {
      if(symbol==stickSymbols[i])
      {
        return true;
      }
    }
    return false;
  }
  
  
  public void setStickValue(String symbol,double value) {
    for(int i=0;i<stickSymbols.length;i++)
    {
      if(symbol.equals(stickSymbols[i]))
      {
        
        values[i]=value;
      }
    }
  }
  
  public double getStickValue(String symbol) {
    double val=0;
    for(int i=0;i<stickSymbols.length;i++)
    {
      if(symbol.equals(stickSymbols[i]))
      {
        val=values[i];
      }
    }
    previousValues=values.clone();
    return val;
  }
  
  public ArrayList<String> getSymbolsOfChanged() {
    ArrayList<String> syms=new ArrayList<String>();
    for(int i=0;i<values.length;i++)
    {
      if(previousValues[i]!=values[i])
      {
        
        syms.add(stickSymbols[i]);
      }
    }
    return syms;
  }
  
}
