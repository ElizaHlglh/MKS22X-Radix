import java.lang.Math;
public class Radix{
  public static void radixsort(int[]data){
    int max = largestUnit(data);
    //System.out.println("max is : " + max);
    int maxUnit = 0;
    while (max/((int) Math.pow(10, maxUnit)) != 0){
      //System.out.println("max/(Math.pow(10, maxUnit)) == " + max/(Math.pow(10, maxUnit)));
      maxUnit++;
    }
    //System.out.println("maxUnit is : " + maxUnit);
    //maxUnit will be the number of time for the loop of sorting by each units to go through
    MyLinkedList[] budget = new MyLinkedList[20];//the final array
    for (int j = 0; j < budget.length; j++){
      budget[j] = new MyLinkedList(); //initialize all the list in the budgets
    }
    for (int exp = 1; exp <= maxUnit; exp++){
      //MyLinkedList[] budgets = new MyLinkedList[20];//individual budges of each unit
      for (int i = 0; i < data.length; i++){//at 10^maxUnit, the largest value in this will have
        int digit = (data[i]% (int) (Math.pow(10, exp)))/( (int) Math.pow(10, exp-1));
        if (data[i] < 0){//if it is a negative number
          budget[9-Math.abs(digit)].add(data[i]);
        }
        else{
          budget[digit+10].add(data[i]);
        }
      }
      System.out.println(debugBudget(budget));
      System.out.println();
      MyLinkedList result = new MyLinkedList(); //merge all list in the budget into a whole list
      for (int k = 0; k < budget.length; k++){
        result.extend(budget[k]);
      }
      //edit data to equal to the list
      for (int l = 0; l < data.length; l++){
        data[l] = result.get(l);
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

  public static String debugBudget(MyLinkedList[] budget){
    String ans = "";
    for (int i = 0; i < budget.length; i++){
      ans += i + ": " + budget[i] + "\n";
    }
    return ans;
  }
}
