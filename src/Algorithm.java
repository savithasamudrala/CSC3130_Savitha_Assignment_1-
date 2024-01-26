public class Algorithm {
    public Algorithm(){

    }

    //Question 1
    public int subsequence(String text1, String text2){
        int[][] sub = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    sub[i][j] = sub[i - 1][j - 1] + 1;
                } else {
                    sub[i][j] = Math.max(sub[i - 1][j], sub[i][j - 1]);
                }
            }
        }

        return sub[text1.length()][text2.length()];
    }


    //Question 3
    public void notFib(int input){
        if(input == 0){
            System.out.println("0");
            return;
        }
        if(input == 1){
            System.out.println("0, 1");
            return;
        }
        Long[] a = new Long[input];
        a[0] = 0L;
        a[1] = 1L;
        for(int i = 2; i < input; i++) {
            Long minusOne = a[i - 1];
            Long minusTwo = a[i - 2];
            a[i] = 2 * minusOne + 3 * minusTwo;
        }
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length-1]);
    }

    //Question 4
    public int where(int input){
        if(input == 0){
            return 1;
        }
        if(input == 1){
            return 2;
        }

        int pos = 3;
        int term1 = 0;
        int term2 = 1;
        int next = 0;

        while (true) {
            next = 2 * term2 + 3 * term1;
            if (input == next) {
                break;
            }
            if((input < next) && (input > term2)){
                pos--;
                break;
            }
            term1 = term2;
            term2 = next;
            pos++;
        }

        return pos;
    }

    //Question 5
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length-1]);
        return k;
    }

    public static void main (String args[]){
        //input
        Algorithm obj = new Algorithm();
        int []elements = {2,5,3,7,5,5,4,5,4,9,5};
        String a = "almanacs";
        String b = "albatross";
        int c = 10;
        int d = 2000;
        int e = 5;

        //Question 1:
        System.out.println("Question 1:");
        System.out.println("input: " + a + ". " + b);
        System.out.println("output: " + obj.subsequence(a, b) + "\n");

        //Question 3:
        System.out.println("Question 3:");
        System.out.println("input: " + c);
        System.out.print("output: ");
        obj.notFib(c);
        System.out.println("");

        //Question 4:
        System.out.println("Question 4:");
        System.out.println("input: " + d);
        System.out.println("output: " + obj.where(d) + "\n");

        //Question 5:
        System.out.println("Question 5:");
        System.out.println("input: ");
        for (int i = 0; i < elements.length-1; i++) {
            System.out.print(elements[i] + ", ");
        }
        System.out.println(elements[elements.length-1]);
        System.out.println(e);
        System.out.println("output: ");
        System.out.println(obj.removeElement(elements,e));
    }
}
