package cn.asens;


import org.junit.Test;

public class LTest {
    @Test
    public void testSayHello() throws InterruptedException {
        int success = 0;
        int total = 10;
        int between = 50;
        String address = "https://www.baidu.com";

        for (int i = 0; i < total; i++) {
            String result = HttpUtil.get(address);
            if(result!=null && !result.equals("success")){
                success++;
            }
            Thread.sleep(between);
            System.out.println("success/total:"+success+"/"+total);
        }

        System.out.println("================================");
        System.out.println("total:"+total);
        System.out.println("success:"+success);
        System.out.println("================================");
    }
}
