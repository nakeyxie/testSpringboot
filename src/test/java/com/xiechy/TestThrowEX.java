/**
 * @author xiechy
 * @create 2018-01-02
 * @Descrption
 **/
public class TestThrowEX {

    public static void main(String[] args) {
        int j=1;
        for (int i=0;i<99;i++) {
            if(i%2==0){
                j++;
            }
        }
        if(j>20){
            test();
        }
    }

    private static void test() {
        throw new BusinessException(ErrorCode.error_column_unique);
    }


}




    
