package com.xiechy;
/**
 * @author xiechy
 * @create 2017-12-29
 * @Descrption
 **/
public class TestNewClass {
    public static void main(String[] args) {
        int i=1;
        String j="tt";
        test2(i,j);
        getSuffixCode(getNull());
    }

    /**
     *
     * @param i
     * @param j
     */
    private static void test2(int i, String j) {
    }

    private static Integer test1() {
        return 1==3?1:null;
    }

    public static Integer getNull(){
     return  test1();
    }

    public static String getSuffixCode(Integer labIndex){
        String suffix;
        switch (labIndex){
            case 0:suffix = "";break;
            case 1:suffix = "A";break;
            case 2:suffix = "B";break;
            case 3:suffix = "C";break;
            case 4:suffix = "D";break;
            default:suffix = "A";break;
        }
        return suffix;
    }


}




    
        