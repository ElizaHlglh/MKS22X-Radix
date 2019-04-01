import java.lang.Math;
public class Radix{
  public static void radixsort(int[]data){
    int max = largest(data);
    int maxUnit = 0;
    while (max/(Math.pow(10, maxUnit)) != 0){
      maxUnit++;
    }
  }

  public static int largetst(int[] data){
    int ans = data[0];
    for (int i = 0; i<data.length; i++){
      if (data[i]>=ans){
        ans = data[i];
      }
    }
    return ans;
  }
}
