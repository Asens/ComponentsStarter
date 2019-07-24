package cn.asens;


import org.junit.Test;

public class LTest {
    @Test
    public void testSayHello() throws InterruptedException {
        int success = 0;
        int total = 10000;
        int between = 500;
        String address = "http://localhost";
        long start = System.currentTimeMillis();

        for (int i = 1; i < total; i++) {
            String result = HttpUtil.get(address);
            if(result!=null && !result.equals("success")){
                success++;
            }
            Thread.sleep(between);
            System.out.println(((System.currentTimeMillis()-start)/1000.0)+"s   " +
                    "success/run:"+success+"/"+i);
        }

        System.out.println("================================");
        System.out.println("total:"+total);
        System.out.println("success:"+success);
        System.out.println("================================");
    }
}
