package heapsort;

public class HeapSort {
    private static int [] ints={'x',3,11,5,6,1,3,4,33333,19,1,3,4,5,6,7,8,4,44,22,256,254};

    /**
     *
     * @param nodeNum 当前节点的序号
     * @param rightBoundary 堆调整的范围
     */
    /**
    public static void heapAdjust( int nodeNum , int rightBoundary ){
        //保证节点序号不越界
        //保证节点有子节点
        if( nodeNum > rightBoundary || nodeNum * 2 > rightBoundary)
            return;
        //查找当前节点两个子节点中的最大值（如果子节点只有一个也无妨）
        int maxNumBetweenChild;
        if(nodeNum*2+1>rightBoundary)
            maxNumBetweenChild=ints[nodeNum*2];
        else
            maxNumBetweenChild = ints[nodeNum*2]>ints[nodeNum*2+1]?ints[nodeNum*2]:ints[nodeNum*2+1];
        //判断当前节点和子节点的大小关系，适当做出互换位置的操作
        if(ints[nodeNum]<maxNumBetweenChild){
            int temp = ints[nodeNum];
            ints[nodeNum] = maxNumBetweenChild;
            if(maxNumBetweenChild == ints[nodeNum*2])
                ints[nodeNum*2] = temp;
            else
                ints[nodeNum*2+1] = temp;
        }
        else
            return;
        //对子节点进行递归操作
        heapAdjust(nodeNum*2,rightBoundary);
        heapAdjust(nodeNum*2+1,rightBoundary);
    }
    */
    public static void heapAdjust2(int nodeNum, int rightBoundary){
        for(int i = nodeNum ; i*2 <= rightBoundary;){
            int maxNumBetweenChild;
            if(i*2+1>rightBoundary)
                maxNumBetweenChild=ints[i*2];
            else
                maxNumBetweenChild = ints[i*2]>ints[i*2+1]?ints[i*2]:ints[i*2+1];
            if(ints[i]<maxNumBetweenChild){
                int temp = ints[i];
                ints[i] = maxNumBetweenChild;
                if(maxNumBetweenChild == ints[i*2]) {
                    ints[i * 2] = temp;
                    i*=2;
                }
                else {
                    ints[i * 2 + 1] = temp;
                    i=i*2+1;
                }
            }
            else
                break;
        }
    }
    public static void heapSort(){
        //对待排序的数组进行建堆操作
        //从下至上，从右至左
        for(int i=ints.length-1;i>=1;i--){
           // heapAdjust(i,ints.length-1);
           heapAdjust2(i,ints.length-1);
        }
        //最大值和最右叶子节点互换后
        //从上至下调整堆
        for(int i=ints.length-1;i>=1;i--){
            int temp = ints[1];
            ints[1] = ints[i];
            ints[i] = temp;
            for(int j:ints) {
                System.out.print(j+" ");
            }
            System.out.println();
            //heapAdjust(1,i-1);
            heapAdjust2(1,i-1);
        }
    }
    public static void main(String[] args){
        System.out.println("origin_arrays: ");
        for( int i : ints){
            System.out.print(i+" ");
        }
        System.out.println();
        heapSort();
    }
}
