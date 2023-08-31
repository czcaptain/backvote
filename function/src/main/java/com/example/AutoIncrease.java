package com.example;
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

    private AtomicLong id  = new AtomicLong(0);

    private static  IdGeneration idGeneration = new IdGeneration();


    public static IdGeneration getIdGeneration() {
        return idGeneration;
    }


    public Long getIncreaseId() {
        return id.incrementAndGet();
    }

}