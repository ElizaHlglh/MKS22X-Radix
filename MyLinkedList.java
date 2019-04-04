public class MyLinkedList{
  public class Node{
      private Integer data;
      private Node next,prev;

      public Node(Integer value) {//might not have constructor
        data = value;
        next = null;
        prev = null;
      }

      public Node next(){
        return next;
      }

      public Node prev(){
        return prev;
      }

      public void setNext(Node other){
        next = other;
      }

      public void setPrev(Node other){
        prev = other;
      }

      public Integer getData(){
        return data;
      }

      public Integer setData(Integer i){
        Integer old = data;
        data = i;
        return old;
      }

      public String toString(){
        return data + "";
      }

  }
    private int length;
    private Node start,end;

    public MyLinkedList(){
      length = 0;
      start = null;
      end = null;
    }

    public int size(){
      return length;
    }

    public boolean add(Integer value){
      if (length == 0){
        Node create = new Node(value);
        start = create;
        end = create;
        length++;
      }
      else{
        Node create = new Node(value);
        create.setPrev(end);
        end.setNext(create);
        end = create;
        length++;
      }
      return true;
    }

    public String toString(){
      String ans = "[";
      Node current = start;
      for (int i = 0; i < length-1; i++){
        ans += current.getData() + ", ";
        current = current.next();
      }
      if (length == 0){
        return ans + "]";
      }
      else{
        return ans + current.getData() + "]";
      }
    }

    public String toStringReverse(){
      String ans = "[";
      Node current = end;
      for (int i = length; i > 1; i--){
        ans += current.getData() + ", ";
        current = current.prev();
      }
      if (length == 0){
        return ans + "]";
      }
      else{
        return ans + current.getData() + "]";
      }
    }

    private Node getNode(int index){
      Node current = start;
      for (int i = 0; i < index && current != null; i++){
        current = current.next();
      }
      return current;
    }

    public Integer get(int index){
      if (index >= length || index < 0){
        throw new IndexOutOfBoundsException("Invalid index!!!");
      }
      else{
        Node current = getNode(index);
        if (current != null){
          return current.getData();
        }
        else{
          return null;
        }
      }
    }

    public Integer set(int index, Integer value){
      if (index >= length || index < 0){
        throw new IndexOutOfBoundsException("Invalid index!!!");
      }
      else{
        Node ToChange = getNode(index);
        return ToChange.setData(value);
      }
    }

    public boolean contains(Integer value){
      Node current = start;
      while (current != null){
        if (current.getData() == value){
          return true;
        }
        current = current.next();
      }
      return false;
    }

    public int indexOf(Integer value){
      Node current = start;
      int count = 0;
      while (current != null){
        if (current.getData() == value){
          return count;
        }
        current = current.next();
        count++;
      }
      return -1;
    }

    public void add(int index, Integer value){
      if (index > length || index < 0){
        throw new IndexOutOfBoundsException("Invalid index!!!");
      }
      else{
        Node ToAdd = new Node(value);
        if (end == getNode(index-1)){ //add at the end
          end.setNext(ToAdd);
          ToAdd.setPrev(end);
          ToAdd.setNext(null);
          end = ToAdd;
          length++;
        }
        else if (start == getNode(index)){ //add at the front
          if (start == end){
            start.setNext(ToAdd);
            ToAdd.setPrev(start);
            ToAdd.setNext(null);
            end = ToAdd;
            length++;
          }
          else{
            start.setPrev(ToAdd);
            ToAdd.setPrev(null);
            ToAdd.setNext(start);
            start = ToAdd;
            length++;
          }
        }
        else{
          Node before = getNode(index-1);
          Node After = getNode(index);
          before.setNext(ToAdd);
          ToAdd.setPrev(before);
          ToAdd.setNext(After);
          After.setPrev(ToAdd);
          length++;
        }
      }
    }

    public Integer remove(int index){
      if (index >= length || index < 0){
        throw new IndexOutOfBoundsException("Invalid index!!!");
      }
      else{
        Node toRemove = getNode(index);
        if (end == toRemove){
          Node Before = toRemove.prev();
          Before.setNext(null);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          end = Before;
          length--;
          return toRemove.getData();
        }
        else if(start == toRemove){
          Node After = toRemove.next();
          start = After;
          After.setPrev(null);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          length--;
          return toRemove.getData();
        }
        else{
          Node Before = toRemove.prev();
          Node After = toRemove.next();
          Before.setNext(After);
          After.setPrev(Before);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          length--;
          return toRemove.getData();
        }
      }
    }

    public boolean remove(Integer value){
      if (contains(value)){
        int index = indexOf(value);
        Node toRemove = getNode(index);
        if (end == toRemove){
          Node Before = toRemove.prev();
          Before.setNext(null);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          end = Before;
          length--;
          return true;
        }
        else if(start == toRemove){
          Node After = toRemove.next();
          start = After;
          After.setPrev(null);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          length--;
          return true;
        }
        else{
          Node Before = toRemove.prev();
          Node After = toRemove.next();
          Before.setNext(After);
          After.setPrev(Before);
          toRemove.setPrev(null);
          toRemove.setNext(null);
          length--;
          return true;
        }
      }
      else{
        return false;
      }
    }

    public void clear(){
      length = 0;
      start = null;
      end = null;
    }

    public void extend(MyLinkedList other){
        //in O(1) runtime, move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
        if (other.size() != 0){
          if (length == 0){ //if the current link is empty
            start = other.getNode(0);
            end = other.getNode(other.size()-1);
            length += other.size();
            other.clear();
          }
          else{
            Node startOther = other.getNode(0);
            end.setNext(startOther);
            startOther.setPrev(end);
            end = other.getNode(other.size()-1);
            length += other.size();
            other.clear();
          }
        }

    }

}
