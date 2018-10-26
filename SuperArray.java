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

  public boolean add(String element){
    data[size]=element;
    size++;
    return true;
  }

  public boolean isEmpty(){
    return this.size()==0;
  }

  public String toString(){
    String stringofelements="";
    for (int i=0;i<data.length-1;i++)
    {
      stringofelements+=(data[i]+", ");
    }
    stringofelements+=(data[data.length-1]+"]");
    return stringofelements;
  }

  // public String toStringDebug(){
  //
  // }

  public String get(int index){
    if(index<0||index>=size)
    {
      return null;
    }
    return data[index];
  }

  public String set(int index, String element){
    String prevElement;
    if(index<0||index>=size)
    {
      return null;
    }
    prevElement=data[index];
    data[index]=element;
    return prevElement;
  }

  private void resize(){
    String[] prevarray=data;
    data=new String[size+10];
    for(int i=0;i<prevarray.length;i++)
    {
      data[i]=prevarray[i];
    }
  }

}
