import java.lang.Math;
public class Radix{
  public static void radixsort(int[]data){
    int max = largestUnit(data);
    int maxUnit = 0;
    while (max/(Math.pow(10, maxUnit)) != 0){
      maxUnit++;
    }
    //maxUnit will be the number of time for the loop of sorting by each units to go through
    MyLinkedList[] budget = new MyLinkedList[20];//the final array
    for (int j = 0; j < budget.length; j++){
      budget[j] = new MyLinkedList(); //initialize all the list in the budgets
    }
    for (int exp = 1; exp <= maxUnit; exp++){
      //MyLinkedList[] budgets = new MyLinkedList[20];//individual budges of each unit
      for (int i = 0; i < data.length; i++){//at 10^maxUnit, the largest value in this will have
        int digit = (data[i]%(Math.pow(10, exp)))/(Math.pow(10, exp-1));
        if (data[i] < 0){//if it is a negative number
          budget[9-digit].add(data[i]);
        }
        else{
          budget[digit+10].add(data[i]);
        }
      }
    }
  }

  public static int largestUnit(int[] data){
    int ans = Math.abs(data[0]);
    for (int i = 0; i<data.length; i++){
      if (Math.abs(data[i]) >= ans){
        ans = Math.abs(data[i]);
      }
    }
    return ans;
  }
}
