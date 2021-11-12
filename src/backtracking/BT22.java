package backtracking;

import stackandqueue.TwoStack;

public class BT22 {
    public static void main(String[] args) {
        TwoStack ts= new TwoStack(10);
        ts.push1(2);
        ts.push1(3);
        ts.push2(4);
        System.out.println(ts.pop1());
        System.out.println(ts.pop2());
        System.out.println(ts.pop2());
    }
}
