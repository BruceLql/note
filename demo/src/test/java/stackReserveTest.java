import java.util.Stack;

/**
 * @author 李启岚(起冉)
 */
public class stackReserveTest {
    private static Stack<Integer> stack = new Stack();

    /**
     * 使用递归来完成一个栈的逆序操作。
     * 不能借助任何其他数据结构。
     */
    public static void initData() {
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
    }

//    // 递归取栈底
//    public static int getLastNumAndRemove(Stack<Integer> stack) {
//        Integer num = stack.pop();
//        if (stack.isEmpty()) {
//            return num;
//        }
//        int lastNumAndRemove = getLastNumAndRemove(stack);
//        stack.push(num);
//        return lastNumAndRemove;
//    }
//
//    // 递归把最后栈上的一个数据入栈
//    public static void setStackReverse(Stack<Integer> stack) {
//
//        if (stack.isEmpty()) {
//            return ;
//        }
//        int lastNumAndRemove = getLastNumAndRemove(stack);
//        setStackReverse(stack);
//        stack.push(lastNumAndRemove);
//
//    }

    public static void main(String[] args) {
        initData();
        System.out.println(stack);
        setStackReverse(stack);
        System.out.println(stack);

    }
    // 逆序存入栈
    public static void setStackReverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int lastAndRemoveStack = getLastAndRemoveStack(stack);
        setStackReverse(stack);
        stack.push(lastAndRemoveStack);

    }

    //取栈尾数据
    public static int getLastAndRemoveStack(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }
        int lastAndRemoveStack = getLastAndRemoveStack(stack);
        stack.push(pop);
        return lastAndRemoveStack;
    }

}
