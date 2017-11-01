class CodeSharer {
  Context context;
  
  public CodeSharer(Context cxt) 
  {
    context=context;
  }
  
  public void share(String text) {
    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    String shareBody = StringUtil.codeForString(text);

    DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH:mm:ss");
    Date date = new Date();

    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "code_generated_"+dateFormat.format(date));
    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, codeForString(text));
    context.startActivity(sharingIntent);
    }
    
  private String codeForString(String str) {
    String newString="\"";
    int charsInLine=0;
    for(int i=0;i<str.length();i++)
    {
      
      newString+=str.charAt(i);
      charsInLine+=1;
      if(charsInLine>=80)
      {
        newString+="\"+\n\"";
        charsInLine=0;
      }
    }
    return newString+"\"";
  }
}
