package com.example;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLong;

public class AutoIncrease {
}



class IdGeneration {
    /**
     * 构造私有
     */
    private IdGeneration() {

    }



    private static  IdGeneration idGeneration = new IdGeneration();


    public static IdGeneration getIdGeneration() {
        return idGeneration;
    }



    /**
     * 根据时间戳生成唯一id
     */
    public String getId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return sdf.format(System.currentTimeMillis());
    }

}

class Test11 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String id = IdGeneration.getIdGeneration().getId();
            System.out.println(id);
        }
    }
}