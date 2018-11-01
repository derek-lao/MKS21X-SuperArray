public class SuperArray{

  private String[] data;
  private int size;

  public SuperArray(){
    data=new String[10];
    size=0;
    //System.out.println("The data.length is currently: "+data.length);
  }

  public SuperArray(int startingCapacity){
    // if(startingCapacity==0)
    // {
    //   data=new String[startingCapacity*2+1];
    // }
    // else
    // {
      if (startingCapacity<0)
      {
        throw new IllegalArgumentException();
      }
      data=new String[startingCapacity];
    // }
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

    // System.out.println("My size is: "+size);
    // System.out.println("My data.length is: "+data.length);
    if (data.length==size)
    {
      this.resize();
    }
    data[size]=element;

    size++;
    // System.out.println("My size is now: "+size);
    // System.out.println("My data.length is now: "+data.length);
    return true;
  }

  public boolean isEmpty(){
    return this.size()==0;
  }

  public String toString(){
    String stringofelements="[";
    for (int i=0;i<size()-1;i++)
    {
      stringofelements+=(data[i]+", ");
    }
    stringofelements+=(data[size()-1]+"]");
    return stringofelements;
  }

  public String toStringDebug(){

    String stringofelements="[";
    for (int i=0;i<data.length;i++)
    {
      if (data[i]!=null)
      {
        stringofelements+=(data[i]+"");
        if (i != data.length-1)
        {
          stringofelements+=", ";
        }
      }
      if (data[i]==null)
      {
        stringofelements+=(null+"");
        if (i != data.length-1)
        {
          stringofelements+=", ";
        }
      }
    }
    stringofelements+="]";
    return stringofelements;
  }

  public String get(int index){
    if (index < 0 || index >= size())
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
    if (index < 0 || index >= size)
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
    return indexOf(target)!=-1;
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
    for(int i=size-1;i>-1;i-=1)
    {
      if (data[i].equals(element))
      {
        return i;
      }
    }
    return -1;
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

  public void add(int index, String element){
    String[] listafter=new String[size];
    // System.out.println("My size is: "+size);
    // System.out.println("My data.length is: "+data.length);
    if (index < 0 || index > size)
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
    else
    {
      if(size==data.length)
      {
        resize();
      }
      for(int i=size;i>index;i-=1)
      {
        data[i]=data[i-1];
      }
      data[index]=element;
      size++;
    }
    // System.out.println("My size is now: "+size);
    // System.out.println("My data.length is now: "+data.length);
  }

  public String remove(int index){
    String answer=data[index];
    if (index < 0 || index >= size)
    // {
    //   System.out.println("Error: Index is out of range");
    // }
    {
      throw new IndexOutOfBoundsException();
    }
    else
    {
      for (int i=index;i<size;i++)
      {
        if(i==size-1)
        {
          data[i]=null;
        }
        else
        {
          data[i]=data[i+1];
        }
      }
    }
    size-=1;
    return answer;
  }

  public boolean remove(String element){
    for(int i=0;i<size;i++)
    {
      if (data[i].equals(element))
      {
        remove(i);
        return true;
      }
    }
    size-=1;
    return false;
  }


}
