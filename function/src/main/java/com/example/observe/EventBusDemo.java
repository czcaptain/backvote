package com.example.observe;

import com.google.common.eventbus.EventBus;

public class EventBusDemo {

    private EventBus eventBus;





    public void test() {
        eventBus.register(null);
        eventBus.register(null);
        eventBus.post(null);




    }



}

