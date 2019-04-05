/*public class driver {
  //BORROWED AND EDITED FROM GOODLE GROUP : Pratham Rawat
    public static void main(String[] args) {
        //What's poppin' everybody, welcome to my driver, we chill here in the code house
        //Let's test this class and get this bread

        //Step One: Creating a valid Instance
        System.out.println("######################");
        System.out.println("##New Instance Test:##");
        System.out.println("######################");
        MyLinkedList list = new MyLinkedList();
        System.out.println(list);
        System.out.println("This should print: \"[]\"\n");

        //Step Two: Let's add some values
        System.out.println("#######################");
        System.out.println("##Adding Values Test:##");
        System.out.println("#######################");
        for(int i = 0; i < 10; i++) {
            list.add(i);
            //System.out.println(list.size()); <- Debugging
        }
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");

        System.out.println(list.toStringReverse());
        System.out.println("reverse : This should print: \"[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]\"");

        //Step Three: Adding a value to the middle
        System.out.println("#####################################");
        System.out.println("##Adding Values in the Middle Test:##");
        System.out.println("#####################################");
        list.add(5, 999);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 999, 5, 6, 7, 8, 9]\"");

        //Step Four: Removing a value from the list by index
        System.out.println("##########################");
        System.out.println("##Removing a Value Test:##");
        System.out.println("##########################");
        list.remove(5);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");

        //Step Five: Remove a value from the list by value
        System.out.println("#####################################");
        System.out.println("##Remove a Value by its Value Test:##");
        System.out.println("#####################################");
        list.remove((Integer) 9);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8]\"");

        //Step Six: Testing the Contains Method
        System.out.println("##############################");
        System.out.println("##Checking Containment Test:##");
        System.out.println("##############################");
        System.out.println(list.contains((Integer) 999));
        System.out.println("This should print: false");

        System.out.println("##############################");
        System.out.println("##Checking Containment Test:##");
        System.out.println("##############################");
        System.out.println(list.contains((Integer) 6));
        System.out.println("This should print: true");

        //Step Seven: Testing the Size Method
        System.out.println("##############");
        System.out.println("##Size Test:##");
        System.out.println("##############");
        System.out.println(list.size());
        System.out.println("This should print: 9");

        //Step Eight: indexOf Method
        System.out.println("########################");
        System.out.println("##Index of Value Test:##");
        System.out.println("########################");
        System.out.println(list.indexOf(0));
        System.out.println("This should print: 0");

        System.out.println(list);

        //Step Nine: Exception Testing
        System.out.println("######################");
        System.out.println("##Exception Testing:##");
        System.out.println("######################");
        try {
            list.remove(-1);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Removing a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
            System.out.println(list);
        }
        try {
            list.remove(9000);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Removing an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.add(-1, (Integer) 9);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Adding to a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.add(90000, (Integer) 69);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Adding to an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.set(-1, (Integer) 9);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Setting a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.set(90000, (Integer) 69);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Setting an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.get(-1);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Getting a negative index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }
        try {
            list.get(90000);
        } catch(IndexOutOfBoundsException B) {
            System.out.println("Getting an oversized index throws the correct exception");
        } catch(Exception e) {
            System.out.println("Incorrect Exception Thrown:");
            e.printStackTrace();
        }

        System.out.println(list);

        //Step 10: Edge Case Testing
        System.out.println("######################");
        System.out.println("##Edge-Case Testing:##");
        System.out.println("######################\n");

        System.out.println("Removing Last Element:");
        System.out.println(list);
        System.out.println(list.size());
        list.remove(8);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("This should print: [0, 1, 2, 3, 4, 5, 6, 7]\n");

        System.out.println("Removing First Element:");
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("This should print: [1, 2, 3, 4, 5, 6, 7]\n");

        System.out.println("Adding to Last Element:");
        System.out.println(list.size());
        list.add(7, (Integer) 8);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("This should print: [1, 2, 3, 4, 5, 6, 7, 8]\n");

        System.out.println("Adding to First Element:");
        list.add(0, (Integer) 666);
        System.out.println(list);
        System.out.println("This should print: [666, 1, 2, 3, 4, 5, 6, 7, 8]\n");

        System.out.println(list.toStringReverse());
        System.out.println("reverse : This should print: \"[8, 7, 6, 5, 4, 3, 2, 1, 666]\"");


        //Step 11: Extend Testing
        System.out.println("######################");
        System.out.println("##Extend Testing:##");
        System.out.println("######################\n");

        MyLinkedList list2 = new MyLinkedList();

        for(int i = 9; i > -1; i--) {
            list2.add(i);
            //System.out.println(list.size()); <- Debugging
        }
        System.out.println(list2);
        System.out.println("This should print: \"[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]\"");

        list.extend(list2);

        System.out.println(list);
        System.out.println("This should print: \"[666, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]\"");

        System.out.println(list.toStringReverse());
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 666]\"");

        System.out.println(list2);
        System.out.println("This should print: \"[]\"");


    }
}*/

import java.util.Arrays;
public class driver{
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}

/*
public class driver{
  public static void main(String[]args){
    int[] testing = new int[]{1,2,0,0,-12,-1,55,10, -52,32,-10, 21, 41, -100,10};
    for (int i = 0; i < testing.length; i++){
      System.out.print(testing[i] + ", ");
    }
    System.out.println();
    System.out.println();
    Radix.radixsort(testing);
    for (int i = 0; i < testing.length; i++){
      System.out.print(testing[i] + ", ");
    }
    System.out.println();

  }
}*/
