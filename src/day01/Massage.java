package day01;

public class Massage {
    /*
    一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
    在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
    给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

    示例：
         输入： [2,7,9,3,1]
         输出： 12
         解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。*/

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(massage(nums));
    }

    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int notChoose = 0; //没选的时候最大的情况
        int choose = 0;    //选了之后最大的情况

        for (int num : nums) {
            int newNotChoose = Math.max(notChoose, choose); //更新 notChoose
            choose = Math.max(notChoose + num, choose);     //更新 choose
            notChoose = newNotChoose;                       //设定新的 notChoose
        }

        return Math.max(notChoose, choose);
    }
}
