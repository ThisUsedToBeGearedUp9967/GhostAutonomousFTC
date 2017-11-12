public class ControllerValues<T> {
  
  private T defaultValue;
  private ArrayList<T> values;
  private ArrayList<T> previousValues;
  private ArrayList<String> symbols;
  
  
  public ControllerValues(T defaultVal,ArrayList<T> vals,ArrayList<String> syms) {
    defaultValue=defaultVal;
    values=new ArrayList<T>(vals);
    previousValues=new ArrayList<T>(vals);
    symbols=syms;
    
  }
  
  
  public void setValue(String symbol,T value) {
    for(int i=0;i<symbols.size();i++)
    {
      if(symbol.equals(symbols.get(i)))
      {
        
        values.set(i,value);
      }
    }
  }
  
  public T getValue(String symbol) {
    T val=defaultValue;
    for(int i=0;i<symbols.size();i++)
    {
      if(symbol.equals(symbols.get(i)))
      {
        val=values.get(i);
      }
    }
    previousValues=new ArrayList<T>(values);
    return val;
  }

  public ArrayList<String> getSymbolsOfChanged() {
    
    ArrayList<String> syms=new ArrayList<String>();
    for(int i=0;i<values.size();i++)
    {
      if(!previousValues.get(i).equals(values.get(i)))
      {
        
        syms.add(symbols.get(i));
      }
    }
    return syms;
  }
  
  public void reset() {
    for(int i=0;i<values.size();i++)
    {
      values.set(i,defaultValue);
    }
  }
}

