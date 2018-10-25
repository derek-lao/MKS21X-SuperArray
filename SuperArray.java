public class SuperArray{

  private String[] data;
  private int size;

  public SuperArray(){
    data=new String[10];
  }

  public void clear(){
    size=0;
  }

  public int size(){
    int theSize=0;
    for(int i=0;i<data.length;i++)
    {
      if (data[i]!=null)
      {
        theSize++;
      }
    }
    return theSize;
  }

  public boolean add(String value){
    data[size]=value;
    size++;
    return true;
  }

  public boolean isEmpty(){
    return this.size()==0;
  }

  public String toString(){
    String stringofvalues="";
    for (int i=0;i<data.length-1;i++)
    {
      stringofvalues+=(data[i]+", ");
    }
    stringofvalues+=(data[data.length-1]+"]");
    return stringofvalues;
  }



}
