public class SuperArray{

  private String[] data;
  private int size;

  public SuperArray(){
    data=new String[10];
  }

  public SuperArray(int startingCapacity){
    if(startingCapacity==0)
    {
      data=new String[startingCapacity*2+1];
    }
    else
    {
      data=new String[startingCapacity];
    }
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
    String stringofelements="[";
    for (int i=0;i<data.length-1;i++)
    {
      stringofelements+=(data[i]+", ");
    }
    stringofelements+=(data[data.length-1]+"]");
    return stringofelements;
  }

  public String toStringDebug(){
    String stringofelements="";
    for (int i=0;i<data.length-1;i++)
    {
      if (data[i]!=null)
      {
        stringofelements+=(data[i]+", ");
      }
      else
      {
        stringofelements+=(null+", ");
      }
    }
    stringofelements+=(data[data.length-1]+"]");
    return stringofelements;
  }

  public String get(int index){
    if (index < 0 || index > size())
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
    if(index<0||index>=size)
    {
      return null;
    }
    return data[index];
  }

  public String set(int index, String element){
    if (index < 0 || index > size())
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
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
    data=new String[size*2+1];
    for(int i=0;i<prevarray.length;i++)
    {
      data[i]=prevarray[i];
    }
  }

  public boolean contains(String target){
    boolean answer=false;
    for(int i=0;i<data.length;i++)
    if(data[i].equals(target))
    {
      answer=true;
    }
    return answer;
  }

  public int indexOf(String target){
    //method without break
    int answer=size;
    for(int i=0;i<answer;i++)
    {
      if(data[i].equals(target))
      {
        answer=i;
      }
    }
    if (answer==size)
    {
      answer=-1;
    }
    return answer;
  }

  // ALTERENATE METHOD FOR indexOf THAT USES BREAK.
  // I TRIED TO NOT USE BREAK IN THE PREVIOUS VERSION OF THE CODE
  // public int indexOf(String element){
  //   int answer=-1;
  //   for(int i=0;i<size;i++)
  //   {
  //     if(data[i].equals(element))
  //     {
  //       answer=i;
  //       break;
  //     }
  //   }
  //   return answer;
  // }

  public int lastIndexOf(String element){
    //method without break
    int answer=-1;
    for(int i=size;i>answer;i-=1)
    {
      if(data[i].equals(element))
      {
        answer=i;
      }
      if (answer==size)
      {
        answer=-1;
      }
    }
    return answer;
  }

  // ALTERENATE METHOD FOR lastIndexOf THAT USES BREAK.
  // I TRIED TO NOT USE BREAK IN THE PREVIOUS VERSION OF THE CODE
  // public int lastIndexOf(String element){
  //   int answer=-1;
  //   for(int i=0;i>size;i-=1)
  //   {
  //     if(data[i].equals(element))
  //     {
  //       answer=i;
  //       break;
  //     }
  //   }
  //   return answer;
  // }

  public void add(int index,String element){
    String[] listafter=new String[size+1];
    if (index < 0 || index > size())
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
    for(int i=index;i<size;i++)
    {
      listafter[i-index]=data[i];
    }
    this.add(element);
    for(int i=index+1;i<size;i++)
    {
      data[i]=listafter[i-index-1];
    }
  }

  public String remove(int index){
    if (index < 0 || index > size())
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
    String[] beforearray=new String[size-1];
    String[] afterarray=new String[size-1];
    String outcast=data[index];
    if(index < 0 || index >= size())
    {
      return null;
    }
    for(int i=0;i<index-1;i++)
    {
      beforearray[i]=data[i];
    }
    for(int i=index+1;i<size;i++)
    {
      afterarray[i-index-1]=data[i];
    }
    size=size-1;
    for(int i=0;i<index-1;i++)
    {
      this.add(beforearray[i]);
    }
    for(int i=index-1;i<size;i++)
    {
      this.add(afterarray[i-(index-1)]);
    }
    return outcast;
  }

  public boolean remove(String element){
    if(indexOf(element)>-1)
    {
      this.remove(element);
      return true;
    }
    else
    {
      return false;
    }
  }


}
